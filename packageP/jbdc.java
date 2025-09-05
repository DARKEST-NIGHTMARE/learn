import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jbdc {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/login";
        String username = "postgres";
        String password = "argusadmin";

        try {
            // Load the PostgreSQL JDBC driver (optional for modern JDBC versions, but good practice)
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            if (connection != null) {
                System.out.println("Connected to PostgreSQL database successfully!");
                // Perform database operations here
                // ...
            }

            // Close the connection
            connection.close();

        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }
}