package model;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class SwimEvent {
    private String seName;
    private int seId;
    private String seDate;

    //Used in mappers.MembersToComp
    public SwimEvent(int seId, String seDate, String seName) {
        this.seDate = seDate;
        this.seId = seId;
        this.seName = seName;
    }

    public int getSeId() {
        return seId;
    }

    public String getSeDate() {
        return seDate;
    }

    public String getSeName() {
        return seName;
    }

    @Override
    public String toString() {
        return "Stævne ID: " + seId + ", Dato: " + seDate + ", Navn: " + seName;
    }
}