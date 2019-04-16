package com.exam.todoapp.services;

import org.springframework.http.ResponseEntity;

import com.exam.todoapp.models.Task;
import com.exam.todoapp.models.TaskDTO;

public interface TaskService {

	ResponseEntity<?> getAllTasks(Integer userId);

	ResponseEntity<?> deleteTask(int id);

	ResponseEntity<?> addTask(TaskDTO task);

	ResponseEntity<?> updateTask(int id, TaskDTO task);

}
