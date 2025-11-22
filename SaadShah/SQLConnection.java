package SaadShah;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection
{
    Connection connection;
    Statement statement;

    public SQLConnection()
    {
        try
        {
<<<<<<< HEAD
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login" , "root" , "mshafaysiddiqui");
=======
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital" , "root" , "Saadandfahad786");
>>>>>>> 2f984f39ddcf6aadc661b4803ce4a0f87e010a9f
            statement = connection.createStatement();

        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }


}
