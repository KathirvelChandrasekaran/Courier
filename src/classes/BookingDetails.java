package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BookingDetails extends CourierDetails {

    int userId;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    void bookingDetails() {
        String toAddress, fromAddress, senderName, receiverName, bookingDate, senderEmail;
        double parcelWeight;
        LocalDateTime dateTime = LocalDateTime.now();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the parcel information\n");
        System.out.println("Enter the to address");
        toAddress = in.nextLine();
        System.out.println("Enter the from address");
        fromAddress = in.nextLine();
        System.out.println("Enter the sender's name");
        senderName = in.nextLine();
        System.out.println("Enter the receiver's name");
        receiverName = in.nextLine();
        System.out.println("Enter the weight of the parcel");
        parcelWeight = in.nextDouble();
        System.out.println("Enter the sender's email");
        senderEmail = in.next();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        bookingDate = dateTime.format(dateTimeFormatter);

        CourierDetails courierDetails = new CourierDetails(toAddress, fromAddress, senderName,
                receiverName, parcelWeight, bookingDate, senderEmail);
        courierDetails.printCourierDetails();
        BookCourier bc = new BookCourier();
        bc.bookCourier(courierDetails, userId);
    }

    void bookingHist(int userID) {
        BookCourier bc = new BookCourier(userId);
        bc.bookingHistory(userID);
    }
}
