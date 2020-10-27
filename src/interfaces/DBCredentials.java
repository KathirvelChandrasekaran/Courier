package interfaces;

public interface DBCredentials {
    String db_user = "root";
    String passwd = "";
    String conn_URI = "jdbc:mysql://localhost:3306/";
    String db_name = "courier";
    String time_zone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&serverTimezone=UTC";
}
