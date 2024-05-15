import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    //This part is for storing the constant database connection arguments
    public static final String DB_URL = "jdbc:postgresql://aws-0-eu-central-1.pooler.supabase.com:5432/postgres";
    public static final String USER = "postgres.xhvjpeugrlcwsgfcznpe";
    public static final String PASSWORD = "cokzorbirsifrebu";


//Function that establishes connection with DB
    public static Connection connect() {
        try {
//            System.out.println("Connected to PostgreSQL database");   To check for us
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
