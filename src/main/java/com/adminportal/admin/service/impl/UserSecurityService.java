package com.adminportal.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adminportal.admin.dao.UserDAO;
import com.adminportal.admin.domain.User;

@Service
public class UserSecurityService implements UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDAO.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException(username + " is not found in Database");
		}
		
		return user;
	}

}
