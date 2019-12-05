package datasovs;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

public class DBConnectorTest {
    
    @Test
    public void testGetConnection() {
        //Arrange
        Connection result = null;
        //Act
        result = DBConnector.getConnection();
        //Assert
        assertNotNull(result);
    }
    
    @Test
    public void testInstanceOfConnection() {
        //Arrange
        Connection result = null;
        //Act
        result = DBConnector.getConnection();
        //Assert
        assertTrue(result instanceof Connection);
    }
}