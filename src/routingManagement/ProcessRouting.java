package routingManagement;


import java.util.List;
import java.util.Map;

/**
 * Created by sheebanshaikh on 8/9/16.
 */
public interface ProcessRouting {

    public List<Double> processRoutes(Map<String, String> sourceVsDestination) throws Exception;
}
