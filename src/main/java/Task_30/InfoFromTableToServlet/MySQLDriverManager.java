package Task_30.InfoFromTableToServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDriverManager {

    private static MySQLDriverManager instance;
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/students";
    private static final String USER_NAME = "User";
    private static final String PASSWORD = "root";

    private MySQLDriverManager() {
        init();
    }

    private void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static MySQLDriverManager getInstance() {
        if (instance == null) {
            instance = new MySQLDriverManager();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
    }
}
