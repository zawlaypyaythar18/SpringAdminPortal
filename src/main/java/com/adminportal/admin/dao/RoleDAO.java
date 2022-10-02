package com.adminportal.admin.dao;

import org.springframework.data.repository.CrudRepository;

import com.adminportal.admin.domain.security.Role;

public interface RoleDAO extends CrudRepository<Role, Integer> {

	Role findByName(String name);
	
}
