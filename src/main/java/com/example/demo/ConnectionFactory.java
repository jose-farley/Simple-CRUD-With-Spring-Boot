
package com.example.demo;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {
    ConnectionFactory con = null;
    
    public ConnectionFactory getConnection(){
        try{
            String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=123";
            con =  (ConnectionFactory) DriverManager.getConnection(url);
          
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return con;
    }
}
