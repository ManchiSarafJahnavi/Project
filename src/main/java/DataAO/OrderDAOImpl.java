package DataAO;
import com.Project.Order;

import DataInsersion.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;







public class OrderDAOImpl implements OrderDAO{
    public OrderDAOImpl(Object connected) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public Order getOrderById(int orderId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Order.class, orderId);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Order> query = session.createQuery("FROM Order", Order.class);
            return query.getResultList();
        }
    }

    @Override
    public void addOrder(Order order) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(order);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateOrder(Order order) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(order);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean deleteOrder(int orderId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Order order = session.get(Order.class, orderId);
            if (order != null) {
                session.delete(order);
                transaction.commit();
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }


	

	

	

	@Override
	public void updateOrder(javax.persistence.criteria.Order updateOrder) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(updateOrder);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrder(Order neworder) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Transaction transaction = session.beginTransaction();
	        
	        try {
	            // Validate the newOrder object
	            if (neworder == null) {
	                throw new IllegalArgumentException("New order object is null");
	            }
	            
	            // Save the new order
	            session.save(neworder);
	            transaction.commit();
	            System.out.println("Order created successfully.");
	        } catch (IllegalArgumentException e) {
	            // Handle the IllegalArgumentException
	            System.err.println("Error creating order: " + e.getMessage());
	            // Rollback the transaction if needed
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	    } catch (Exception ex) {
	        // Handle other exceptions
	        ex.printStackTrace();
	    }
		
		
		
	}

	@Override
	public javax.persistence.criteria.Order getOrderByID(int orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	



}
