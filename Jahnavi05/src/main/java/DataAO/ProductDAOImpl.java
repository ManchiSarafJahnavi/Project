package DataAO;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.Project.Product;

import DataInsersion.HibernateUtil;

public class ProductDAOImpl implements ProductDAO{
    
	@Override
    public Product getProductById(int productID) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            return entityManager.find(Product.class, productID);
        } finally {
            entityManager.close();
        }
    }
    @Override
    public List<Product> getAllProducts() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public void addProduct1(Product product) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(product);
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
    public void updateProduct1(Product product) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(product);
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
    public void deleteProduct(int productID) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Product product = entityManager.find(Product.class, productID);
            if (product != null) {
                entityManager.remove(product);
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
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	
}
