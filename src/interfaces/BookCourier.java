package interfaces;

import classes.CourierDetails;

public interface BookCourier {
    void bookCourier(CourierDetails courierDetails, int userID);
    void bookingHistory(int userID);
}
