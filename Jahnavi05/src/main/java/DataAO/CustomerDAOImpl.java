package DataAO;
import com.Project.Customer;
import DataInsersion.HibernateUtil;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;

import javax.persistence.TypedQuery;
import DataAO.CustomerDAO;



import java.sql.Connection;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
	
	
	// CustomerDAO customerDAO = new CustomerDAOImpl();

	    @Override
	    public Customer getCustomerById(int customerId) {
	        EntityManager entityManager = HibernateUtil.getEntityManager();
	        
	        
	        try {
	            return entityManager.find(Customer.class, customerId);
	        } finally {
	            entityManager.close();
	        }
	    }
	    
	    @Override
	    public List<Customer> getAllCustomers() {
	        EntityManager entityManager = HibernateUtil.getEntityManager();
	       
	        
	        try {
	            TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
	            return query.getResultList();
	        } finally {
	            entityManager.close();
	        }
	    }
	    
	    @Override
	    public void create(Customer customer) {
	        EntityManager entityManager = HibernateUtil.getEntityManager();
	        EntityTransaction transaction = entityManager.getTransaction();
	        try {
	            transaction.begin();
	            
	            entityManager.createQuery("INSERT INTO Customers (firstName, lastName, email ,city ,state, postal code, country) VALUES (:firstName, :lastName, :email, :city, :state, :postal code, :country)")
	                         .setParameter("firstName", customer.getFirstName())
	                         .setParameter("lastName", customer.getLastName())
	                         .setParameter("email", customer.getEmail())
	                         .setParameter("city", customer.getCity())
	                         .setParameter("state", customer.getState())
	                         .setParameter("postal code", customer.getPostalCode())
	                         .setParameter("country", customer.getCountry())
	                         .executeUpdate();
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
	    public void updateCustomer(Customer customer) {
	        EntityManager entityManager = HibernateUtil.getEntityManager();
	        EntityTransaction transaction = entityManager.getTransaction();
	        try {
	            transaction.begin();
	            
	            entityManager.createQuery("UPDATE Customer SET firstName = :firstName, lastName = :lastName, email = :email, city = :city, state = :state, postalCode = :postalCode, country = :country WHERE id = :customerId")
	                         .setParameter("firstName", customer.getFirstName())
	                         .setParameter("lastName", customer.getLastName())
	                         .setParameter("email", customer.getEmail())
	                         .setParameter("city", customer.getCity())
	                         .setParameter("state", customer.getState())
	                         .setParameter("postalCode", customer.getPostalCode())
	                         .setParameter("country", customer.getCountry())
	                         .setParameter("customerId", customer.getId())
	                         .executeUpdate();
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
	    public void deleteCustomer(int customerId) {
	        EntityManager entityManager = HibernateUtil.getEntityManager();
	        EntityTransaction transaction = entityManager.getTransaction();
	        try {
	            transaction.begin();
	            
	            entityManager.createQuery("DELETE FROM Customer WHERE id = :customerId")
	                         .setParameter("customerId", customerId)
	                         .executeUpdate();
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
	    

		

}
