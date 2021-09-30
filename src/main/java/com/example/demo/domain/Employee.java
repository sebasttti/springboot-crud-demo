package com.example.demo.domain;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Table(name="employee")
@Entity
public class Employee {
	
	@SequenceGenerator(sequenceName = "employee_id_seq" , name = "employee_id_seq" , initialValue = 1 , allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "employee_id_seq" )
	@Id
	@Column(name="employee_id")
	private Integer id;
	
	@Column(name="employee_name", length = 60, nullable = false, unique = true)
	private String name;
	
	@Column(name="employee_email",length = 60, nullable = false, unique = true)
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
