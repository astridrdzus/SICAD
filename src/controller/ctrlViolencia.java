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

    public ctrlViolencia(violenciaSurvey vsv) {
        this.vsv = vsv;
    }
    
    public boolean createVio( violenciaSurvey vsv){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO encuesta_violencia (folio, p11, p12, p13, p14, p15, p21, p22, p23, p24,p25, p3, p4, p5, " //14
                + "p61nina, p62nina, p63nina, p64nina, p65nina, p66nina, p67nina, p68nina, p69nina, p610nina, p611nina," //11
                + "p612nina, p613nina, p614nina, p61nino, p62nino, p63nino, p64nino, p65nino, p66nino, p67nino, p68nino," //11
                +"p69nino, p610nino, p611nino, p612nino, p613nino, p614nino,p6otro,observaciones) " //8
                + "VALUES(?,?,?,?,?,?,?,?,?,?,"
                       + "?,?,?,?,?,?,?,?,?,?,"
                       + "?,?,?,?,?,?,?,?,?,?,"
                       + "?,?,?,?,?,?,?,?,?,?,"
                       + "?,?,?,?)";
        
    
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, vsv.getFolio());
            ps.setString(2, vsv.getVp11());
            ps.setString(3, vsv.getVp12());
            ps.setString(4, vsv.getVp13());
            ps.setString(5, vsv.getVp14());
            ps.setString(6, vsv.getVp15());
            ps.setString(7, vsv.getVp21());
            ps.setString(8, vsv.getVp22());
            ps.setString(9, vsv.getVp23());
            ps.setString(10, vsv.getVp24());
            ps.setString(11, vsv.getVp25());
            ps.setString(12, vsv.getVp3());
            ps.setString(13, vsv.getVp4());
            ps.setString(14, vsv.getVp5());
            ps.setString(15, vsv.getVp61nina());
            ps.setString(16, vsv.getVp62nina());
            ps.setString(17, vsv.getVp63nina());
            ps.setString(18, vsv.getVp64nina());
            ps.setString(19, vsv.getVp65nina());
            ps.setString(20, vsv.getVp66nina());
            ps.setString(21, vsv.getVp67nina());
            ps.setString(22, vsv.getVp68nina());
            ps.setString(23, vsv.getVp69nina());
            ps.setString(24, vsv.getVp610nina());
            ps.setString(25, vsv.getVp611nina());
            ps.setString(26, vsv.getVp612nina());
            ps.setString(27, vsv.getVp613nina());
            ps.setString(28, vsv.getVp614nina());
            ps.setString(29, vsv.getVp61nino());
            ps.setString(30, vsv.getVp62nino());
            ps.setString(31, vsv.getVp63nino());
            ps.setString(32, vsv.getVp64nino());
            ps.setString(33, vsv.getVp65nino());
            ps.setString(34, vsv.getVp66nino());
            ps.setString(35, vsv.getVp67nino());
            ps.setString(36, vsv.getVp68nino());
            ps.setString(37, vsv.getVp69nino());
            ps.setString(38, vsv.getVp610nino());
            ps.setString(39, vsv.getVp611nino());
            ps.setString(40, vsv.getVp612nino());
            ps.setString(41, vsv.getVp613nino());
            ps.setString(42, vsv.getVp614nino());
            ps.setString(43, vsv.getVp6otro());
            ps.setString(44, vsv.getVobs());
            
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
