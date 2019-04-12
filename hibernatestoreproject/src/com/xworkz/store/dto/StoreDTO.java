package com.xworkz.store.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="STORE_TABLE")
public class StoreDTO implements Serializable {
	
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="STORE_TYPE")
	private String storeType;
	@Column(name="NO_OF_EMP")
	private int noOfEmp;
	
	public StoreDTO() {
		System.out.println("created: "+this.getClass().getSimpleName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public int getNoOfEmp() {
		return noOfEmp;
	}

	public void setNoOfEmp(int noOfEmp) {
		this.noOfEmp = noOfEmp;
	}

	@Override
	public String toString() {
		return "StoreDTO [name=" + name + ", id=" + id + ", storeType=" + storeType + ", noOfEmp=" + noOfEmp + "]";
	}
	
}
