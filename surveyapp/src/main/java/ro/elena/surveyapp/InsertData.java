package ro.elena.surveyapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;






// Import Database Connection Class file





    // Servlet Name
    @WebServlet("/InsertData")
    class InsertData extends HttpServlet {
        private static final long serialVersionUID = 1L;

        protected void doPost(HttpServletRequest request,
                              HttpServletResponse response)
                throws ServletException, IOException
        {
            try {

                // Initialize the database
                Connection con = mysql.initializeDatabase();

                // Create a SQL query to insert data into demo table
                // demo table consists of two columns, so two '?' is used
                PreparedStatement st = con
                        .prepareStatement("insert into survey2.raspunsuri values(null, NOW(), ?, ?, ? ,?,?,?");
                // For the first parameter,
                // get the data using request object
                // sets the data to st pointer
                st.setString(3, request.getParameter("INTREBARE_A"));

                // Same for second parameter

                st.setString(4, request.getParameter("INTREBARE_B"));
                st.setString(5, request.getParameter("INTREBARE_C"));
                st.setString(6, request.getParameter("INTREBARE_D"));
                st.setString(7, request.getParameter("INTREBARE_E"));
                st.setString(8, request.getParameter("RASPUNS_FREE_TEXT"));

                // Execute the insert command using executeUpdate()
                // to make changes in database
                st.executeUpdate();

                // Close all the connections
                st.close();
                con.close();

                // Get a writer pointer
                // to display the successful result
                PrintWriter out = response.getWriter();
                out.println("<html><body><b>Successfully Inserted"
                        + "</b></body></html>");
            }
            catch (Exception e) {
                e.printStackTrace ();
            }
        }
    }
