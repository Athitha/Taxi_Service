package parkingManangement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sheebanshaikh on 8/9/16.
 */

public class DeAllocateParking implements ParkingAllocation {


    @PersistenceContext
    private EntityManager entityManager;

    //returning allocated slot for vehicles
    public Integer getSlotNumber() {

        return 2;
    }

    //returning vehicle name
    public String getVehicle() {
        return "Mercedes - A";
    }

    public void allocationRequest() {
        System.out.print("\nRemoving the parking slot. ");
        for (int i = 0; i < 5; i++) {
            System.out.print(". ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n------------------------------------\nVehicle Id  : " + getVehicle() +
                "\nSlot        : " + getSlotNumber() +
                "\n------------------------------------");
    }
}
