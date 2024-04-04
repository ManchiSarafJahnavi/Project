package DataAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



import com.Project.Product;

import DataInsersion.HibernateUtil;

public class ProductDAOImpl implements ProductDAO{
	
    public ProductDAOImpl(Object connected) {
        // Constructor
    }
    
    @Override
    public Product getProductById(int productID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Product.class, productID);
        }
    }
    
    @Override
    public List<Product> getAllProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery("FROM Product", Product.class);
            return query.getResultList();
        }
    }
    
    @Override
    public void addProduct(Product product) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void updateProduct(Product product) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void deleteProduct(int productID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Product product = session.get(Product.class, productID);
            if (product != null) {
                session.delete(product);
                transaction.commit();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
	
	@Override
	public void createProduct(Product product) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProduct1(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct1(Product product) {
		// TODO Auto-generated method stub
		
	}

	

	
}
