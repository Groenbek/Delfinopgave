package presentation;

import java.util.Comparator;
import model.Result;

public class RestultComparator implements Comparator<Result> {
 
    @Override
    public int compare(Result r1, Result r2){
        return r1.getTime() - r2.getTime();
        
    }   
}
