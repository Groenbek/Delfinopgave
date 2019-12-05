package datasovs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class DBConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/dolphinclub?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection con = null;

    private DBConnector() {
    }

    //Establish connection to database
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
}