package com.reymar.user_service.feignclients;

import com.reymar.user_service.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// del bootstrap.yaml del proyecto Car -> spring.application.name=car-service y la url del servicio
@FeignClient(value = "car-service", url = "http://localhost:8002")
public interface CarFeignClient {

	// Llamar al metodo de la url y poner esa logica a disposicion al llamar al metodo que cree aqui
	@RequestMapping(method = RequestMethod.POST, value = "/car")
	Car save(@RequestBody Car car);

	@GetMapping("/car/byuser/{userId}")
	//el nombre del metodo estara disponible para que lo pueda usar en service sin embargo la logica viene del endpoint en la anotacion(Car pkg)
	List<Car> getCars(@PathVariable int userId);

}
