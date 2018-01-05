package trackride;

/**
 * Created by sheebanshaikh on 8/16/16.
 */


public class TrackRide implements TrackStatus {

    String position;

    Integer gpsLoc;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getGpsLoc() {
        return gpsLoc;
    }

    public void setGpsLoc(Integer gpsLoc) {
        this.gpsLoc = gpsLoc;
    }

    @Override
    public void update() {
        System.out.println("Performing Updations");
    }

    @Override
    public void onStartNotify() {
        System.out.println("Performing Start Notifications");
    }

    @Override
    public void onEndNotify() {
        System.out.println("Performing End Notifications");
    }
}
