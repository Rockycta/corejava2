package com.infybank;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	@Id
	private String addressId;
	private String addressLine;
	private String state;
	private String district;
	private Long pinCode;
	public Address(String addressId, String addressLine, String state, String district, Long pinCode) {
		super();
		this.addressId = addressId;
		this.addressLine = addressLine;
		this.state = state;
		this.district = district;
		this.pinCode = pinCode;
	}
       public Address() {
		super();
       }
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Long getPinCode() {
		return pinCode;
	}
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}	
}