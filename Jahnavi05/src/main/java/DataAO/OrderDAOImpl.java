package DataAO;
import com.Project.Order;
import com.Project.OrderDetail;
import DataInsersion.HibernateUtil;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.Project.Order;

import DataInsersion.HibernateUtil;

public class OrderDAOImpl implements OrderDAO{
	


	@Override
    public Order getOrderById(int OrderId){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            return entityManager.find(Order.class, OrderId);
        } finally {
            entityManager.close();
        }
    }
    
	@Override
    public List<javax.persistence.criteria.Order> getAllOrders() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT o FROM Order o", Order.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
    
	@Override
    public void addOrder(Order order) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(order);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    
	@Override   
    public void updateOrder(Order order) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(order);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    
	@Override
    public boolean deleteOrder(int orderID) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Order order = entityManager.find(Order.class, orderID);
            if (order != null) {
                entityManager.remove(order);
            }
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
		return false;
    }


	@Override
	public void updateOrder(javax.persistence.criteria.Order updateOrder) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createOrder(javax.persistence.criteria.Order order) {
		// TODO Auto-generated method stub
		
	}



}
