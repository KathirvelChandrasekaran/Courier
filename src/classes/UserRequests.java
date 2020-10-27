package classes;

import interfaces.Requests;
import services.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class UserRequests implements Requests {
    @Override
    public void createRequest() {
        System.out.println("Request for password change");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the user ID");
        int userID = in.nextInt();
        try {
            Connection connection = DBConnection.db_connection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into courier.requests values (default , ?)");
            preparedStatement.setInt(1, userID);
            preparedStatement.execute();
            System.out.println("Request for password change has been made");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        in.close();
    }
}
