package DataAO;

import java.util.List;

import com.Project.Payment;

public interface PaymentDAO {

	Payment getPaymentById(int paymentID);

	List<Payment> getAllPayments();

	
	

	void deletePayment(int paymentID);

	void updatePayment(Payment payment);

	void addPayment(Payment payment);

	void createPayment(Payment payment);

	

	
    
}
