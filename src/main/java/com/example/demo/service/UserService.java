package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service

public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User save(final User user) {

		return userRepository.save(user);
	}

	
	public User findByUserName(final String userName) {
		return userRepository.findByUserName(userName);
	}

}
