package com.Project;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Addresses")
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID")
	private int addressID;
	
    @OneToOne
    @JoinColumn(name = "customerID")
    private Customer customer;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "AddressType")
	private AddressType addressType;
	
	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressID, Customer customer, AddressType addressType, String addressLine1, String addressLine2,
			String city, String state, String postalCode, String country) {
		super();
		this.addressID = addressID;
		this.customer = customer;
		this.addressType = addressType;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}

	@Column(name = "AddressLine1")
	private String addressLine1;
	
	@Column(name = "AddressLine2")
	private String addressLine2;
	
	 @Column(name = "City")
	private String city;
	 
	 @Column(name = "State")
	private String state;
	 
	 @Column(name = "PostalCode")
	private String postalCode;
	 
	 @Column(name = "Country")
	 private String country;






	public void setOrderStatus(OrderStatus shipping) {
		// TODO Auto-generated method stub
		
	}

	public void setCustomer() {
		// TODO Auto-generated method stub
		
	}

	

	public void setAttr1(Object attr1) {
		// TODO Auto-generated method stub
		
	}

	public void setAttr2(Object attr2) {
		// TODO Auto-generated method stub
		
	}

	public void setZipcode(String zipcode) {
		// TODO Auto-generated method stub
		
	}

	public void setStreet(String street) {
		// TODO Auto-generated method stub
		
	}

	public void setZipCode(String zipCode) {
		// TODO Auto-generated method stub
		
	}

	public String getStreet() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getZipCode() {
		// TODO Auto-generated method stub
		return null;
	}

	


}