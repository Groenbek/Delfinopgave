package model;

// @author sebh
public class SwimEvent {

    public SwimEvent(int seId, String seDate, String seName) {
        this.seDate = seDate;
        this.seId = seId;
        this.seName = seName;
    }

    int seId;
    String seDate;

    public int getSeId() {
        return seId;
    }

    public String getSeDate() {
        return seDate;
    }

    public String getSeName() {
        return seName;
    }
    String seName;

    @Override
    public String toString() {
        return "SwimEvent{" + "seId=" + seId + ", seDate=" + seDate + ", seName=" + seName + '}';
    }

}
