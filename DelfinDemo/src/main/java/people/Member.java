package people;

public class Member {

    private int mId;
    private String mName;
    private int age;
    private String actOrPas;
    private String competitive;

    public Member(int mId, String mName, int age, String actOrPas, String competitive) {
        this.mName = mName;
        this.age = age;
        this.actOrPas = actOrPas;
        this.competitive = competitive;
    }

    public int getmId() {
        return mId;
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

    @Override
    public String toString() {
        return "Member{" + "mId=" + mId + ", mName=" + mName + ", age=" + age + ", actOrPas=" + actOrPas + ", competitive=" + competitive + '}';
    }


}
