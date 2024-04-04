package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.Project.OrderDetail;

import DataAO.OrderDetailDAO;
import DataAO.OrderDetailDAOImpl;

public class performOrderDetailCRUD {
	public static void main(String[] args) {
  
		// TODO Auto-generated method stub
	}

	public void performCRUD() {
	 	Object Connected = null;
		OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl(Connected);
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
		// TODO Auto-generated method stub
		
	}
}