package com.reymar.user_service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.reymar.user_service.entity.User;
import com.reymar.user_service.feignclients.BikeFeignClient;
import com.reymar.user_service.feignclients.CarFeignClient;
import com.reymar.user_service.model.Bike;
import com.reymar.user_service.model.Car;
import com.reymar.user_service.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	// import org.springframework.web.client.RestTemplate;
	//Synchronous client to perform HTTP requests, exposing a simple, template method API over underlying HTTP client libraries
	RestTemplate restTemplate;

	// inyectar la interfaz que me permite acceder a los metodos del servicio Car
	@Autowired
	CarFeignClient carFeignClient;

	@Autowired
	BikeFeignClient bikeFeignClient;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public User save(User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}

	public List<Car> getCars(int userId) {
		// apunta al endpoint de la API cars-service @GetMapping("/byuser/{userId}"), lleva /car/ antes por @RequestMapping("/car") en CarController
		List<Car> cars = restTemplate.getForObject("http://localhost:8002/car/byuser/" + userId, List.class);
		return cars;
	}

	public List<Bike> getBikes(int userId) {
		List<Bike> bikes = restTemplate.getForObject("http://localhost:8003/bike/byuser/" + userId, List.class);
		return bikes;
	}

	public Car saveCar(int userId, Car car) {
		car.setUserId(userId);
		Car newCar = carFeignClient.save(car);
		return newCar;
	}

	public Bike saveBike(int userId, Bike bike) {
		bike.setUserId(userId);
		Bike newBike = bikeFeignClient.save(bike);
		return newBike;
	}

	public Map<String, Object> getUserVehicles(int userId) {
		Map<String, Object> result = new HashMap<>();

		User user = userRepository.findById(userId).orElse(null);
		if (user == null) {
			result.put("Mensaje", "No existe el usuario");
			return result; // si no hay usuario no tiene sentido seguir con la consulta
		} else {
			result.put("User", user);
		}

		List<Car> cars = carFeignClient.getCars(userId);
		if (cars.isEmpty())
			result.put("Cars", "No existen carros para ese usuario");
		else
			result.put("Cars", cars);

		List<Bike> bikes = bikeFeignClient.getBikes(userId);
		if (bikes.isEmpty())
			result.put("Bikes", "No existen motos para ese usuario");
		else
			result.put("Bikes", bikes);

		return result;

	}

}
