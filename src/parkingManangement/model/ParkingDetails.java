package parkingManangement.model;

/**
 * Created by sheebanshaikh on 8/15/16.
 */


import memberManagement.models.Vehicle;

import javax.persistence.*;

@Entity
public class ParkingDetails {

    @Id
    @GeneratedValue
    private Long parkingDetailsId;

    @OneToOne
    private Vehicle vehicle;

    @Column
    private String startTime;

    @Column
    private String endTime;

    @Column
    private int slot;

    public ParkingDetails(Long parkingDetailsId, Vehicle vehicle, String startTime, String endTime, int slot) {
        this.parkingDetailsId = parkingDetailsId;
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.slot = slot;
    }

    public int getSlot() {
        return slot;
    }

    public Long getParkingDetailsId() {
        return parkingDetailsId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}