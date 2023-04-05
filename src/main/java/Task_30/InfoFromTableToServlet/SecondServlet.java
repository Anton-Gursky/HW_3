package Task_30.InfoFromTableToServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/table")
public class SecondServlet extends HttpServlet {

    public static MySQLDriverManager driverManager = MySQLDriverManager.getInstance();
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        try {
            connection = driverManager.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * From " + "groupStudents");

            //Выведение полученных данных на консоль
            while (resultSet.next()) {
                writer.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " +
                        resultSet.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}