package people;

public class Member {

    private String mName;
    private int age;
    private String actOrPas;
    private String competitive;

    public Member(String mName, int age, String actOrPas, String competitive) {
        this.mName = mName;
        this.age = age;
        this.actOrPas = actOrPas;
        this.competitive = competitive;
    }

    public String getmId() {
        return null;
        //Hent mId fra DB evt?
    }
    public String getmName() {
        return mName;
    }

    public int getAge() {
        return age;
    }

    public String getActOrPas() {
        return actOrPas;
    }

    public String getCompetitive() {
        return competitive;
    }

}
