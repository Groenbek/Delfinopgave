package mappers;

import java.util.ArrayList;
import model.CompScore;
import model.SwimEvent;
import org.junit.Test;
import static org.junit.Assert.*;


public class MembersToCompTest {
    
    @Test
    public void testGetSwimEvents() {
        //Arrange
        MembersToComp instance = new MembersToComp();
        ArrayList<SwimEvent> result = null;
        //Act
        result = instance.getSwimEvents();
        //Assert
        assertNotNull(result);
    }
    
    @Test
    public void testGetAllMemberAndScores() {
        //Arrange
        MembersToComp instance = new MembersToComp();
        ArrayList<CompScore> result = null;
        //Act
        result = instance.getAllMemberAndScores();
        //Assert
        assertNotNull(result);
    }
}