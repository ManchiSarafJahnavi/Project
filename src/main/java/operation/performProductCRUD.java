package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.Project.Product;

import DataAO.ProductDAO;
import DataAO.ProductDAOImpl;

public class performProductCRUD {
	public static void main(String[] args) {

	}

	public void performCRUD() {
		Object Connected = null;
	    ProductDAO productDAO = new ProductDAOImpl(Connected);
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
		// TODO Auto-generated method stub
		
	}
}


