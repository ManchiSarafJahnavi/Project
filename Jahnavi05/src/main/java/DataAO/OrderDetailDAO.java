package DataAO;


import java.util.List;

import com.Project.OrderDetail;

public interface OrderDetailDAO {
    OrderDetail getOrderDetailById(int orderDetailID);
    
    List<OrderDetail> getAllOrderDetails();
    
    void addOrderDetail(OrderDetail orderDetail);
    
    void updateOrderDetail(OrderDetail orderDetail);
    
    void deleteOrderDetail(int orderDetailID);

	void delete(int deleteId);

	void insert(OrderDetail newOrderDetail);

	void update(OrderDetail updatedOrderDetail);

	

}
