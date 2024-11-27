/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.jdbc;
import java.sql.SQLException ;
import java.sql.Connection ;
import java.sql.DriverManager ;
/**
 *
 * @author nicho
 */
public class ConnectionFactory {
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:postgresql://localhost/",
                    "root",
                    "") ;
    }
}
