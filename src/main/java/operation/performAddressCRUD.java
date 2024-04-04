package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.Project.Address;
import com.Project.AddressType;
import com.Project.Customer;

import DataAO.AddressDAO;
import DataAO.AddressDAOImpl;
import DataAO.CustomerDAO;
import DataAO.CustomerDAOImpl;

public class performAddressCRUD {
	








	public static void main(String[] args) {
		
	 
	}



	

	

	public void performCRUD() {
		Object Connected = null;
	    AddressDAO addressDAO = new AddressDAOImpl(Connected);
	    
	    try {
	    	System.out.println("Welcome to E-commerce CRUD Operations");
	        System.out.println("1. Create Address");
	        System.out.println("2. View All Addresses");
	        System.out.println("3. Update Address");
	        System.out.println("4. Delete Address");
	        System.out.println("5. Exit");

	        System.out.println("Please enter the number corresponding to the operation you want to perform:");

	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatefirstproject2", "root", "240302");
	 
	        CustomerDAO customerDAO = new CustomerDAOImpl();
	        Scanner scanner = new Scanner(System.in);
	        int operation = scanner.nextInt();
	        scanner.nextLine(); 
	        switch (operation) {
	            case 1:
	            	

	            	try {
	            		
		                // Existing code for creating a new address...
		                System.out.println("Creating new address...");
		                Address newAddress = new Address();
		                
		                System.out.print("Enter Customer ID: ");
		                int customerId = scanner.nextInt();
		                Customer customer = customerDAO.getCustomerById(customerId);
		                if (customer != null) {
		                    newAddress.setCustomer(customer);
		                    
		                    
		                    
		                    System.out.print("Enter Address Line 1: ");
		                    String addressLine1 = scanner.nextLine().trim();
		                    newAddress.setAddressLine1(addressLine1);

		                    System.out.print("Enter Address Line 2: ");
		                    String addressLine2 = scanner.nextLine().trim();
		                    newAddress.setAddressLine2(addressLine2);

		                    System.out.println("Enter City: ");
		                    String city = scanner.nextLine().trim();
		                    newAddress.setCity(city);

		                    System.out.println("Enter State: ");
		                    String state = scanner.nextLine().trim();
		                    newAddress.setState(state);

		                    System.out.println("Enter Postal Code: ");
		                    String postalCode = scanner.nextLine().trim();
		                    newAddress.setPostalCode(postalCode);

		                    System.out.println("Enter Country: ");
		                    String country = scanner.nextLine().trim();
		                    newAddress.setCountry(country);
		                    
		                    System.out.println("Enter Address Type (BILLING/SHIPPING): ");
			                   
		                    String addressTypeStr = scanner.nextLine().trim();
		                    AddressType addressType = AddressType.valueOf(addressTypeStr.toUpperCase());
		                    newAddress.setAddressType(addressType);

		                    // Create and persist the new address
		                    addressDAO.create(newAddress);
		                    System.out.println("Address created successfully.");
		                } else {
		                    System.out.println("Customer not found with ID " + customerId);
		                }
		                break;

	            	}catch (IllegalArgumentException e) {
	            	 
						System.out.println("Invalid address type provided: " + addressDAO);
	            	    // Handle the error gracefully, e.g., provide default value or prompt user to enter correct value
	            	}
	            	
            case 2:
                
                List<Address> addresses = addressDAO.getAllAddresses();
                for (Address address : addresses) {
                    System.out.println(address);
                }
                break;
            case 3:
                
                System.out.print("Enter address ID to update: ");
                int addressIdToUpdate = scanner.nextInt();
                scanner.nextLine();
                Address addressToUpdate = addressDAO.getAddressById(addressIdToUpdate);
                if (addressToUpdate != null) {
                    
                } else {
                    System.out.println("Address not found with ID " + addressIdToUpdate);
                }
                break;
            case 4:
                
                System.out.print("Enter address ID to delete: ");
                int addressIdToDelete = scanner.nextInt();
                addressDAO.delete(addressIdToDelete);
                System.out.println("Address with ID " + addressIdToDelete + " deleted successfully.");
                break;
            case 5:
                System.out.println("Exiting program...");
                System.exit(0);
            default:
                System.out.println("Invalid operation choice");
                break;
               
        }
            scanner.close();

        connection.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
	    
	
		
	}

	
}
