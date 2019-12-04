package model;

public class CompScore {
    private int seId, mId, dId, placement;
    
    public CompScore(int seId, int mId, int dId, int placement){
        this.seId = seId;
        this.mId = mId;
        this.dId = dId;
        this.placement = placement;
    }

    @Override
    public String toString() {
        return "LeaderBoard{" + "seId=" + seId + ", mId=" + mId + ", dId=" + dId + ", placement=" + placement + '}';
    }
    
    
    
    
}
