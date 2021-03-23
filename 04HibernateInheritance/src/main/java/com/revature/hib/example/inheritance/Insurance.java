package com.revature.hib.example.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="INSURANCE")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Insurance {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="INSURANCE_ID")
	private Integer id;
	 @Column(name="client")
    private String client;
	 @Column(name="premium")
    private double premium;
    Insurance()
    {
    	
    }
    Insurance(int id,String client,double premium)
    {
    	this.id=id;
    	this.client=client;
    	this.premium=premium;
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
    

}
