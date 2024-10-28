package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

@Entity
public class CarModel {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String brand;
private String model;
private int rentalPrice;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public int getRentalPrice() {
	return rentalPrice;
}
public void setRentalPrice(int rentalPrice) {
	this.rentalPrice = rentalPrice;
}

}
