package com.reymar.user_service.feignclients;

import com.reymar.user_service.model.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "bike-service", url = "http://localhost:8003")
public interface BikeFeignClient {

	@RequestMapping(method = RequestMethod.POST, value = "/bike")
	Bike save(@RequestBody Bike bike);

}
