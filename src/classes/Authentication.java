package classes;

import services.*;

import java.sql.*;
import java.util.*;

public class Authentication {
    private int userId;

    public boolean isUserFound(String userName, String password, String flag) {
        boolean state = false;
        try {
            Connection connection = DBConnection.db_connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from auth where user_name = '" + userName.toString() + "'");
            int count = 0;
            while (resultSet.next()) {
                count++;
                String name = resultSet.getString(2);
                String passwd = resultSet.getString(3);
                if (flag.equals("login")) {
                    state = (userName.equals(name)) && (password.equals(passwd));
                    userId = resultSet.getInt(1);
                } else if (flag.equals("admin")) {
                    state = (userName.equals(flag)) && (password.equals(passwd));
                    userId = resultSet.getInt(1);
                } else
                    state = count >= 1;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return state;
    }

    public void register() {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to user registration");
        String userName, password;
        System.out.println("Enter the username\n");
        userName = in.nextLine();
        System.out.println("Enter the password\n");
        password = in.nextLine();
        if (isUserFound(userName, null, null)) {
            System.out.println("User already found or username is already taken. " +
                    "Please login or register with another name");
            login();
        } else {
            try {
                String query = "insert into courier.auth (user_name, password) values (?, ?)";
                Connection connection = DBConnection.db_connection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, password);
                preparedStatement.execute();
                System.out.println("Registration is success");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    public void login() {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to user Login");
        String userName, password;
        System.out.println("Enter the username\n");
        userName = in.nextLine();
        System.out.println("Enter the password\n");
        password = in.nextLine();

        if (isUserFound(userName, password, "login")) {
            System.out.println("Login Success");
            UserInterface UI = new UserInterface();
            UI.PickUserChoices(userId);
        } else
            System.out.println("Invalid credentials or account not found");
        in.close();
    }

    public void adminLogin() {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to user Login");
        String userName, password;
        System.out.println("Enter the username\n");
        userName = in.nextLine();
        System.out.println("Enter the password\n");
        password = in.nextLine();
        if (isUserFound(userName, password, "admin")) {
            System.out.println("Login Success for admin access");
            AdminUserInterface AUI = new AdminUserInterface();
            AUI.PickAdminChoices(userId);
        }
        in.close();
    }
}