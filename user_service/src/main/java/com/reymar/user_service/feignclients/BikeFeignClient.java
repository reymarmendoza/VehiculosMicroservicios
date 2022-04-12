package com.reymar.user_service.feignclients;

import com.reymar.user_service.model.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "bike-service", url = "http://localhost:8003")
public interface BikeFeignClient {

	@RequestMapping(method = RequestMethod.POST, value = "/bike")
	Bike save(@RequestBody Bike bike);

	@GetMapping("/bike/byuser/{userId}")
	List<Bike> getBikes(@PathVariable int userId);

}
