package mappers;

import java.util.ArrayList;
import model.Result;
import org.junit.Test;
import static org.junit.Assert.*;

public class MemberTrainingTest {
    
    @Test
    public void testGetResults() {
        //Arrange
        int dId = 1;
        MemberTraining instance = new MemberTraining();
        ArrayList<Result> result = null;
        //Act
        result = instance.getResults(dId);
        //Assert
        assertNotNull(result);
    }
}