package rideManagement;

import routingManagement.ProcessRouting;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by sheebanshaikh on 8/17/16.
 */


public abstract class MaintainRequest {

    private ProcessRouting processRouting;

    public MaintainRequest(ProcessRouting processRouting) {
        this.processRouting = processRouting;
    }

    public List<Double> handleRequests(Map<String, String> sourceVsDest) {
        List<Double> distances = newArrayList();
        try {
            distances = processRouting.processRoutes(sourceVsDest);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return distances;
    }

    public abstract void denyRides(List<Double> distances);

    public abstract void requestType();

}
