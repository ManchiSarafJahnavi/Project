package DataAO;

import com.Project.Person;

import java.util.List;

public interface PersonDAO {
    Person getPersonById(int personID);
    
    List<Person> getAllPersons();
    
    void addPerson(Person person);
    
    void updatePerson(Person person);
    
    void deletePerson(int personID);

	void createPerson(Person person);

}
