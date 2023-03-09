package com.emptask.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@Column(name = "employee_id", length = 36, unique = true, nullable = false)
	private Long employeeId;
	@NotBlank(message = "Please provide first name")
	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;
	@Column(name = "last_name", length = 50)
	private String lastName;

	@Column(name = "gender", length = 1)
	private Gender gender;

	@NotBlank(message = "Please provide email")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}")
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@NotBlank(message = "Please provide phone number")
	@Column(name = "phone", nullable = false, unique = true)
	@Pattern(regexp = "[\\\\\\\\+]+[0-9]{2}+[-]+[0-9]{10}")
	private String phone;
	private Date dob;
	private String image;

}
