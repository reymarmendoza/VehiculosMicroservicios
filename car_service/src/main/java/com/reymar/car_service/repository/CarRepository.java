package com.reymar.car_service.repository;

import com.reymar.car_service.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
	List<Car> findByUserId(int userId);
}
