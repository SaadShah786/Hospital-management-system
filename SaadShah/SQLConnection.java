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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login" , "root" , "mshafaysiddiqui");
            statement = connection.createStatement();

        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }


}
