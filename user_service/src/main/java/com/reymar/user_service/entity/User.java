package com.reymar.user_service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

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
	private String name;
	private String email;

}
