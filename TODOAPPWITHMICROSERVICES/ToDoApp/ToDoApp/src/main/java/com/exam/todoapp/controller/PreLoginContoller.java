package com.exam.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.todoapp.models.User;
import com.exam.todoapp.services.UserService;
import com.exam.todoapp.models.Response;

@RestController
public class PreLoginContoller {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/registration")
	ResponseEntity<Response> registerNewUser(@RequestBody User user) {

		return userService.save(user);
	}

}
