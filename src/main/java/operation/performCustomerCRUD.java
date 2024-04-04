package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.Project.Address;
import com.Project.Customer;

import DataAO.CustomerDAO;
import DataAO.CustomerDAOImpl;

public class performCustomerCRUD {
	public static void main(String[] args) {
		
	}



	public void performCRUD() {
		
		Scanner scanner = new Scanner(System.in);
	    Object Connected = null;
	    CustomerDAO customerDAO = new CustomerDAOImpl(Connected);
	    try {
	    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatefirstproject2", "root", "240302");
	        
	        
		    int choice;	
		    do {
		    	System.out.println("Welcome to Customer CRUD Operations");
	            System.out.println("1. Create a new customer");
	            System.out.println("2. View all customers");
	            System.out.println("3. Update a customer");
	            System.out.println("4. Delete a customer");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");

	            choice = scanner.nextInt();
	            switch (choice) {
	            case 1:
	                
	                System.out.println("Enter customer details:");
	                System.out.println("First Name: ");
	                String firstName = scanner.next();
	                System.out.println("Last Name: ");
	                String lastName = scanner.next();
	                System.out.println("Email: ");
	                String email = scanner.next();
	                System.out.println("City: ");
	                String city = scanner.next();
	                System.out.println("State: ");
	                String state = scanner.next();
	                System.out.println("Postal Code: ");
	                String postalCode = scanner.next();
	                System.out.println("Country: ");
	                String country = scanner.next();

	                

				    Address address = null;
				    
				
	                Customer newCustomer = new Customer(choice, address, null, firstName, lastName, email, city, state, postalCode, country);
	                customerDAO.create(newCustomer);
	                System.out.println("Customer created successfully.");
	                break;
	            case 2:
	                
	                List<Customer> customers = customerDAO.getAllCustomers();
	                for (Customer customer : customers) {
	                    System.out.println(customer);
	                }
	                break;
	            case 3:
	                
	                System.out.println("Enter the ID of the customer to update: ");
	                int customerIdToUpdate = scanner.nextInt();
	                if (customerExists(customerIdToUpdate, customerDAO)) {
	                    System.out.println("Enter updated first name: ");
	                    String updatedFirstName = scanner.next();
	                    System.out.println("Enter updated last name: ");
	                    String updatedLastName = scanner.next();
	                    System.out.println("Enter updated email: ");
	                    String updatedEmail = scanner.next();
	                    System.out.println("Enter updated city: ");
	                    String updatedCity = scanner.next();
	                    System.out.println("Enter updated state: ");
	                    String updatedState = scanner.next();
	                    System.out.println("Enter updated postal code: ");
	                    String updatedPostalCode = scanner.next();
	                    System.out.println("Enter updated country: ");
	                    String updatedCountry = scanner.next();

	                   
	                    Address updatedAddress = null;
						
	                    Customer updatedCustomer = new Customer(customerIdToUpdate, updatedAddress, null, updatedFirstName, updatedLastName, updatedEmail, updatedCity, updatedState, updatedPostalCode, updatedCountry);
	                    customerDAO.updateCustomer(updatedCustomer);
	                    System.out.println("Customer updated successfully.");
	                } else {
	                    System.out.println("Customer with ID " + customerIdToUpdate + " does not exist.");
	                }
	                break;
	            case 4:
	                
	                System.out.print("Enter the ID of the customer to delete: ");
	                int customerIdToDelete = scanner.nextInt();
	                if (customerExists(customerIdToDelete, customerDAO)) {
	                    customerDAO.deleteCustomer(customerIdToDelete);
	                    System.out.println("Customer deleted successfully.");
	                } else {
	                    System.out.println("Customer with ID " + customerIdToDelete + " does not exist.");
	                }
	                break;
	            case 5:
	                System.out.println("Exiting customer CRUD operations...");
	                break;
	            default:
	                System.out.println("Invalid choice");
	                break;
	        }
		 } while (choice != 5);
		 

	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    scanner.close();
	}


    private static boolean customerExists(int customerIdToDelete, CustomerDAO customerDAO) {
    	List<Customer> customers = customerDAO.getAllCustomers();
    	
    for (Customer customer : customers) {
        int customerId = 0;
		if (customer.getCustomerId() == customerId) {
            return true;
        }
    }
	// TODO Auto-generated method stub
	return false;
	
    }
		// TODO Auto-generated method stub
		
	}



