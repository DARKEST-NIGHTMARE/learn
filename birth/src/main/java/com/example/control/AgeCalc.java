package com.example.control;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AgeCalc extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter p = response.getWriter();

        try {
            String dob = request.getParameter("dob");
            LocalDate dob1 = LocalDate.parse(dob);
            LocalDate currentDate = LocalDate.now();


            Period agePeriod = Period.between(dob1, currentDate);
            int years = agePeriod.getYears();
            int months = agePeriod.getMonths();
            int days = agePeriod.getDays();
            p.println("<html><body>");
            p.println("<h2>Age</h2>");
            p.println("<p>Date of Birth: " + dob + "</p>");
            p.println("<p>Your age is: " + years + " years, " + months + " months, and " + days + " days.</p>");
            p.println("</body></html>");

        } catch (Exception e) {
            p.println("<html><body>");
            p.println("<p>Invalid date format or input. Please use YYYY-MM-DD.</p>");
            p.println("<p>Error message: " + e.getMessage() + "</p>");
            p.println("</body></html>");
        } finally {
            p.close();
        }
    }
}