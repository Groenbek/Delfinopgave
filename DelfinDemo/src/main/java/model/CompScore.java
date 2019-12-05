package model;

/*
* @Authors: Michael Ibsen, Rasmus Grønbek, Sebastian Bentley, Sebastian Hansen
*/
public class CompScore {

    private int seId, mId, dId, placement;

    //CompScore is used in mappers.MembersToComp
    public CompScore(int seId, int mId, int dId, int placement) {
        this.seId = seId;
        this.mId = mId;
        this.dId = dId;
        this.placement = placement;
    }

    @Override
    public String toString() {
        return "Stævne ID: " + seId + ", Medlemnummer: " + mId + ", Disciplin ID: " + dId + ", Placering: " + placement;
    }
}