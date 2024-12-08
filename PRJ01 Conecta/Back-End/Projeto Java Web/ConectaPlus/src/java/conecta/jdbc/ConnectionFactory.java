package conecta.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public static Connection getConnection() throws SQLException{
        
        return DriverManager.getConnection(
                "jdbc:mariadb://localhost:3307/conecta_plus",
                "root",
                "0000"
                );
    }
}
