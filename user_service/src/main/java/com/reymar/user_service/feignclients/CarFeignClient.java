package com.reymar.user_service.feignclients;

import com.reymar.user_service.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// del application.properties del proyecto Car -> spring.application.name=car-service y la url del servicio
@FeignClient(value = "car-service", url = "http://localhost:8002")
public interface CarFeignClient {

	// Llamar al metodo de la url
	@RequestMapping(method = RequestMethod.POST, value = "/car")
	Car save(@RequestBody Car car);

}
