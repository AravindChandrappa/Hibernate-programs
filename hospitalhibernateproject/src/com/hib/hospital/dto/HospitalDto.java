package com.hib.hospital.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hospital_table")
public class HospitalDto implements Serializable{
	
	@Id
	@Column(name="hospital_id")
	private int hospital_id;
	@Column(name="name")
	private String name;
	@Column(name="location")
	private String location;
	@Column(name="specialization")
	private String specialization;
	@Column(name="contactNo")
	private long contactNo;
	
	public HospitalDto() {
		System.out.println("created: "+this.getClass().getSimpleName());
	}
	
	public int getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "HospitalDto [hospital_id=" + hospital_id + ", name=" + name + ", location=" + location
				+ ", specialization=" + specialization + ", contactNo=" + contactNo + "]";
	}
	
		

}
