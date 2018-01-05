package rideManagement.Model;

import memberManagement.service.Customer;
import memberManagement.service.Driver;
import rideManagement.RideState;

import javax.persistence.*;

/**
 * Created by sheebanshaikh on 8/13/16.
 */

@Entity
public class RideDetails {

    @Id
    @GeneratedValue
    private Long rideDetailsId;

    @Column
    private String source;

    @Column
    private String destination;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Driver driver;

    @Column
    private RideStatus rideStatus;

    private RideState rideState;

    //State Pattern Implementation
    public RideDetails(RideState rideState) {
        this.rideState = rideState;
    }

    public RideDetails(String source, String destination, Customer customer, Driver driver, RideStatus rideStatus) {
        this.source = source;
        this.destination = destination;
        this.customer = customer;
        this.driver = driver;
        this.rideStatus = rideStatus;
    }

    public RideState getRideState() {
        return rideState;
    }

    public void setRideState(RideState rideState) {
        this.rideState = rideState;
    }

    public Long getRideDetailsId() {
        return rideDetailsId;
    }

    public String getSource() {
        return source;
    }

    public String getDestionation() {
        return destination;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }
}
