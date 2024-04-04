package DataAO;
import com.Project.Customer;

import java.util.List;

public interface CustomerDAO {
    Customer getCustomerById(int customerId);
    
    List<Customer> getAllCustomers();
    
    
    
    void updateCustomer(Customer customer);
    
    void deleteCustomer(int customerId);

	//void delete(int customerId);

	//void update(Customer updatedCustomer);

	void create(Customer newCustomer);

	

	 

}
