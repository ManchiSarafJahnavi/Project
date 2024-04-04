package DataAO;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.Project.Person;

import DataInsersion.HibernateUtil;

public class PersonDAOImpl implements PersonDAO{
    

	@Override
    public Person getPersonById(int personID) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            return entityManager.find(Person.class, personID);
        } finally {
            entityManager.close();
        }
    }
	@Override
    public List<Person> getAllPersons() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT p FROM Person p", Person.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
	@Override
    public void addPerson(Person person) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(person);
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
    public void updatePerson(Person person) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(person);
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
    public void deletePerson(int personID) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Person person = entityManager.find(Person.class, personID);
            if (person != null) {
                entityManager.remove(person);
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
	public void createPerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	
}
