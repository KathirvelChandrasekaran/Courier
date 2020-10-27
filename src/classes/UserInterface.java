package classes;

import java.util.*;

public class UserInterface {

    public void PickUserChoices(int userID) {
        Scanner in = new Scanner(System.in);
        int con = 0;
        do {
            System.out.println("1 -> Book Courier\n2 -> View Booking History");
            int ch = in.nextInt();
            BookingDetails bd = new BookingDetails();
            if (ch == 1) {
                bd.setUserId(userID);
                bd.bookingDetails();
            } else if (ch == 2) {
                bd.bookingHist(userID);
            }
            System.out.println("Non zero value to continue!!!");
            con = in.nextInt();
        } while (con != 0);
        in.close();
    }
}
