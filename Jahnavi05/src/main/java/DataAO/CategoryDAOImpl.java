package DataAO;
import com.Project.*;
import DataInsersion.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.sql.Connection;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
	
	

	@Override
    public Category getCategoryById(int categoryId) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            return entityManager.find(Category.class, categoryId);
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public List<Category> getAllCategories() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT c FROM Category c", Category.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public void addCategory(Category category) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(category);
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
    public void updateCategory(Category category) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(category);
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
    public void deleteCategory(int categoryId) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Category category = entityManager.find(Category.class, categoryId);
            if (category != null) {
                entityManager.remove(category);
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
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int deleteCategoryId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void create(Category newCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category existingCategory) {
		// TODO Auto-generated method stub
		
	}

}
