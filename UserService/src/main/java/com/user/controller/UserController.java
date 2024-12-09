package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
//@RequestMapping("/user")
public class UserController {
	
		@Autowired
		private UserService userService;
		
		@GetMapping("/test")
		public String test() {
			return "Connection to sahi h Boss!!";
		}
		
		@PostMapping("/createUser")
		public ResponseEntity<?> createUser(@RequestBody User user) {
		    System.out.println("Received User: " + user);
		    User createdUser = userService.saveUser(user);
		    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		}

		@GetMapping("getUserById/{userId}")
	    public ResponseEntity<?> getUserById(@PathVariable int userId) {
	        User user = userService.getUserById(userId);
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    }
		
		@DeleteMapping("deleteUser/{userId}")
		public ResponseEntity<?> deleteUser(@PathVariable int userId) {
		    userService.deleteUser(userId);
		    return new ResponseEntity<>("User deleted successfully.", HttpStatus.OK);
	    }
		
		@PutMapping("/updateUser")
		public ResponseEntity<?> updateUser(@RequestBody User user){
			String msg = userService.updateUser(user);
			return new ResponseEntity<>(msg, HttpStatus.OK);
		}
		
}