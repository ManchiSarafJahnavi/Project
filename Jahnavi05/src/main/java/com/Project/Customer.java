package com.Project;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Customers")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private int customerId;
	

	
    @OneToOne(mappedBy = "customer")
    private Address address;
	
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Order> orders;
    
	

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;
    
   

	

	@Column(name = "Email")
    private String email;

    @Column(name = "Address")
    private String address1;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "PostalCode")
    private String postalCode;

    @Column(name = "Country")
    private String country;

	

	public int getCustomerId() {
		return customerId;
	}



	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Customer(int customerId, Address address, List<Order> orders, String firstName, String lastName,
			String email, String address1, String city, String state, String postalCode, String country) {
		super();
		this.customerId = customerId;
		this.address = address;
		this.orders = orders;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public Address getAddress1() {
		return address;
	}



	public Customer(int customerId, Address address, List<Order> orders, String firstName, String lastName,
			String email, String city, String state, String postalCode, String country) {
		super();
		this.customerId = customerId;
		this.address = address;
		this.orders = orders;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}



	public void setAddress1(Address address) {
		this.address = address;
	}



	public List<Order> getOrders() {
		return orders;
	}



	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address1;
	}



	public void setAddress(Address address) {
		this.address = address;
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



	public Customer(int customerId2, String updatedName, String updatedEmail, String updatedAddress) {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Customer(Address address2, Object object, String firstName2, String lastName2, String email2, String city2,
			String state2, String postalCode2, String country2) {
		// TODO Auto-generated constructor stub
	}



	public Customer(int choice, Address address2, Object orders2, String firstName2, String lastName2, String email2,
			String city2, String state2, String postalCode2, String country2) {
		// TODO Auto-generated constructor stub
	}



	public void setAttr1(Object attr1) {
		// TODO Auto-generated method stub
		
	}

	public void setAttr2(Object attr2) {
		// TODO Auto-generated method stub
		
	}

	public void setPhoneNumber(Object object) {
		// TODO Auto-generated method stub
		
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setaddress(Object object) {
		// TODO Auto-generated method stub
		
	}



	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}


}
