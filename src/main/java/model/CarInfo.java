 package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Larry Paucar - Lpaucar
 * CIS175 -Spring 2024
 * Feb 4, 2024
 */

@Entity
@Table(name="info")
public class CarInfo {
	
	//instance variables
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="MAKE")
	private String make;
	@Column(name="MODEL")
	private String model;
	@Column(name="year")
	private String year;
	
	//Default no arg contructor 
	public CarInfo() {
		super();
	}

	//Getters and setters for instance variables
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	//Constructor with parameters 
	public CarInfo(String make, String model, String year) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
	}

	//Method to display details of car
	public String returnCarDetails() {
		return this.make + ":" + this.model + ":" + this.year;
	}
}