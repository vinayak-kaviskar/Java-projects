/**
 * 
 */
package com.exam.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.todoapp.models.TaskDTO;
import com.exam.todoapp.services.TaskService;

/**
 * @author vinayakk5
 *
 */

@RestController
@CrossOrigin
public class ToDoAppController {

	@Autowired
	TaskService taskService;

	@GetMapping(value = "/getall/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	ResponseEntity<?> getToDoList(@PathVariable Integer userId) {

		return taskService.getAllTasks(userId);
	}

	@PostMapping(value = "/addtask") 
	@PreAuthorize("hasRole('ADMIN')")
	ResponseEntity<?> addNewTask(@RequestBody TaskDTO task) {

		return taskService.addTask(task);

	}

	@PutMapping(value = "/updatetask/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	ResponseEntity<?> updateTask(@PathVariable int id ,@RequestBody TaskDTO task) {

		return taskService.updateTask(id,task);

	}

	@DeleteMapping(value = "/deletetask/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	ResponseEntity<?> deleteTask(@PathVariable int id) {
		return taskService.deleteTask(id);
	}

}
