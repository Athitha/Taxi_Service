package rideManagement;

import routingManagement.ProcessRouting;

import java.util.List;

/**
 * Created by sheebanshaikh on 8/17/16.
 */

public class DenyRide extends MaintainRequest {

    public Integer denyRideId;

    public String request_Type;

    public DenyRide(ProcessRouting processRouting) {
        super(processRouting);
    }

    private static void generateDelay() {
        for (int ik = 0; ik < 5; ik++) {
            System.out.print(" ");
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void denyRides(List<Double> distances) {
        if (distances.size() > 2) {
            generateDelay();
            System.out.println("\n-----------------------");
            System.out.println("|\tRide Notifications\t|");
            System.out.println("--------------------");
            System.out.println("Driver : John Cancelled Ride " + distances.size());
            System.out.println("Reason : Driver too Far...");
            System.out.println("Your account will be refunded. ");
            System.out.println("------------------------------");
        }
    }

    @Override
    public void requestType() {

    }

}
