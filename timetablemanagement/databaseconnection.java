import java.util.*;
import java.sql.*;

public class databaseconnection
{   
    public static Connection connect()
    {   String url="jdbc:mysql://localhost:3306/timetable";
        String user="root";
        String pass="Jones@123";
        try
        {
            Connection con=DriverManager.getConnection(url,user,pass);
            System.out.println("Database Connected Succesfully");
            return con;
        }
        catch(SQLException e)
        {
            System.err.println("Database Connection Failed");
        }return null;
    }
}
