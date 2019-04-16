package com.exam.notify.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationScheduler {

	@Autowired
	SendEmailsToUsers sendEmails; //= new SendEmailsToUsers();
	
	@Scheduled(cron = "${schedulerCronExpression}")
	public void scheduleNotifications() {
		System.out.println("In cron scheduler");
		sendEmails.fetchTasks();
		
		
		
	}
	
	
	
}
