package DataAO;




import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.Project.OrderDetail;

import DataInsersion.HibernateUtil;

import java.sql.Connection;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    
	
	@Override
    public OrderDetail getOrderDetailById(int orderDetailID) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            return entityManager.find(OrderDetail.class, orderDetailID);
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public List<OrderDetail> getAllOrderDetails() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT od FROM OrderDetail od", OrderDetail.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(orderDetail);
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
    public void updateOrderDetail(OrderDetail orderDetail) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(orderDetail);
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
    public void deleteOrderDetail(int orderDetailID) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            OrderDetail orderDetail = entityManager.find(OrderDetail.class, orderDetailID);
            if (orderDetail != null) {
                entityManager.remove(orderDetail);
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
    }

	@Override
	public void delete(int deleteId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(OrderDetail newOrderDetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(OrderDetail updatedOrderDetail) {
		// TODO Auto-generated method stub
		
	}

	
}
