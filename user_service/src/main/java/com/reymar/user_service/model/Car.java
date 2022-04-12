package com.reymar.user_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
	va a tener los mismos campos de la entidad que va a imitar
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

	private String brand;
	private String model;
	private int userId;

}
