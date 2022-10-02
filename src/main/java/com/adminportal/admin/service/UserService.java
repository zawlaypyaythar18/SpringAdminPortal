package com.adminportal.admin.service;

import java.util.Set;

import com.adminportal.admin.domain.User;
import com.adminportal.admin.domain.security.UserRole;

public interface UserService {

	User findByUsername(String userame);
	
	User findByEmail(String email);
	
	User findById(Long id);
	
	User saveUser(User user);
	
	User createUser(User user,Set<UserRole> userRoles);
	
}
