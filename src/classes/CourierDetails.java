package classes;


public class CourierDetails {
    String toAddress, fromAddress, senderName, receiverName, bookingDate, senderEmail;
    double parcelWeight;

    public CourierDetails() {
    }

    public CourierDetails(String toAddress, String fromAddress, String senderName,
                          String receiverName, double parcelWeight, String bookingDate, String senderEmail) {
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.parcelWeight = parcelWeight;
        this.bookingDate = bookingDate;
        this.senderEmail = senderEmail;
    }

    void printCourierDetails() {
        System.out.println("\nTo Address " + toAddress + "\nFrom Address " + fromAddress +
                "\nSender's name " + senderName + "\nReceiver's name " + receiverName + "\nParcel Weight " +
                parcelWeight + "\nBooking Date " + bookingDate + "\nSender Email " + senderEmail);
    }

}
