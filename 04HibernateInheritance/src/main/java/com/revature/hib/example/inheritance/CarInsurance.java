package com.revature.hib.example.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CAR_INSURANCE")
//@DiscriminatorValue("CAR")
public class CarInsurance extends  Insurance
{
	@Column(name="CarNo")
	String  carNo;
	@Column(name="CarModel")
	private String carModel;
	CarInsurance()
	{
		
	}
	public CarInsurance(String carNo, String carModel) {
        this.carNo = carNo;
        this.carModel = carModel;
    }
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	

}
