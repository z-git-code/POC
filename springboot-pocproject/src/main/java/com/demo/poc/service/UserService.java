package com.demo.poc.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.demo.poc.dto.UserRegistrationDto;
import com.demo.poc.model.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto userRegistrationDto);
}
