package com.exam.notify.schedule;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.exam.notify.models.Task;
import com.exam.notify.repositories.TasksRepository;

@Component
public class SendEmailsToUsers {

	@Autowired
	private TasksRepository tasksRepository;

	@Autowired
	private JavaMailSender sender;

	ExecutorService executorService = Executors.newFixedThreadPool(8);

	public void fetchTasks() {

		Timestamp startTime = new Timestamp(System.currentTimeMillis() - 300000);
		Timestamp endTime = new Timestamp(System.currentTimeMillis());

		List<Task> tasksList = this.tasksRepository.findByReminderTimeBetweenAndIsCompletedFalse(startTime, endTime);

		tasksList.forEach(currentTask -> {

			try {
				this.sendEmails(currentTask.getTaskName(), currentTask.getUser().getEmail());

				currentTask.setIsNotified(1);
				this.tasksRepository.save(currentTask);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		System.out.println(tasksList);

	}

	private void sendEmails(String taskName, String emailId) throws MessagingException {

		executorService.execute(() -> {

			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			try {
				helper.setTo(emailId);
				helper.setText(" Reminder for :" + taskName);
				helper.setSubject("To Do App Reminder");
				sender.send(message);

				System.out.println(Thread.currentThread().getName());
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

	}

}
