package com.reymar.user_service.controller;

import java.util.List;

import com.reymar.user_service.entity.User;
import com.reymar.user_service.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		List<User> users = userService.getAll();
		if (users.isEmpty()) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable int id) {
		User user = userService.getUserById(id);
		if (user == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(user);
	}

	@PostMapping()
	public ResponseEntity<User> save(@RequestBody User user) {
		User newUser = userService.save(user);
		if (newUser == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newUser);
	}

}
