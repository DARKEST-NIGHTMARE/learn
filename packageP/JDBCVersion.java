import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCVersion {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/login";
        String user = "postgres";
        String password = "argusadmin";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData dbmd = con.getMetaData();
            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            System.out.println("Major Version: " + dbmd.getDriverMajorVersion());
            System.out.println("Minor Version: " + dbmd.getDriverMinorVersion());
        } catch (SQLException e) {
            System.err.println("Error getting driver information.");
            e.printStackTrace();
        }
    }
}
