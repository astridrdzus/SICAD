/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import com.mysql.cj.xdevapi.Statement;
import databaseConnection.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author astri
 */
public class ctrlBusqueda {
    
    public ResultSet getTable(String query){
        connect con = new connect();
        Connection cn = con.getConnection();
        PreparedStatement ps = null;
        Statement st;
        ResultSet data= null;
        
        try{
            //ps = cn.prepareStatement(query);
            st = cn.createStatement();
            data = st.executeQuery(query);

        }catch(Exception e){
            System.out.println(e.toString());
            
        }
        return data;
    }
}
