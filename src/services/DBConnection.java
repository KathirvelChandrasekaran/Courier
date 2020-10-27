package services;

import interfaces.DBCredentials;

import java.sql.*;

public class DBConnection implements DBCredentials {

    private static Connection con;

    public static Connection db_connection() throws SQLException {
        Connection con = DriverManager.getConnection(conn_URI + db_name + time_zone, db_user, passwd);
        return con;
    }
}
