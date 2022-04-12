package com.reymar.bike_service.controller;

import com.reymar.bike_service.entity.Bike;
import com.reymar.bike_service.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {

	@Autowired
	BikeService bikeService;

	public BikeController(BikeService bikeService) {
		this.bikeService = bikeService;
	}

	@GetMapping
	public ResponseEntity<List<Bike>> getAll() {
		List<Bike> bikes = bikeService.getAll();
		if (bikes.isEmpty()) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(bikes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Bike> getById(@PathVariable int id) {
		Bike bike = bikeService.getBikeById(id);
		if (bike == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(bike);
	}

	@PostMapping()
	public ResponseEntity<Bike> save(@RequestBody Bike car) {
		Bike newBike = bikeService.save(car);
		if (newBike == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newBike);
	}

	@GetMapping("/byuser/{userId}")
	public ResponseEntity<List<Bike>> getByUserId(@PathVariable int userId) {
		List<Bike> bikes = bikeService.byUserId(userId);
		return ResponseEntity.ok(bikes);
	}
	
}
