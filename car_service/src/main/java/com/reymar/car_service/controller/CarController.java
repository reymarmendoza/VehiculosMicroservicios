package com.reymar.car_service.controller;

import com.reymar.car_service.entity.Car;
import com.reymar.car_service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	CarService carService;

	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping
	public ResponseEntity<List<Car>> getAll() {
		List<Car> cars = carService.getAll();
		if (cars.isEmpty()) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(cars);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Car> getById(@PathVariable int id) {
		Car car = carService.getCarById(id);
		if (car == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(car);
	}

	@PostMapping()
	public ResponseEntity<Car> save(@RequestBody Car car) {
		Car newCar = carService.save(car);
		if (newCar == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newCar);
	}

	@GetMapping("/byuser/{userId}")
	public ResponseEntity<List<Car>> getByUserId(@PathVariable int userId) {
		List<Car> cars = carService.byUserId(userId);
		return ResponseEntity.ok(cars);
	}

}
