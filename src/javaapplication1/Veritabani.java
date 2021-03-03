
package javaapplication1;

import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;


 public class Veritabani {
    
    public static Connection connectDb(){
        
        Connection conn= null;
        try {
            conn= DriverManager.getConnection("jdbc:derby://localhost:1527/proje","muco","123");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getErrorCode());
        }
        
        return null;
    }
    
}
