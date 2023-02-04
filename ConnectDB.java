import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {

    private static String URL = "jdbc:postgresql://localhost/wypozyczalnia_sam";
    private static String USER = "postgres";
    private static String PASSWORD = "P@ssw0rd";

    public static Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            //System.out.println("Połączenie z bazą powiodło się!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}