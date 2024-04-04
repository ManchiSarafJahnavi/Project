package DataAO;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.Project.Address;

import DataInsersion.HibernateUtil;

import java.sql.Connection;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {
    
	@Override
    public Address getAddressById(int addressID) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
        	Query query = entityManager.createQuery("SELECT a FROM Address a WHERE a.id = :addressID", Address.class);
        	query.setParameter("addressID", addressID);
            return entityManager.find(Address.class, addressID);
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public List<Address> getAllAddresses() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT a FROM Address a", Address.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public void addAddress(Address address) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(address);
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
    public void updateAddress(Address address) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(address);
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
    public void deleteAddress(int addressID) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Address address = entityManager.find(Address.class, addressID);
            if (address != null) {
                entityManager.remove(address);
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
	public void delete(int addressIdToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Address newAddress) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Address addressToUpdate) {
		// TODO Auto-generated method stub
		
	}

	
}
