package com.exam.todoapp.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.exam.todoapp.models.Response;
import com.exam.todoapp.models.User;

public interface UserService {

	ResponseEntity<Response> save(User user);

	List<User> findAll();

	User findByEmail(String name);

}
