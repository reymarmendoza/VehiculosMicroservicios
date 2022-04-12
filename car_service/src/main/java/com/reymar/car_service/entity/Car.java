package com.reymar.car_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

	@Id
//	@SequenceGenerator(
//			name = "seq_pk_car",
//			sequenceName = "seq_pk_car",
//			allocationSize = 1
//	)
	@GeneratedValue(
//			strategy = GenerationType.SEQUENCE,
//			generator = "seq_pk_car"
				strategy = GenerationType.IDENTITY
	)
	private int id;
	private String brand;
	private String model;
	private int userId;

}
