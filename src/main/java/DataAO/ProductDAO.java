package DataAO;

import java.util.List;

import com.Project.Product;

public interface ProductDAO {

	Product getProductById(int productID);

	

	void addProduct1(Product product);

	void updateProduct1(Product product);

	void deleteProduct(int productID);

	void addProduct(Product product);

	void updateProduct(Product product);

	List<Product> getAllProducts();



	void createProduct(Product product);
    
    
    
	
}
