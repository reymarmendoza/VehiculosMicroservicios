package com.reymar.bike_service.service;

import com.reymar.bike_service.entity.Bike;
import com.reymar.bike_service.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

	@Autowired
	BikeRepository bikeRepository;

	public BikeService(BikeRepository bikeRepository) {
		this.bikeRepository = bikeRepository;
	}

	public List<Bike> getAll() {
		return bikeRepository.findAll();
	}

	public Bike getBikeById(int id) {
		return bikeRepository.findById(id).orElse(null);
	}

	public Bike save(Bike user) {
		Bike newBike = bikeRepository.save(user);
		return newBike;
	}

	public List<Bike> byUserId(int userId) {
		return bikeRepository.findByUserId(userId);
	}
	
}
