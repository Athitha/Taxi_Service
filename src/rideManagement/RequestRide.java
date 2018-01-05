package rideManagement;

import routingManagement.ProcessRouting;

import java.util.List;

/**
 * Created by sheebanshaikh on 8/17/16.
 */


public class RequestRide extends MaintainRequest {

    public Long requestId;

    public RequestRide(ProcessRouting processRouting) {
        super(processRouting);
    }

    @Override
    public void denyRides(List<Double> distances) {

    }

    @Override
    public void requestType() {

    }


}
