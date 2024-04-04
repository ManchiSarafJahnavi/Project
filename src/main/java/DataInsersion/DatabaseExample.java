package DataInsersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
public class DatabaseExample {
	public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/virtualmalldb";
        String user = "root";
        String password = "240302";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
            // Perform database operations here
        } catch (SQLException e) {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
            // Handle specific exceptions
            if (e instanceof CommunicationsException) {
                // Handle communications link failure
                // Attempt to reconnect or perform other recovery actions
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
