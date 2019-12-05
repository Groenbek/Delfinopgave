package mappers;

import java.util.ArrayList;
import model.Member;
import org.junit.Test;
import static org.junit.Assert.*;

public class MemberMapTest {

    @Test
    public void testGetMembers() {
        //Arrange
        MemberMap instance = new MemberMap();
        ArrayList<Member> result = null;
        //Act
        result = instance.getMembers();
        //Assert
        assertNotNull(result);
    }
    
    @Test
    public void testGetMembersInTeam() {
        //Arrange
        int teamID = 0;
        MemberMap instance = new MemberMap();
        ArrayList<Member> result = null;
        //Act
        result = instance.getMembersInTeam(teamID);
        //Assert
        assertNotNull(result);
    }
    
    @Test
    public void testGetMemberId() {
        //Arrange
        MemberMap instance = new MemberMap();
        //Act
        int result = instance.getMemberId();
        //Assert
        assertTrue(result!=0);
    }
}