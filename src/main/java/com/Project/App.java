package com.Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Scanner;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import operation.performAddressCRUD;
import operation.performCategoryCRUD;
import operation.performCustomerCRUD;
import operation.performOrderCRUD;
import operation.performOrderDetailCRUD;
import operation.performPaymentCRUD;
import operation.performPersonCRUD;
import operation.performProductCRUD;






/**
 * Hello world!
 *
 */
public class App {

	static Object Connected;

	public static void main( String[] args )
    {
		System.out.println( "WELCOME" );
		System.out.println( "The Project begins HERE !!!!!!........" );
		
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
    	
    	
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
                
                switch (choice) {
                case 1:
                    performAddressCRUD addressCRUD = new performAddressCRUD();
                    addressCRUD.performCRUD();
                    break;
                case 2:
                    performCategoryCRUD categoryCRUD = new performCategoryCRUD();
                    categoryCRUD.performCRUD();
                    break;
                case 3:
                    performCustomerCRUD customerCRUD = new performCustomerCRUD();
                    customerCRUD.performCRUD();
                    break;
                case 4:
                    performOrderDetailCRUD orderDetailCRUD = new performOrderDetailCRUD();
                    orderDetailCRUD.performCRUD();
                    break;
                case 5:
                    performOrderCRUD orderCRUD = new performOrderCRUD();
                    orderCRUD.performCRUD();
                    break;
                case 6:
                    performPaymentCRUD paymentCRUD = new performPaymentCRUD();
                    paymentCRUD.performCRUD();
                    break;
                case 7:
                    performPersonCRUD personCRUD = new performPersonCRUD();
                    personCRUD.performCRUD();
                    break;
                case 8:
                    performProductCRUD productCRUD = new performProductCRUD();
                    productCRUD.performCRUD();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    connection.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
                    
                    scanner.close();
            }
                
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
                
            
            
        
        System.out.println(factory);
        System.out.println(factory.isClosed());
            
    }

	
}