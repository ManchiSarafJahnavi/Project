package DataAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;




import com.Project.Person;

import DataInsersion.HibernateUtil;

public class PersonDAOImpl implements PersonDAO{
	
    public PersonDAOImpl(Object connected) {
        // Constructor
    }

    @Override
    public Person getPersonById(int personID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Person.class, personID);
        }
    }

    @Override
    public List<Person> getAllPersons() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Person> query = session.createQuery("FROM Person", Person.class);
            return query.getResultList();
        }
    }

    @Override
    public void addPerson(Person person) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updatePerson(Person person) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(person);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deletePerson(int personID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Person person = session.get(Person.class, personID);
            if (person != null) {
                session.delete(person);
                transaction.commit();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    

	@Override
	public void createPerson(Person person) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		// TODO Auto-generated method stub
		
	}

	
}
