package org.jsp.emp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Adress {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
	private int doorno;
	private String streetAdress;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String postalcode;
	private String addressType;
	
	@ManyToOne
	private Employee employee;

}
