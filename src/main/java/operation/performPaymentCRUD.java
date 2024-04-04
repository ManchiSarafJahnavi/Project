package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.Project.Payment;

import DataAO.PaymentDAO;
import DataAO.PaymentDAOImpl;

public class performPaymentCRUD {
	public static void main(String[] args) {

	// TODO Auto-generated method stub
	}

	public void performCRUD() {
		Object Connected = null;
		PaymentDAO paymentDAO = new PaymentDAOImpl(Connected);
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
                    LocalDateTime paymentDate = LocalDateTime.parse(paymentDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("Payment Method(COD or ONLINE): ");
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
		// TODO Auto-generated method stub
		
	}
}
