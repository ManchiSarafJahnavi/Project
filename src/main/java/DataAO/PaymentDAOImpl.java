package DataAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;




import com.Project.Payment;

import DataInsersion.HibernateUtil;

public class PaymentDAOImpl implements PaymentDAO {
    public PaymentDAOImpl(Object connected) {
        // Constructor
    }

    @Override
    public Payment getPaymentById(int paymentID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Payment.class, paymentID);
        }
    }

    @Override
    public List<Payment> getAllPayments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Payment> query = session.createQuery("FROM Payment", Payment.class);
            return query.getResultList();
        }
    }

    @Override
    public void createPayment(Payment payment) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(payment);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updatePayment(Payment payment) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(payment);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deletePayment(int paymentID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Payment payment = session.get(Payment.class, paymentID);
            if (payment != null) {
                session.delete(payment);
                transaction.commit();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	@Override
	public void addPayment(Payment payment) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(payment);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		// TODO Auto-generated method stub
		
	}
	



	


}
