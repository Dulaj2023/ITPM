package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    public static Connection getConnection(){
     
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:itpm.db");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
}
