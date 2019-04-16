package com.exam.todoapp.interceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.todoapp.security.JwtTokenUtil;

public class AuthenticationTokenFilter extends OncePerRequestFilter
{
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	@Value("${jwt.header}")
	private String tokenHeader;
	
@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	response.setHeader("Access-Control-Allow-Origin", "*");
	response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	response.setHeader("Access-Control-Allow-Headers",
			"authorization, content-type, xsrf-token, Cache-Control, remember-me, WWW-Authenticate");
	response.addHeader("Access-Control-Expose-Headers", "xsrf-token");
	
	String authToken = request.getHeader(this.tokenHeader);
	if(authToken != null && authToken.length()>7) {
		authToken = authToken.substring(7);
	}
	
	String userName = jwtTokenUtil.getuserNameFromToken(authToken);
	
	if(userName !=null  && SecurityContextHolder.getContext().getAuthentication() == null) {
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
		boolean isValid = this.jwtTokenUtil.validateToken(authToken,userDetails);
		if(isValid) {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		
		
	}
	
	filterChain.doFilter(request, response);
	
}
}
