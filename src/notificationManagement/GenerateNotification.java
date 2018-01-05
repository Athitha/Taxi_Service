package notificationManagement;

import notificationManagement.Model.NotificationMessages;
import org.springframework.stereotype.Repository;

/**
 * Created by sheebanshaikh on 8/9/16.
 */


@Repository
public class GenerateNotification extends Notification {

    @Override
    public NotificationMessages getNotifications(NotificationMessages notificationMessages) {
        return notificationMessages;

    }

    @Override
    public void notifyObserver() {

    }
}
