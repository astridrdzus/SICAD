/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static databaseConnection.connect.getConnection;
import databaseConnection.dataQueries;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import surveyClasses.dataSurvey;
import java.sql.SQLException;
import surveyClasses.violenciaSurvey;

/**
 *
 * @author astri
 */
public class ctrlViolencia {
    
    private violenciaSurvey vsv = new violenciaSurvey();
    
    public boolean createVio( violenciaSurvey vsv){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO encuesta_violencia (folio, p11, p12, p13, p14, p15, p21, p22, p23, p24,p25, p3, p4, p5, "
                + "p61nina, p62nina, p63nina, p64nina, p65nina, p66nina, p67nina, p68nina, p69nina, p610nina, p611nina,"
                + "p612nina, p613nina, p614nina, p61nino, p62nino, p63nino, p64nino, p65nino, p66nino, p67nino, p68nino,"
                +"p69nino, p610nino, p611nino, p612nino, p613nino, p614nino,p6otro,observaciones) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
    
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, vsv.getFolio());
            ps.setString(2, vsv.getDp1());
            ps.setString(3, vsv.getDp21());
            ps.setString(4, vsv.getDp22());
            ps.setString(5, vsv.getDp23());
            ps.setString(6, vsv.getDp31());
            ps.setString(7, vsv.getDp32());
            ps.setString(8, vsv.getDp33());
            ps.setString(9, vsv.getDp34());
            ps.setString(10, vsv.getDp41());
            ps.setString(11, vsv.getDp42());
            ps.setString(12, vsv.getDp43());
            ps.setString(13, vsv.getDp44());
            ps.setString(14, vsv.getDp45());
            ps.setString(15, vsv.getDp51());
            ps.setString(16, vsv.getDp52());
            ps.setString(17, vsv.getDp53());
            ps.setString(18, vsv.getDp54());
            ps.setString(19, vsv.getDp55());
            ps.setString(20, vsv.getDpObs());
            
            System.out.println(ps);
            ps.execute();
            
            //Closing the conexion to not overload the memory
            con.close();
            return true;
            
        }catch(SQLException e){
            System.out.println("no se insertaron los datos");
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }   
    public void insert_Data(){
        boolean flag = createVio(this.vsv);
            //dq.getLastID();
            System.out.println(flag);
            
            if(flag){
                JOptionPane.showMessageDialog(null, "Datos guardados");
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
    }
}
