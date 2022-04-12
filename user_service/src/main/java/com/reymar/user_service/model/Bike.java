package com.reymar.user_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
	como el usuario puede tener motos y carros por lo que necesito crear las entidades que imiten esos microservicios(MODEL[como son tan parecidas podria crear una abstraccion vehiculo])
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bike {

	private String brand;
	private String model;
	private int userId;

}
