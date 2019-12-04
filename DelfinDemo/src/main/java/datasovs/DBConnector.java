package datasovs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnector {

    //private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/dolphinclub?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection con = null;
    
    private DBConnector(){
    }

    public static Connection getConnection() {
        if (con == null) {

            try {
                con = DriverManager.getConnection(URL, USER, PASSWORD);
                return con;

            } catch (SQLException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;

    }

    public static void main(String[] args) {
        new DBConnector().getConnection();
    }

}
