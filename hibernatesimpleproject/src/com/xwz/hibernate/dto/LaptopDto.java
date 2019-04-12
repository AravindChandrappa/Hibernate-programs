package com.xwz.hibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="laptop_table")
@NamedQuery(name="fetchByCriteria",query="select lap from LaptopDto lap")
public class LaptopDto implements Serializable {
	
	@Id
	@GenericGenerator(name="inc",strategy="increment")
	@GeneratedValue(generator="inc")
	@Column(name="LAPTOP_ID")
	private int laptop_id;
	@Column(name="BRAND")
	private  String brand;
	@Column(name="PRICE")
	private double price=14;
	@Column(name="OS")
	private String os;
	@Column(name="WORKING")
	private boolean working;
	
	public LaptopDto() {
	System.out.println("created  "+this.getClass().getSimpleName());
	}
	
	
	public LaptopDto(String brand, double price, String os, boolean working) {
		//super();
		this.brand = brand;
		this.price = price;
		this.os = os;
		this.working = working;
	}


	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public boolean getWorking() {
		return working;
	}

	public void setWorking(boolean working) {
		this.working = working;
	}
	public int getLaptop_id() {
		return laptop_id;
	}

	@Override
	public String toString() {
		return "LaptopDto [brand=" + brand + ", price=" + price + ", os=" + os + ", working=" + working + "]";
	}
	
	
	

}
