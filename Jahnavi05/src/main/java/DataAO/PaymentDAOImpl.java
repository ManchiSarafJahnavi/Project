package DataAO;


import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.Project.Payment;

import DataInsersion.HibernateUtil;

public class PaymentDAOImpl implements PaymentDAO {
	

	

	


	@Override
    public Payment getPaymentById(int paymentID) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            return entityManager.find(Payment.class, paymentID);
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public List<Payment> getAllPayments() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT p FROM Payment p", Payment.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public void addPayment(Payment payment) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(payment);
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
    public void updatePayment(Payment payment) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(payment);
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
    public void deletePayment(int paymentID) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Payment payment = entityManager.find(Payment.class, paymentID);
            if (payment != null) {
                entityManager.remove(payment);
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
	public void createPayment(Payment payment) {
		// TODO Auto-generated method stub
		
	}


}
