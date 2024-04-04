package DataAO;

import java.util.List;

import com.Project.Address;

public interface AddressDAO {

	Address getAddressById(int addressID);

	List<Address> getAllAddresses();

	void addAddress(Address address);

	void updateAddress(Address address);

	void deleteAddress(int addressID);

	void delete(int addressIdToDelete);

	void create(Address newAddress);

	void update(Address addressToUpdate);

	

	

	
   

}
