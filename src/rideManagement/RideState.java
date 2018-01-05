package rideManagement;

import java.util.Map;

/**
 * Created by sheebanshaikh on 8/9/16.
 */
public interface RideState {

    public void request_type(String request_type);

    public boolean receiveRequest(Map<String, String> sourceVsDestinationMap, int vehicleType);

    public boolean qualifyRequest(Map<String, String> sourceVsDestinationMap, int vehicleType);

    public boolean approveRequest(Map<String, String> sourceVsDestinationMap, int vehicleType);
}
