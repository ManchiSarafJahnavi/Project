package DataAO;

import java.util.List;

import com.Project.Order;

public interface OrderDAO {

	Order getOrderById(int OrderId);

	List<Order> getAllOrders();

	void addOrder(Order order);

	void updateOrder(javax.persistence.criteria.Order updateOrder);

	boolean deleteOrder(int orderID);

	void createOrder(Order order);

	void updateOrder(Order order);

	javax.persistence.criteria.Order getOrderByID(int orderID);

	
    
}
