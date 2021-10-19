import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class text {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///day14", "root", "root");
        System.out.println(connection);
    }
}
