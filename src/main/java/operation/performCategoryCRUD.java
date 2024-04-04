package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.Project.Category;

import DataAO.CategoryDAO;
import DataAO.CategoryDAOImpl;

public class performCategoryCRUD {
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
	}

	public void performCRUD() {
		Object Connected = null;
		CategoryDAO categoryDAO = new CategoryDAOImpl(Connected);
        
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
                System.out.println("Name: ");
                String name = scanner.next();
                try {
                    System.out.println("Parent Category: ");
                    
                    // Rest of your code for handling the parentCategory value goes here
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input format. Please enter a valid integer for Parent Category.");
                    scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
                }
                System.out.println("Category ID: ");
                int categoryId = scanner.nextInt();

                Category newCategory = new Category();
                newCategory.setName(name);
               
				Category parentCategory = null;
				newCategory.setParentCategory(parentCategory);
                newCategory.setCategoryId(categoryId);

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
                System.out.print("New parent category ID: ");
                int newParentCategory = scanner.nextInt();
                System.out.print("New category ID: ");
                int newCategoryId = scanner.nextInt();

                Category existingCategory = categoryDAO.getCategoryById(updateCategoryId);

                if (existingCategory != null) {
                    if (!newName.isEmpty()) {
                        existingCategory.setName(newName);
                    }
                   
					existingCategory.setParentCategory(newParentCategory);
                    existingCategory.setCategoryId(newCategoryId);

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
		// TODO Auto-generated method stub
		
	}
	

}
