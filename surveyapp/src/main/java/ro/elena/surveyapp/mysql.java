package ro.elena.surveyapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



    // This class can be used to initialize the database connection
    public class mysql {
        protected static Connection initializeDatabase()
                throws SQLException, ClassNotFoundException
        {
            // Initialize all the information regarding
            // Database Connection
            String dbDriver = "com.mysql.jdbc.Driver";
            String dbURL = "jdbc:mysql://104.248.84.92:3306/";
            // Database name to access
            String dbName = "survey2";
            String dbUsername = "java";
            String dbPassword = "Javaestetare123!";

            Class.forName(dbDriver);
            Connection con = DriverManager.getConnection(dbURL + dbName,
                    dbUsername,
                    dbPassword);
            return con;
        }
    }
