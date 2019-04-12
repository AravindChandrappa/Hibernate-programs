package com.xworkz.small.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="store_table")
public class StoreDTO implements Serializable {

	@Id
	@GenericGenerator(name="auto" ,strategy="increment")
	@GeneratedValue(generator="auto")
	@Column(name="ID")
	private int mId;
	@Column(name="NAME")
	private String name;
	@Column(name="STORE_TYPE")
	private String storeType;
	@Column(name="NO_OF_EMP")
	private int noOfStores;
	
	public StoreDTO() {
		System.out.println("Created: "+this.getClass().getSimpleName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public int getNoOfStores() {
		return noOfStores;
	}

	public void setNoOfStores(int noOfStores) {
		this.noOfStores = noOfStores;
	}

	@Override
	public String toString() {
		return "StoreDTO [mId=" + mId + ", name=" + name + ", storeType=" + storeType + ", noOfStores=" + noOfStores
				+ "]";
	}

	
	
}
