package com.xworkz.gym.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="gym_table")
@NamedQueries({@NamedQuery(name="gym.fetchAll",query="select gym from GymDTO gym"),
			   @NamedQuery(name="gym.fetchName",query="select gym.loctaion from GymDTO gym where gym.g_name=:rc"),
			   @NamedQuery(name="gym.fetchNameAndLocation",query="select gym.loctaion,gym.g_name from GymDTO gym where gym.type=:typ"),
			   @NamedQuery(name="gym.fetAllList",query="select count(gym.type),gym.type,gym.g_name from GymDTO gym group By gym.type"),
			   @NamedQuery(name="updateLocationByname",query="update GymDTO gym set gym.loctaion=:loc where gym.g_name=:nm"),
			   @NamedQuery(name="deleteRecordByType",query="delete from GymDTO gym where gym.type=:tp")})
			
public class GymDTO implements Serializable {

	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	@Column(name="g_id")
	private int id;
	@Column(name="g_name")
	private String g_name;
	@Column(name="location")
	private String loctaion;
	@Transient
	private double entry_price;
	private String type;

	public GymDTO() {
		System.out.println("Created :\t" + this.getClass().getSimpleName());
	}
	

	public GymDTO(String g_name, String loctaion, String type) {
		//super();
		this.id = id;
		this.g_name = g_name;
		this.loctaion = loctaion;
		//this.entry_price = entry_price;
		this.type = type;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getLoctaion() {
		return loctaion;
	}

	public void setLoctaion(String loctaion) {
		this.loctaion = loctaion;
	}

	public double getEntry_price() {
		return entry_price;
	}

	public void setEntry_price(double entry_price) {
		this.entry_price = entry_price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "GymDTO [id=" + id + ", g_name=" + g_name + ", loctaion=" + loctaion + ", entry_price=" + entry_price
				+ ", type=" + type + "]";
	}
	

}
