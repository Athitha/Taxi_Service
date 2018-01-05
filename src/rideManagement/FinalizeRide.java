package rideManagement;

import java.util.Map;

/**
 * Created by AAnantharamu on 8/14/16.
 */
public class FinalizeRide implements RideState {
    double dis =9;
    //Payment pay=new CreditPayment(new Promotions(),dis);

    @Override
    public void request_type(String request_type) {

    }

    @Override
    public boolean receiveRequest(Map<String, String> sourceVsDestinationMap, int vehicleType) {
        return false;
    }

    @Override
    public boolean qualifyRequest(Map<String, String> sourceVsDestinationMap, int vehicleType) {
        return false;
    }

    @Override
    public boolean approveRequest(Map<String, String> sourceVsDestinationMap, int vehicleType) {
        if (!sourceVsDestinationMap.equals(null)) {
            int i = 19;
            System.out.print("Ride finalized for " + sourceVsDestinationMap.keySet().size() + " ride. ");
            for (int ik = 0; ik < 5; ik++) {
                System.out.print(". ");
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (sourceVsDestinationMap.keySet().size() >= 1) {
                System.out.println("\n\n----------- Ride finalized  -----------");
                for (String source : sourceVsDestinationMap.keySet()) {
                    System.out.println("Source      : " + source + "\nDestination : " + sourceVsDestinationMap.get(source)
                            + "\nDate        : " + i++ + "-Aug-2016");
                    System.out.println("-------------------------------------------");
                    System.out.println("Driver Assigned : John");
                    System.out.println("-------------------------------------------");
                }
            }
        }
        return true;
    }


}
