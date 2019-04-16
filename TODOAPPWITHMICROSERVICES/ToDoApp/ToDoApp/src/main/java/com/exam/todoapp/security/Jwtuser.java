package com.exam.todoapp.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.exam.todoapp.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Jwtuser implements UserDetails{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4050605629166736104L;
	private final long id;
	private final String username;
	private final String password;
	private final User user;
	private final Collection<? extends GrantedAuthority> authorities;
	private final boolean enabled;
	public Jwtuser(long id, String username, String password, User user,
			Collection<? extends GrantedAuthority> authorities, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.user = user;
		this.authorities = authorities;
		this.enabled = enabled;
	}
	
	@JsonIgnore
	public long getId() {
		return id;
	}
	@Override
	public String getUsername()  {
		return username;
	}
	@Override
	public String getPassword() {
		return password;
	}
	public User getUser() {
		return user;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
}
