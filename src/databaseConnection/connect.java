/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseConnection;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author astri
 */
public class connect {
    public static final String URL = "jdbc:mysql://localhost/SICAD";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    
    
    public static Connection getConnection(){
        Connection con = null;
        try{
            //Class.forName("com.myslq.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("CONECCTION ESTABLISHED");
            //JOptionPane.showMessageDialog(null,"Conexion exitosa");
            
        } catch(Exception e){
            System.out.println(e);
            //JOptionPane.showMessageDialog(null, "Error "+e);
            
        }
        return con;
    }
}
