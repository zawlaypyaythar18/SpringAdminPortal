package com.adminportal.admin.dao;

import org.springframework.data.repository.CrudRepository;

import com.adminportal.admin.domain.User;

public interface UserDAO extends CrudRepository<User, Long> {

	User findByUsername(String username);
	
	User findByEmail(String email);
	
}
