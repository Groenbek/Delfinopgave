package model;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class Result {
    private int id;
    private Discipline disc;
    private int time;
    
    //Used in mappers.MemberTraining
    public Result(int id, Discipline disc, int tid) {
        this.id = id;
        this.disc = disc;
        this.time = tid;
    }
    
    //Used in toString to print time
    private String timeConverter() {
        String s = String.valueOf(time);
        if (s.length()==3) {
            String s1 = s.substring(0,s.length()-2);
            String s2 = s.substring(s.length()-2);
            return s1+":"+s2;
        } else {
            return s;
        }
    }

    public int getId() {
        return id;
    }
    
    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "medlemsnummer: " + id + "\tDisciplin: " + disc + "\ttid: " + timeConverter();
    }
}
