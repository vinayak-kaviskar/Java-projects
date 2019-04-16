package com.exam.todoapp.services;







import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.todoapp.models.User;
import com.exam.todoapp.models.Response;
import com.exam.todoapp.repositories.UserRepository;
import com.exam.todoapp.util.PasswordUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseEntity<Response> save(User user) {
		String password = PasswordUtil.getPasswordHash(user.getPassword());
		user.setPassword(password);
		user.setCreatedDate(new Date());
		
		User savedUser = userRepository.save(user);
		if(savedUser != null) {
			
			return new ResponseEntity<Response>(new Response("User addded successfully"),HttpStatus.OK);
		}
		
		return new ResponseEntity<Response>(new Response("Error occurred while adding user"),HttpStatus.INTERNAL_SERVER_ERROR); 
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailIgnoreCase(email);
	}
}
