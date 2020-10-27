package classes;

import interfaces.AdminPanel;
import services.DBConnection;

import java.sql.*;

public class AdminRights implements AdminPanel {
    @Override
    public void viewUsers() {
        try {
            Connection connection = DBConnection.db_connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from courier.auth");
            System.out.println("\tUserID\t|\tUser Name\t");
            System.out.println("\t------\t|\t---------\t");
            while (resultSet.next()) {
                System.out.println("\t" + resultSet.getInt(1) + "\t\t|\t" +
                        resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userID) {
        try {
            Connection connection = DBConnection.db_connection();
            Statement statement = connection.createStatement();
            int isDeleteUser = statement.executeUpdate("delete from courier.auth where user_id = '"
                    + userID + "'");
            int isDeleteHistory = statement.executeUpdate("delete from courier.bookingdetails where user_id = '"
                    + userID + "'");
            if (((isDeleteUser == 1) && (isDeleteHistory == 1)))
                System.out.println("User has been deleted");
            else
                System.out.println("Problem in deleting the user details");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCredentials(int userID) {
        try {
            Connection connection = DBConnection.db_connection();
            Statement statement = connection.createStatement();
            int isUpdateCredentials = statement.executeUpdate("update courier.auth set password = 'defaultpass' where user_id = '"
                    + userID + "'");
            if (isUpdateCredentials == 1)
                System.out.println("Password has been changed");
            else
                System.out.println("Problem in deleting the user details");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewCouriers() {
        try {
            Connection connection = DBConnection.db_connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from courier.bookingdetails");
            System.out.println("\tParcel ID\t|\tUser ID\t|\tParcel Weight\t|\tTo Address\t|\tFrom Address\t" +
                    "|\tSender's Name\t|\tReceiver's Name\t|\t\tBooking Date\t\t|\tBooking Charges\t" +
                    "|\tSender's Email\t|\tStatus");
            System.out.println("\t----------\t|\t--------|\t---------\t\t|\t---------\t|\t--------------\t|" +
                    "\t--------------\t|\t--------------\t|\t--------------------\t\t|\t---------\t");
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCourierDetails(int parcelID) {
        try {
            Connection connection = DBConnection.db_connection();
            Statement statement = connection.createStatement();
            int isUpdateCredentials = statement.executeUpdate("update courier.bookingdetails set status = 'Delivered' where parcel_id = '"
                    + parcelID + "'");
            if (isUpdateCredentials == 1)
                System.out.println("Status has been changed");
            else
                System.out.println("Problem in deleting the user details");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewRequests() {
        try {
            Connection connection = DBConnection.db_connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from courier.requests");
            System.out.println("\tRequest ID\t|\tUser ID\t");
            System.out.println("\t------\t|\t---------\t");
            while (resultSet.next()) {
                System.out.println("\t" + resultSet.getInt(1) + "\t\t|\t" +
                        resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
