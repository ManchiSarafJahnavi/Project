package com.Project;
import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID")
    private int personID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Age")
    private int age;

    // Constructors, getters, and setters
    // Omitted for brevity

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + personID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int personID, String firstName, String lastName, int age) {
		super();
		this.personID = personID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
