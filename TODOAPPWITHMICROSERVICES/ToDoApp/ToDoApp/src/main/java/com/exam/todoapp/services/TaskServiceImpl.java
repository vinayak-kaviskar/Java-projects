package com.exam.todoapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exam.todoapp.models.Response;
import com.exam.todoapp.models.Task;
import com.exam.todoapp.models.TaskDTO;
import com.exam.todoapp.models.User;
import com.exam.todoapp.repositories.TasksRepository;
import com.exam.todoapp.repositories.UserRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TasksRepository taskRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<?> getAllTasks(Integer userId) {

		try {
			List<Task> allTasksList = taskRepository.findByUserId(userId.longValue());
			return new ResponseEntity<List<Task>>(allTasksList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error occured while retrieving Tasks", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<?> addTask(TaskDTO task) {

		try {
			Optional<User> optionalUser = this.userRepository.findById(task.getUserId());

			if (optionalUser.isPresent()) {
				Task taskEntity = new Task();

				taskEntity.setIsCompleted(task.getIsCompleted());
				taskEntity.setIsNotified(task.getIsNotified());
				taskEntity.setTaskName(task.getTaskName());
				taskEntity.setReminderTime(task.getReminderTime());
				taskEntity.setUser(optionalUser.get());

				this.taskRepository.save(taskEntity);
				return new ResponseEntity<Response>(new Response("Task added successfullyh"), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Error occurred while adding task ",
						HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error occurred while adding task ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<?> updateTask(int id, TaskDTO task) {

		try {

			Optional<Task> currentTask = taskRepository.findById(id);

			if (currentTask.isPresent()) {

				Task taskEntity = new Task();
				taskEntity.setId(id);
				taskEntity.setIsCompleted(task.getIsCompleted());
				taskEntity.setIsNotified(task.getIsNotified());
				taskEntity.setTaskName(task.getTaskName());
				taskEntity.setReminderTime(task.getReminderTime());

				Optional<User> user = userRepository.findById(task.getUserId());
				if (user.isPresent()) {

					taskEntity.setUser(user.get());
					this.taskRepository.save(taskEntity);

				} else {
					return new ResponseEntity<String>("Error occurred while updating task ",
							HttpStatus.INTERNAL_SERVER_ERROR);
				}

				return new ResponseEntity<Response>(new Response("Task updated Successfully"), HttpStatus.OK);

			} else {
				return new ResponseEntity<String>("Error occurred while updating task ",
						HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>("Error occurred while updating task ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<?> deleteTask(int id) {

		try {
			Optional<Task> currentTask = taskRepository.findById(id);
			if (currentTask.isPresent()) {
				this.taskRepository.delete(currentTask.get());
				return new ResponseEntity<Response>(new Response("Task deleted Successfully"), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Error occurred while deleting task",
						HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>("Error occurred while deleting task ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
