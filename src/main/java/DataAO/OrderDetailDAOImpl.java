package DataAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;





import com.Project.OrderDetail;

import DataInsersion.HibernateUtil;


import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    public OrderDetailDAOImpl(Object connected) {
        // Constructor
    }

    @Override
    public OrderDetail getOrderDetailById(int orderDetailID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(OrderDetail.class, orderDetailID);
        }
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<OrderDetail> query = session.createQuery("FROM OrderDetail", OrderDetail.class);
            return query.getResultList();
        }
    }

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(orderDetail);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(orderDetail);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteOrderDetail(int orderDetailID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            OrderDetail orderDetail = session.get(OrderDetail.class, orderDetailID);
            if (orderDetail != null) {
                session.delete(orderDetail);
                transaction.commit();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    

    

	@Override
	public void delete(int deleteId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(OrderDetail newOrderDetail) {
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            Transaction transaction = session.beginTransaction();
	            session.persist(newOrderDetail);
	            transaction.commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(OrderDetail updatedOrderDetail) {
		// TODO Auto-generated method stub
		
	}

	
}
