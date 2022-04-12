package com.reymar.user_service.controller;

import java.util.List;
import java.util.Map;

import com.reymar.user_service.entity.User;
import com.reymar.user_service.model.Bike;
import com.reymar.user_service.model.Car;
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

		if (users.isEmpty())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable int id) {
		User user = userService.getUserById(id);

		if (user == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(user);
	}

	@PostMapping()
	public ResponseEntity<User> save(@RequestBody User user) {
		User newUser = userService.save(user);

		if (newUser == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(newUser);
	}

	// este endpoint va a ser atendido por el microservicio de Car
	@GetMapping("/cars/{userId}")
	public ResponseEntity<List<Car>> getCars(@PathVariable int userId) {
		User user = userService.getUserById(userId);

		if (user == null)
			return ResponseEntity.notFound().build();

		List<Car> cars = userService.getCars((userId));
		return ResponseEntity.ok(cars);
	}

	@GetMapping("/bikes/{bikesId}")
	public ResponseEntity<List<Bike>> getBikes(@PathVariable int bikesId) {
		User user = userService.getUserById(bikesId);

		if (user == null)
			return ResponseEntity.notFound().build();

		List<Bike> bikes = userService.getBikes((bikesId));
		return ResponseEntity.ok(bikes);
	}

	@PostMapping("/savecar/{userId}")
	public ResponseEntity<Car> saveCar(@PathVariable int userId, @RequestBody Car car) {
		if (userService.getUserById(userId) == null)
			return ResponseEntity.notFound().build();

		Car newCar = userService.saveCar(userId, car);
		return ResponseEntity.ok(newCar);
	}

	@PostMapping("/savebike/{userId}")
	public ResponseEntity<Bike> saveBike(@PathVariable int userId, @RequestBody Bike bike) {
		if (userService.getUserById(userId) == null)
			return ResponseEntity.notFound().build();

		Bike newBike = userService.saveBike(userId, bike);
		return ResponseEntity.ok(newBike);
	}

	@GetMapping("/getAll/{userId}")
	public ResponseEntity<Map<String, Object>> getAllVehicles(@PathVariable int userId) {
		Map<String, Object> result = userService.getUserVehicles(userId);
		return ResponseEntity.ok(result);
	}

}
