package com.adminportal.admin.service.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal.admin.dao.RoleDAO;
import com.adminportal.admin.dao.UserDAO;
import com.adminportal.admin.domain.User;
import com.adminportal.admin.domain.security.UserRole;
import com.adminportal.admin.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	public User findByUsername(String userame) {
		return userDAO.findByUsername(userame);
	}

	@Override
	public User findByEmail(String email) {
		return userDAO.findByEmail(email);
	}

	@Override
	public User saveUser(User user) {
		return userDAO.save(user);
	}

	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
		
		User localUser = userDAO.findByEmail(user.getEmail());
		
		if (localUser != null) {
			LOG.info("user {} already exists Nothing will be done.",user.getEmail());
		} else {
			for (UserRole ur : userRoles) {
				roleDAO.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			
			localUser = userDAO.save(user);
			
		}
		
		return localUser;
	}

	@Override
	public User findById(Long id) {
		return userDAO.findById(id).get();
	}

}
