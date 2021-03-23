package com.revature.hib.example.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="HOME_INSURANCE")
//@DiscriminatorValue("HOME")
public class HomeInsurance extends  Insurance
{
	@Column(name="address")
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
