package com.user.service;

import com.user.entity.User;

public interface UserService {
	User saveUser(User user);
	User getUserById(int userId);
	void deleteUser(int userId);
	String updateUser(User user);
	
}
