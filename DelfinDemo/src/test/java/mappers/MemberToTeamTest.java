package mappers;

import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class MemberToTeamTest {
    
    @Test
    public void testGetRestance() {
        //Arrange
        MemberToTeam instance = new MemberToTeam();
        HashMap<Integer, String> result = null;
        //Act
        result = instance.getRestance();
        //Assert
        assertNotNull(result);
    }
}