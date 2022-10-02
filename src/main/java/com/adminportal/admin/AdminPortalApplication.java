package com.adminportal.admin;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adminportal.admin.domain.User;
import com.adminportal.admin.domain.security.Role;
import com.adminportal.admin.domain.security.UserRole;
import com.adminportal.admin.service.UserService;
import com.adminportal.admin.utility.SecurityUtility;

@SpringBootApplication
public class AdminPortalApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(AdminPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User();

		user1.setUsername("admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("1234"));
		user1.setEmail("zawlaytest3@gmail.com");
		user1.setFirstName("Zaw");
		user1.setLastName("Lay Pyay Thar");
		user1.setPhone("09012345678");

		Set<UserRole> userRoles = new HashSet<>();

		Role role1 = new Role();

		role1.setRoleId(2);
		role1.setName("ROLE ADMIN");

		userRoles.add(new UserRole(user1, role1));
		userService.createUser(user1, userRoles);
	}

}
