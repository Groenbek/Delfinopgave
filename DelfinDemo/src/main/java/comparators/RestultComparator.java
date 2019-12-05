package comparators;

import java.util.Comparator;
import model.Result;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class RestultComparator implements Comparator<Result> {
 
    //Compare timevalue from results, used in 
    @Override
    public int compare(Result r1, Result r2){
        return r1.getTime() - r2.getTime();
    }   
}