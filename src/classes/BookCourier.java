package classes;

import services.DBConnection;
import services.Mailer;

import java.sql.*;

public class BookCourier implements interfaces.BookCourier {
    int userID;

    public BookCourier() {
    }

    public BookCourier(int userID) {
        this.userID = userID;
    }

    public Double calculateBookingCharge(Double parcelWeight) {
        Double bookingCharges;
        if (parcelWeight < 20)
            bookingCharges = 40.0;
        else if (parcelWeight > 20 && parcelWeight <= 50) {
            parcelWeight -= 20;
            bookingCharges = 40.0 + (0.75 * parcelWeight);
        } else if (parcelWeight > 50 && parcelWeight <= 80) {
            parcelWeight -= 20;
            bookingCharges = 40.0 + (1.15 * parcelWeight);
        } else {
            parcelWeight -= 20;
            bookingCharges = 40.0 + (1.50 * parcelWeight);
        }
        return bookingCharges;
    }

    @Override
    public void bookCourier(CourierDetails courierDetails, int userID) {
        try {
            String query = "insert into courier.bookingDetails values (default , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection connection = DBConnection.db_connection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userID);
            preparedStatement.setDouble(2, courierDetails.parcelWeight);
            preparedStatement.setString(3, courierDetails.toAddress);
            preparedStatement.setString(4, courierDetails.fromAddress);
            preparedStatement.setString(5, courierDetails.senderName);
            preparedStatement.setString(6, courierDetails.receiverName);
            preparedStatement.setString(7, courierDetails.bookingDate);
            preparedStatement.setDouble(8, calculateBookingCharge(courierDetails.parcelWeight));
            preparedStatement.setString(9, courierDetails.senderEmail);
            preparedStatement.setString(10, "Pending");
            preparedStatement.execute();
            System.out.println("Parcel has been booked!!!");
            Mailer mailer = new Mailer();
            mailer.sendMail(courierDetails.senderEmail);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void bookingHistory(int userID) {
        try {
            Connection connection = DBConnection.db_connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from courier.bookingDetails where user_id= '" + userID + "'");
            System.out.println("Looking for history...");
            System.out.println("\tParcel ID\t|\tUser ID\t|\tParcel Weight\t|\tTo Address\t|\tFrom Address\t" +
                    "|\tSender's Name\t|\tReceiver's Name\t|\t\tBooking Date\t\t|" +
                    "\tBooking Charges\t|\tSender's Email\t|\tStatus");
            System.out.println("\t----------\t|\t--------|\t---------\t\t|\t---------\t|\t--------------\t|" +
                    "\t--------------\t|\t--------------\t|\t--------------------\t\t|\t---------\t\t|\t---------\t");
            while (resultSet.next()) {
                System.out.println("\t" + resultSet.getInt(1) + "\t\t\t|\t" +
                        resultSet.getInt(2) + "\t\t|\t" +
                        resultSet.getDouble(3) + "\t\t\t|\t" +
                        resultSet.getString(4) + "\t\t\t|\t" +
                        resultSet.getString(5) + "\t\t\t\t|\t" +
                        resultSet.getString(6) + "\t\t\t|\t" +
                        resultSet.getString(7) + "\t\t\t|\t" +
                        resultSet.getString(8) + "\t\t|\t" +
                        resultSet.getDouble(9) + "\t\t|\t" +
                        resultSet.getString(10) + "\t\t|\t" +
                        resultSet.getString(11));
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
