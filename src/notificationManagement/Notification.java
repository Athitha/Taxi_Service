package notificationManagement;

import notificationManagement.Model.NotificationMessages;

/**
 * Created by sheebanshaikh on 8/9/16.
 */

public abstract class Notification {

    public Long notificationId;

    public abstract NotificationMessages getNotifications(NotificationMessages NotificationMessage);

    public abstract void notifyObserver();


}
