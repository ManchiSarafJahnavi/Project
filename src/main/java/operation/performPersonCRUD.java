package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.Project.Person;

import DataAO.PersonDAO;
import DataAO.PersonDAOImpl;

public class performPersonCRUD {
	public static void main(String[] args) {

	// TODO Auto-generated method stub
	}

	public void performCRUD() {
		Object Connected = null;
	    PersonDAO personDAO = new PersonDAOImpl(Connected);
	    try {
	    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatefirstproject2", "root", "240302");
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
            	System.out.println("Choose CRUD operation for Persons:");
                System.out.println("1. Create Person");
                System.out.println("2. Read Persons");
                System.out.println("3. Update Person");
                System.out.println("4. Delete Person");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                case 1:
                    
                	System.out.println("Enter Person details:");
                    System.out.print("Person ID: ");
                    int personID = scanner.nextInt();
                    System.out.print("First Name: ");
                    String firstName = scanner.next();
                    System.out.print("Last Name: ");
                    String lastName = scanner.next();
                    
                    // Handle Age Input
                    int age;
                    System.out.print("Age: ");
                    if (scanner.hasNextInt()) {
                        age = scanner.nextInt();
                    } else {
                        System.out.println("Invalid input! Please enter a valid integer for age.");
                        // Handle the invalid input accordingly, maybe prompt the user to try again
                        // You might consider adding a scanner.nextLine() here to consume the invalid input
                        break;
                    }
                    
                    Person person = new Person(personID, firstName, lastName, age);
                    personDAO.createPerson(person);
                    System.out.println("Person created successfully.");
                    break;

                case 2:
                    
                    List<Person> persons = personDAO.getAllPersons();
                    if (persons.isEmpty()) {
                        System.out.println("No persons found.");
                    } else {
                        System.out.println("Persons:");
                        for (Person p : persons) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 3:
                    
                    System.out.println("Update Person operation is not implemented.");
                    break;

                case 4:
                    
                    System.out.println("Delete Person operation is not implemented.");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }
        } while (choice != 0);

        scanner.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
		// TODO Auto-generated method stub
		
	}

}
