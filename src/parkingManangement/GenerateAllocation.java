package parkingManangement;

import memberManagement.models.Vehicle;
import parkingManangement.model.ParkingDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sheebanshaikh on 8/15/16.
 */
public class GenerateAllocation implements ParkingAllocation {

    //charge per day per vehicle
    public static final Integer CHARGE = 10;
    int slotsNumber = 2;
    Vehicle vehicleId;
    Double starttime = 9.0;
    Double endtime = 16.5;
    @PersistenceContext
    private EntityManager entityManager;

    public Double gethour() {
        // It is produce checking time to calculate the costs
        double diffInHours = 0;

        try {

            String format = "dd/MM/yyyy hh:mm a";

            Double diff = endtime - starttime;
            diffInHours = diff / (1000 * 60 * 60);

            System.out.println("Hours " + (int) diffInHours);
            System.out.println("Minutes " + (diffInHours - (int) diffInHours) * 60);

        } catch (Exception e) {
            e.printStackTrace();
        }
        double rounded = (double) Math.round(diffInHours);
        return rounded;
    }

    //returning total cost for per day per vehicle
    public Double totalCostPerParking() {
        double rounded = (double) Math.round(CHARGE * (2));
        return rounded;
    }

    //returning slot number parked per vehicle
    public Integer getSlotNumber() {

        return 2;
    }


    public String getEndtime() {
        ParkingDetails end = entityManager.find(ParkingDetails.class, endtime);
        return end.getEndTime();
    }

    public void allocationRequest() {
        for (int i = 0; i < 5; i++) {
            System.out.print(". ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n---------------- PARKING RECEIPT ----------------");
        System.out.println("\nVehicle Name    : Mercedes - A  " +
                "\nSlot number     : " + getSlotNumber());
        System.out.println("\nDate of parking : 19-Aug-2016 " +
                "\nStart Time      : " + starttime +
                "\nEnd Time        : " + endtime);
        System.out.println("---------------------------------------------------");
        System.out.println("       Total      : $" + totalCostPerParking());
        System.out.println("---------------------------------------------------");
    }
}
