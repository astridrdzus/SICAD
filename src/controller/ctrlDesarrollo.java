/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import app.dataView;
import app.desarrolloView_0;
import static databaseConnection.connect.getConnection;
import databaseConnection.dataQueries;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import surveyClasses.dataSurvey;
import java.sql.SQLException;
import surveyClasses.desarrolloSurvey;

/**
 *
 * @author astri
 */
public class ctrlDesarrollo implements ActionListener{
    
    private desarrolloSurvey  dsv;
    private dataQueries dq;
    
    public ctrlDesarrollo(desarrolloSurvey  dsv){
        this.dsv = dsv;  
  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }
    public boolean createDes( desarrolloSurvey dsv){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO encuesta_desarrollo (folio, p1, p21, p22, p23, p31, p32, p33, p34, p41, p42, p43, "
                + "p44, p45, p51, p52, p53, p54, p55, observaciones ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
    
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, dsv.getFolio());
            ps.setString(2, dsv.getDp1());
            ps.setString(3, dsv.getDp21());
            ps.setString(4, dsv.getDp22());
            ps.setString(5, dsv.getDp23());
            ps.setString(6, dsv.getDp31());
            ps.setString(7, dsv.getDp32());
            ps.setString(8, dsv.getDp33());
            ps.setString(9, dsv.getDp34());
            ps.setString(10, dsv.getDp41());
            ps.setString(11, dsv.getDp42());
            ps.setString(12, dsv.getDp43());
            ps.setString(13, dsv.getDp44());
            ps.setString(14, dsv.getDp45());
            ps.setString(15, dsv.getDp51());
            ps.setString(16, dsv.getDp52());
            ps.setString(17, dsv.getDp53());
            ps.setString(18, dsv.getDp54());
            ps.setString(19, dsv.getDp55());
            ps.setString(20, dsv.getDpObs());
            
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
        boolean flag = createDes(this.dsv);
            //dq.getLastID();
            System.out.println(flag);
            
            if(flag){
                JOptionPane.showMessageDialog(null, "Datos guardados");
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
    }



    
    
    
}
