package com.company;

/**
 *
 * @author pkopicki
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
    Connection conn = null;

        try
        {
            String userName = "root";
            String password = "Biggk123";
            String sterownik;
        sterownik = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/dziennik?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&verifyServerCertificate=false";
            Class.forName (sterownik);
            conn = DriverManager.getConnection (url, userName, password);
          System.out.println ("Database connection established");


        Statement st = conn.createStatement();
        ResultSet rs;
        rs = st.executeQuery("SELECT * FROM users");
        while (rs.next())
        {

            String imie = rs.getString("Imie");
            String nazwisko = rs.getString("Nazwisko");
            String user_name = rs.getString("user_name");
            String pass = rs.getString("password");
            String plec = rs.getString("plec");
            String data_ur = rs.getString("data_ur");




        System.out.println(imie + "\t" + nazwisko + "\t" + user_name  + "\t" + pass + "\t" + plec + "\t" + data_ur);
        }

        }

        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println( e.getCause());
            System.err.println ("Cannot connect to database server");

        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    conn.close ();
                    System.out.println ("Database connection terminated");
                }
                catch (SQLException e) { /* ignore close errors */ }
            }
        }
    }
}






