package DataAO;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.Order;

import com.Project.Address;
import com.Project.AddressType;
import com.Project.Category;
import com.Project.Customer;
import com.Project.OrderDetail;
import com.Project.OrderStatus;
import com.Project.Payment;
import com.Project.Person;
import com.Project.Product;
import com.Project.OrderStatus;




public class Main {
   
	private static int customerId;
	private static CustomerDAO customerDAO;
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
    private static final EntityManager em = emf.createEntityManager();
	public static void main(String[] args) {
        try {
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatefirstproject2", "root", "240302");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to E-commerce CRUD Operations");
            System.out.println("1. Addresses");
            System.out.println("2. Categories");
            System.out.println("3. Customers");
            System.out.println("4. Order Details");
            System.out.println("5. Orders");
            System.out.println("6. Payments");
            System.out.println("7. Person");
            System.out.println("8. Products");
            System.out.println("9. Exit");

            System.out.println("Please enter the number corresponding to the entity you want to perform CRUD operations on:");
            int choice = scanner.nextInt();
            
            AddressDAO addressDAO = new AddressDAOImpl();
            CategoryDAO categoryDAO = new CategoryDAOImpl();
            CustomerDAO customerDAO = new CustomerDAOImpl();
            PaymentDAO paymentDAO = new PaymentDAOImpl();
            OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
            ProductDAO productDAO = new ProductDAOImpl();
            PersonDAO personDAO = new PersonDAOImpl();
            OrderDAO orderDAO = new OrderDAOImpl();

            switch (choice) {
                case 1:
                    performAddressCRUD(addressDAO);
                    break;
                case 2:
                    performCategoryCRUD(categoryDAO);
                    break;
                case 3:
                    performCustomerCRUD(customerDAO);
                    break;
                case 4:
                    performOrderDetailCRUD(orderDetailDAO);
                    break;
                case 5:
                    performOrderCRUD(orderDAO);
                    break;
                case 6:
                    performPaymentCRUD(paymentDAO);
                    break;
                case 7:
                    performPersonCRUD(personDAO);
                    break;
                case 8:
                    performProductCRUD(productDAO);
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }

            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    



	private static void performAddressCRUD(AddressDAO 
			addressDAO) {
		
		System.out.println("Welcome to E-commerce CRUD Operations");
        System.out.println("1. Create Address");
        System.out.println("2. View All Addresses");
        System.out.println("3. Update Address");
        System.out.println("4. Delete Address");
        System.out.println("5. Exit");

        System.out.println("Please enter the number corresponding to the operation you want to perform:");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatefirstproject2", "root", "240302");
			
            
            Scanner scanner = new Scanner(System.in);
            int operation = scanner.nextInt();
            scanner.nextLine(); 

            switch (operation) {
                case 1:
                    
                    System.out.println("Creating new address...");
                    Address newAddress = new Address();
                    
                    
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    Customer customer = customerDAO.getCustomerById(customerId);
                    if (customer != null) {
                        newAddress.setCustomer(customer);
                        
                        
                        System.out.println("Enter Address Type (BILLING/SHIPPING): ");
                        String addressTypeStr = scanner.nextLine().trim();
                        AddressType addressType = AddressType.valueOf(addressTypeStr.toUpperCase());
                        newAddress.setAddressType(addressType);
                        
                        
                        System.out.print("Enter Address Line 1: ");
                        String addressLine1 = scanner.nextLine().trim();
                        newAddress.setAddressLine1(addressLine1);

                        System.out.print("Enter Address Line 2: ");
                        String addressLine2 = scanner.nextLine().trim();
                        newAddress.setAddressLine2(addressLine2);

                        System.out.print("Enter City: ");
                        String city = scanner.nextLine().trim();
                        newAddress.setCity(city);

                        System.out.print("Enter State: ");
                        String state = scanner.nextLine().trim();
                        newAddress.setState(state);

                        System.out.print("Enter Postal Code: ");
                        String postalCode = scanner.nextLine().trim();
                        newAddress.setPostalCode(postalCode);

                        System.out.print("Enter Country: ");
                        String country = scanner.nextLine().trim();
                        newAddress.setCountry(country);

                        
                        addressDAO.create(newAddress);
                        System.out.println("Address created successfully.");
                    } else {
                        System.out.println("Customer not found with ID " + customerId);
                    }
                    break;
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

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	

    private static void performCategoryCRUD(CategoryDAO 
    		categoryDAO) {
        try {
        	Scanner scanner = new Scanner(System.in);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatefirstproject2", "root", "240302");

        
            
            System.out.println("Category CRUD Operations:");
            System.out.println("1. Create a new category");
            System.out.println("2. View all categories");
            System.out.println("3. Update a category");
            System.out.println("4. Delete a category");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            
			int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                	System.out.println("Enter details for the new category:");
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Description: ");
                    String description = scanner.next();
                    
                    
                    Category newCategory = new Category();
                    newCategory.setName(name);
                    newCategory.setDescription(description);
                    
                    
                    categoryDAO.create(newCategory);
                    System.out.println("New category created successfully!");
                    break;
                case 2:
                    
                    List<Category> categories = categoryDAO.getAllCategories();
                    for (Category category : categories) {
                        System.out.println(category);
                    }
                    break;
                case 3:
                	System.out.println("Enter the ID of the category to update:");
                    int updateCategoryId = scanner.nextInt();
                    
                    
                    System.out.println("Enter updated details for the category (if any):");
                    System.out.print("New name: ");
                    String newName = scanner.next();
                    System.out.print("New description: ");
                    String newDescription = scanner.next();
                    
                    
                    Category existingCategory = categoryDAO.getCategoryById(updateCategoryId);
                    
                    if (existingCategory != null) {
                        
                        if (!newName.isEmpty()) {
                            existingCategory.setName(newName);
                        }
                        if (!newDescription.isEmpty()) {
                            existingCategory.setDescription(newDescription);
                        }
                        
                        
                        categoryDAO.update(existingCategory);
                        System.out.println("Category updated successfully!");
                    } else {
                        System.out.println("Category with ID " + updateCategoryId + " not found.");
                    }
                    break;
                case 4:
                	
                    System.out.println("Enter the ID of the category to delete:");
                    int deleteCategoryId = scanner.nextInt();
                    
                    
                    boolean isDeleted = categoryDAO.delete(deleteCategoryId);
                    
                    if (isDeleted) {
                        System.out.println("Category deleted successfully!");
                    } else {
                        System.out.println("Failed to delete category with ID " + deleteCategoryId + ".");
                    }
                    break;
                case 5:
                    System.out.println("Exiting Category CRUD operations...");
                    break;
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
    
    

    private static void performCustomerCRUD(CustomerDAO customerDAO) {
    	Scanner scanner = new Scanner(System.in);
    	

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
    	                
    	                System.out.print("Enter the ID of the customer to update: ");
    	                int customerIdToUpdate = scanner.nextInt();
    	                if (customerExists(customerIdToUpdate, customerDAO)) {
    	                    System.out.print("Enter updated first name: ");
    	                    String updatedFirstName = scanner.next();
    	                    System.out.print("Enter updated last name: ");
    	                    String updatedLastName = scanner.next();
    	                    System.out.print("Enter updated email: ");
    	                    String updatedEmail = scanner.next();
    	                    System.out.print("Enter updated city: ");
    	                    String updatedCity = scanner.next();
    	                    System.out.print("Enter updated state: ");
    	                    String updatedState = scanner.next();
    	                    System.out.print("Enter updated postal code: ");
    	                    String updatedPostalCode = scanner.next();
    	                    System.out.print("Enter updated country: ");
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
            if (customer.getCustomerId() == customerId) {
                return true;
            }
        }
		// TODO Auto-generated method stub
		return false;
	}

	private static void performOrderCRUD(OrderDAO 
			orderDAO) {
		 try {
		      
		        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatefirstproject2", "root", "240302");

		        
		        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
		        EntityManager em = emf.createEntityManager();

		       
		        Scanner scanner = new Scanner(System.in);
		        int choice;

		        do {
		            System.out.println("Choose CRUD operation:");
		            System.out.println("1. Create");
		            System.out.println("2. Read");
		            System.out.println("3. Update");
		            System.out.println("4. Delete");
		            System.out.println("5. Perform Order CRUD");
		            System.out.println("0. Exit");
		            System.out.print("Enter your choice: ");
		            choice = scanner.nextInt();
		            Order order =null;

		            switch (choice) {
		                case 1:
		                    
		                    
		                   
		                    System.out.print("Enter customer ID: ");
		                    int customerId = scanner.nextInt();
		                    ((com.Project.Order) order).setCustomerID(customerId);
		                    ((com.Project.Order) order).setOrderDate(LocalDateTime.now()); // Set order date to current date/time
		                    ((com.Project.Order) order).setStatus(OrderStatus.NEW); // Assuming default status is NEW

		                   
		                    System.out.print("Enter total amount: ");
		                    double totalAmount = scanner.nextDouble();
		                    ((com.Project.Order) order).setTotalAmount(totalAmount);

		                   
		                    orderDAO.createOrder(order);
		                    System.out.println("Order created successfully.");
		                    break;

		                case 2:
		                    
		                    System.out.print("Enter order ID to read: ");
		                    int orderId = scanner.nextInt();
		                    Order readOrder = (Order) orderDAO.getOrderById(orderId);
		                    if (readOrder != null) {
		                        System.out.println("Order ID: " + ((Payment) readOrder).getOrderID());
		                        
		                    } else {
		                        System.out.println("Order not found.");
		                    }
		                    break;

		                case 3:
		                
		                    System.out.print("Enter order ID to update: ");
		                    int orderIdToUpdate = scanner.nextInt();
		                    Order updateOrder = (Order) orderDAO.getOrderById(orderIdToUpdate);
		                    if (updateOrder != null) {
		                       
		                        ((com.Project.Order) updateOrder).setStatus(OrderStatus.NEW); // Updating status to NEW
		                        orderDAO.updateOrder(updateOrder);
		                        System.out.println("Order updated successfully.");
		                    } else {
		                        System.out.println("Order not found.");
		                    }
		                    break;

		                case 4:
		                   
		                    System.out.print("Enter order ID to delete: ");
		                    int orderIdToDelete = scanner.nextInt();
		                    boolean isDeleted = orderDAO.deleteOrder(orderIdToDelete);
		                    if (isDeleted) {
		                        System.out.println("Order deleted successfully.");
		                    } else {
		                        System.out.println("Order not found or deletion failed.");
		                    }
		                    break;

		                case 5:
		                    
		                    performOrderCRUD(orderDAO);
		                    break;

		                case 0:
		                    System.out.println("Exiting...");
		                    break;

		                default:
		                    System.out.println("Invalid choice. Please enter a number between 0 and 5.");
		            }
		        } while (choice != 0);
		        
                scanner.close();
		        connection.close(); 
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		 em.close();
	     emf.close();
		}
	
    	
    private static void performPaymentCRUD(PaymentDAO 
    		paymentDAO) {
    	try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatefirstproject2", "root", "240302");
           

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("Choose CRUD operation for Payments:");
                System.out.println("1. Create Payment");
                System.out.println("2. Read Payments");
                System.out.println("3. Update Payment");
                System.out.println("4. Delete Payment");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                      
                        System.out.println("Enter Payment details:");
                        System.out.print("Payment ID: ");
                        int paymentID = scanner.nextInt();
                        System.out.print("Order ID: ");
                        int orderID = scanner.nextInt();
                        System.out.print("Payment Date (YYYY-MM-DD HH:MM:SS): ");
                        scanner.nextLine(); 
                        String paymentDateString = scanner.nextLine();
                        LocalDateTime paymentDate = LocalDateTime.parse(paymentDateString);
                        System.out.print("Amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); 
                        System.out.print("Payment Method: ");
                        String paymentMethod = scanner.nextLine();
                        System.out.print("Transaction ID: ");
                        String transactionID = scanner.nextLine();

                        Payment payment = new Payment(paymentID, orderID, paymentDate, amount, paymentMethod, transactionID);
                        paymentDAO.createPayment(payment);
                        System.out.println("Payment created successfully.");
                        break;

                    case 2:
                        
                        List<Payment> payments = paymentDAO.getAllPayments();
                        if (payments.isEmpty()) {
                            System.out.println("No payments found.");
                        } else {
                            System.out.println("Payments:");
                            for (Payment p : payments) {
                                System.out.println(p);
                            }
                        }
                        break;

                    case 3:
                       
                        System.out.println("Update Payment operation is not implemented.");
                        break;

                    case 4:
                        
                        System.out.println("Delete Payment operation is not implemented.");
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
    }


    private static void performPersonCRUD(PersonDAO personDAO) {
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
                        System.out.print("Age: ");
                        int age = scanner.nextInt();

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
    }
        
    

    private static void performProductCRUD(ProductDAO 
    		productDAO) {
    	try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatefirstproject2", "root", "240302");
            
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("Choose CRUD operation for Products:");
                System.out.println("1. Create Product");
                System.out.println("2. Read Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        
                        System.out.println("Enter Product details:");
                        System.out.print("Product ID: ");
                        int productID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Description: ");
                        String description = scanner.nextLine();
                        System.out.print("Price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Stock Quantity: ");
                        int stockQuantity = scanner.nextInt();
                        System.out.print("Category ID: ");
                        int categoryID = scanner.nextInt();

                        Product product = new Product();
                        product.setProductID(productID);
                        product.setName(name);
                        product.setDescription(description);
                        product.setPrice(price);
                        product.setStockQuantity(stockQuantity);
                        product.setCategoryID(categoryID);

                        productDAO.createProduct(product);
                        System.out.println("Product created successfully.");
                        break;

                    case 2:
                       
                        List<Product> products = productDAO.getAllProducts();
                        if (products.isEmpty()) {
                            System.out.println("No products found.");
                        } else {
                            System.out.println("Products:");
                            for (Product p : products) {
                                System.out.println(p);
                            }
                        }
                        break;

                    case 3:
                        
                        System.out.println("Update Product operation is not implemented.");
                        break;

                    case 4:
                        
                        System.out.println("Delete Product operation is not implemented.");
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
    }
        
    
    private static void performOrderDetailCRUD(OrderDetailDAO 
    		orderDetailDAO) {
    	try {
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatefirstproject2", "root", "240302");

            
            
            
            System.out.println("Welcome to E-commerce CRUD Operations");
            System.out.println("1. Retrieve all Order Details");
            System.out.println("2. Insert an Order Detail");
            System.out.println("3. Update an Order Detail");
            System.out.println("4. Delete an Order Detail");
            System.out.println("5. Exit");

            System.out.println("Please enter the number corresponding to the operation you want to perform:");
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    
                    List<OrderDetail> orderDetails = orderDetailDAO.getAllOrderDetails();
                    for (OrderDetail orderDetail : orderDetails) {
                        System.out.println(orderDetail);
                    }
                    break;
                case 2:
                    
                    OrderDetail newOrderDetail = new OrderDetail();
                    
                    orderDetailDAO.insert(newOrderDetail);
                    System.out.println("New order detail inserted successfully.");
                    break;
                case 3:
                	 
                    System.out.println("Enter the ID of the order detail you want to update:");
                    int updateId = scanner.nextInt();
                    System.out.println("Enter the new quantity:");
                    int newQuantity = scanner.nextInt();
                    System.out.println("Enter the new total price:");
                    double newTotalPrice = scanner.nextDouble();
                    
                    OrderDetail updatedOrderDetail = new OrderDetail();
                    updatedOrderDetail.setId(updateId);
                    updatedOrderDetail.setQuantity(newQuantity);
                    updatedOrderDetail.setTotalPrice(newTotalPrice);
                    orderDetailDAO.update(updatedOrderDetail);
                   
                    System.out.println("Order detail updated successfully.");
                    break;
                case 4:
                	
                    System.out.println("Enter the ID of the order detail you want to delete:");
                    int deleteId = scanner.nextInt();
                    orderDetailDAO.delete(deleteId);
                    
                    System.out.println("Order detail deleted successfully.");
                    break;
              
                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);
                
            }
            

            scanner.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
    	
    	em.close();
        emf.close();
    }  
    
}
