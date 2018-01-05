package notificationManagement;

import notificationManagement.Model.NotificationMessages;

/**
 * Created by sheebanshaikh on 8/17/16.
 */
public class NotificationImplementor {

    NotificationMessages notificationMessages;

    private CustomerNotification customerNotification = new CustomerNotification();
    private DriverNotification driverNotification = new DriverNotification();


    public NotificationImplementor(NotificationMessages notificationMessages) {
        this.notificationMessages = notificationMessages;
    }

    public NotificationMessages implementNotifications() {
        if (notificationMessages.equals(NotificationMessages.CUSTOMER_NOTIFICATION))
            return NotificationMessages.CUSTOMER_NOTIFICATION;
        if (notificationMessages.equals(NotificationMessages.DRIVER_NOTIFICATION))
            return NotificationMessages.DRIVER_NOTIFICATION;
        return notificationMessages.START;
    }
}
