package org.example;
import java.sql.*;

public class DBConnector {

    private static final String DATABASE_ADRESS = "jdbc:postgresql://localhost:5432/jdbc_demo";
    private static final String USER = "postgres";
    private static final String PASS = "wsb";
    private Connection connection;

    public boolean connect()    {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DATABASE_ADRESS, USER, PASS);
            System.out.println("Udało się połączyć z bazą");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void execute(String sql) {

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Integer countRows(String tableName)  {
        try {
            String sql = "select count(*) from " + tableName;
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            results.next();
            return results.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void executeAndPrintResult(String sql)   {
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            while (results.next())  {
                System.out.println(results.getInt(1));
            }
        } catch (SQLException e)  {
            throw new RuntimeException(e);
        }
    }

}
