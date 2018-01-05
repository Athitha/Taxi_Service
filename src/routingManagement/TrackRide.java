package routingManagement;

import java.lang.reflect.Member;
import java.util.List;

/**
 * Created by sheebanshaikh on 8/9/16.
 */

public abstract class TrackRide {

    public Boolean locationChange;

    public abstract List<Member> getMembers();

    public abstract void notifyMember();
}
