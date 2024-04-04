package DataAO;
import com.Project.*;
import DataInsersion.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;






import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
	
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Category getCategoryById(int categoryId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Category.class, categoryId);
        }
    }

    @Override
    public List<Category> getAllCategories() {
        try (Session session = sessionFactory.openSession()) {
            Query<Category> query = session.createQuery("FROM Category", Category.class);
            return query.getResultList();
        }
    }

    @Override
    public void addCategory(Category category) {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
  
    }

    @Override
    public void updateCategory(Category category) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(category);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(int categoryId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Category category = session.get(Category.class, categoryId);
            if (category != null) {
                session.delete(category);
            }
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
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
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(newCategory);
            transaction.commit();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category existingCategory) {
		// TODO Auto-generated method stub
		
	}
	
	public CategoryDAOImpl(Object connected) {
		// TODO Auto-generated constructor stub
	}


}
