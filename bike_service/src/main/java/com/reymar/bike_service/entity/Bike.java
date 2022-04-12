package com.reymar.bike_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bike {

	@Id
//	@SequenceGenerator(
//		name = "seq_pk_user",
//		sequenceName = "seq_pk_user",
//		allocationSize = 1
//	)
	@GeneratedValue(
//		strategy = GenerationType.SEQUENCE,
//		generator = "seq_pk_user"
			strategy = GenerationType.IDENTITY
	)
	private int id;
	private String brand;
	private String model;
	private int userId;

}
