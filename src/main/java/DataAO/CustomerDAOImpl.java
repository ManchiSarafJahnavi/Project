package DataAO;

import com.Project.Address;
import com.Project.Customer;


import DataInsersion.HibernateUtil;



import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    public CustomerDAOImpl(Object connected) {
		// TODO Auto-generated constructor stub
	}

	public CustomerDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public Customer getCustomerById(int customerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Customer.class, customerId);
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Customer", Customer.class).getResultList();
        }
    }

    @Override
    public void create(Customer customer) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, customerId);
            if (customer != null) {
                session.delete(customer);
            }
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

		@Override
		public void create(Address newAddress) {
			// TODO Auto-generated method stub
			
		}
	    

		
}
