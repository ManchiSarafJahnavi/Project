package DataAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import com.Project.Address;


import DataInsersion.HibernateUtil;


import java.util.List;

public class AddressDAOImpl implements AddressDAO {
    
	 private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    
	    @Override
	    public Address getAddressById(int addressID) {
	        try (Session session = sessionFactory.openSession()) {
	            Query<Address> query = session.createQuery("FROM Address WHERE id = :addressID", Address.class);
	            query.setParameter("addressID", addressID);
	            return query.uniqueResult();
	        }
	    }
	    
	    @Override
	    public List<Address> getAllAddresses() {
	        try (Session session = sessionFactory.openSession()) {
	            Query<Address> query = session.createQuery("FROM Address", Address.class);
	            return query.getResultList();
	        }
	    }
	    
	    @Override
	    public void createAddress(Address address) {
	        try (Session session = sessionFactory.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            session.save(address);
	            transaction.commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	    
	    @Override
	    public void updateAddress(Address address) {
	        try (Session session = sessionFactory.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            session.merge(address);
	            transaction.commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	    
	    @Override
	    public void deleteAddress(int addressID) {
	        try (Session session = sessionFactory.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            Address address = session.get(Address.class, addressID);
	            if (address != null) {
	                session.delete(address);
	            }
	            transaction.commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
  

	
	
	public AddressDAOImpl(Object connected) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void delete(int addressIdToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Address newAddress) {
		 try (Session session = sessionFactory.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            session.save(newAddress);
	            transaction.commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Address addressToUpdate) {
		// TODO Auto-generated method stub
		
	}


	
}
