package routingManagement;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static java.lang.Math.*;

/**
 * Created by sheebanshaikh on 8/9/16.
 */

@Component
public class TaxiPool implements ProcessRouting {

    //Haversine Formula for Calculating Path
    @Override
    public List<Double> processRoutes(Map<String, String> sourceVsDestination) {
        int i = 0;
        Map<String, String> sourceLongLatMap = Maps.newHashMap();
        Map<String, String> destLongLatMap = Maps.newHashMap();
        List<String> destinationLatList = Lists.newArrayList(destLongLatMap.keySet());
        List<Double> distances = Lists.newArrayList(10.0, 14.7, 16.75);
        for (String sourceLatitude : sourceLongLatMap.keySet()) {
            String sourceLongitude = sourceLongLatMap.get(sourceLatitude);

            Long destLatitude = Long.valueOf(destinationLatList.get(i++));
            Long destLongtitude = Long.valueOf(destinationLatList.get(i++));
            Double earthRadius = 3958.75;
            Double latRadians = toRadians(destLatitude - Long.valueOf(sourceLatitude));
            Double lngRadians = toRadians(destLongtitude - Long.valueOf(sourceLongitude));
            Double sindLat = sin(latRadians / 2);
            Double sindLng = sin(lngRadians / 2);
            Double a = pow(sindLat, 2) + pow(sindLng, 2) * cos(toRadians(Long.valueOf(sourceLatitude))) * cos(toRadians(destLatitude));
            double c = 2 * atan2(sqrt(a), sqrt(1 - a));
            double dist = earthRadius * c;
            distances.add(dist);
        }
        return distances;
    }
}
