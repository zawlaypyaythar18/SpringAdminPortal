package com.adminportal.admin.utility;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtility {

	private static final String SALT = "salt";
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	}
	
	@Bean
	public static String randomPassword() {
		String SALTCHA = "ABCDEFGHIJKLMNOPQRSTUVWHYZ1234567890";
		StringBuilder salt = new StringBuilder();
		
		Random rnd = new Random();
		
		while(salt.length() < 18) {
			int index = (int) (rnd.nextFloat()*SALTCHA.length()); // nextFloat can output 0 to 1
			salt.append(SALTCHA.charAt(index));
		}
		
		String saltString = salt.toString();
		return saltString;
		
	}
	
}
