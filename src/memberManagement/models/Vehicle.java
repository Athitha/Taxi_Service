package memberManagement.models;

import memberManagement.service.Driver;

import javax.persistence.*;

/**
 * Created by sheebanshaikh on 8/13/16.
 */

@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private Long vehicleId;

    @Column
    private String vehicleName;

    @Column
    private VehicleType vehicleType;

    @OneToOne
    private Driver driver;

    public Vehicle(String vehicleName, VehicleType vehicleType, Driver driver) {
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.driver = driver;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Driver getDriver() {
        return driver;
    }
}
