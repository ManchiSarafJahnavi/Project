package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.Scanner;


import javax.persistence.criteria.Order;

import com.Project.OrderStatus;
import com.Project.Payment;

import DataAO.OrderDAO;
import DataAO.OrderDAOImpl;

public class performOrderCRUD {
	

	private final com.Project.Order order = new com.Project.Order();
	private com.Project.Order neworder;
	
	



	public static void main(String[] args) {

	// TODO Auto-generated method stub
	}


	


	public void performCRUD() {
		Object Connected = null;
		OrderDAO orderDAO = new OrderDAOImpl(Connected);
		try {
	      
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatefirstproject2", "root", "240302");

	        
	       
	        Scanner scanner = new Scanner(System.in);
	        int choice;
	        

	        do {
	            System.out.println("Choose CRUD operation:");
	            System.out.println("1. Create");
	            System.out.println("2. Read");
	            System.out.println("3. Update");
	            System.out.println("4. Delete");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	           

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter customer ID: ");
	                    int customerId = scanner.nextInt();
	                    
	                    if (this.order == null) {
	                        System.out.println("Error: Order object is not initialized.");
	                        return; // Exit the method or handle the error appropriately
	                    }
	                    
	                    ((com.Project.Order) this.order).setCustomerId(customerId); 

	                    // Assuming Order has a default constructor
	                    ((com.Project.Order) order).setOrderDate(LocalDateTime.now()); // Set order date to current date/time
	                    ((com.Project.Order) order).setStatus(OrderStatus.NEW); // Assuming default status is NEW

	                    System.out.print("Enter total amount: ");
	                    double totalAmount = scanner.nextDouble();
	                    ((com.Project.Order) order).setTotalAmount(totalAmount);
	                    
	                    orderDAO.createOrder(neworder);
	                    System.out.println("Order created successfully.");
	                    
	                    break;

	                case 2:
	                    
	                    System.out.print("Enter order ID to read: ");
	                    int orderID = scanner.nextInt();
	                    Order readOrder = (Order) orderDAO.getOrderByID(orderID);
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
		// TODO Auto-generated method stub
		
	}
}
