package com.exam.todoapp.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.exam.todoapp.models.User;

public class JwtuserFactory {

	public static Jwtuser create(User user) {
		
		return new Jwtuser(user.getId(),user.getEmail(),user.getPassword(),user,maptoGrantedAuthorites(new ArrayList<String>(Arrays.asList("ROLE_"+user.getRole()))),user.isEnabled());
	}

	
	private static List<GrantedAuthority> maptoGrantedAuthorites(List<String> authorities){
		return authorities.stream().map(Authority -> new SimpleGrantedAuthority(Authority)).collect(Collectors.toList());
	}
}
