package parkingManangement;

import notificationManagement.Model.NotificationMessages;

/**
 * Created by sheebanshaikh on 8/9/16.
 */


public class ManageParking implements ParkingAllocation {


    @Override
    public void allocationRequest() {
        System.out.println(NotificationMessages.FIND_NEAREST_PARKING_SLOT);
        System.out.println(NotificationMessages.PARKING_BOOKED);
    }


}