package Task_29;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@WebServlet("/hello")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate localDate;
        DayOfWeek dayOfWeek;
        String output;

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        try {
            date = req.getParameter("date");
            printWriter.write("<h2>Input date: " + date + "</h2>");
            localDate = LocalDate.parse(date, formatter);
            dayOfWeek = localDate.getDayOfWeek();
            output = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.US);
            printWriter.write("Day of the week: " + output);
        }
        finally {
            printWriter.close();
        }
    }
}