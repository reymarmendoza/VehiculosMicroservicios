package com.reymar.car_service.service;

import com.reymar.car_service.entity.Car;
import com.reymar.car_service.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

	@Autowired
	CarRepository carRepository;

	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public List<Car> getAll() {
		return carRepository.findAll();
	}

	public Car getCarById(int id) {
		return carRepository.findById(id).orElse(null);
	}

	public Car save(Car user) {
		Car newCar = carRepository.save(user);
		return newCar;
	}

	public List<Car> byUserId(int userId) {
		return carRepository.findByUserId(userId);
	}

}
