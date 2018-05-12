/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazadanych;

/**
 *
 * @author pkopicki
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BazaDanych2 {

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
        rs = st.executeQuery("SELECT VERSION()");
        {
        System.out.println(rs);
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
 

  

   
    
  