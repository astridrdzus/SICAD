/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseConnection;
import surveyClasses.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;
import java.sql.ResultSet;
import surveyClasses.desarrolloSurvey;

/**
 *
 * @author astri
 */
public class dataQueries extends connect{
    
    public int getLastID(){
        int lastID=0;
        String lastRowID= null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql= "SELECT * FROM datos_escuela ORDER BY id DESC";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                lastRowID = rs.getString("id");
            }
            System.out.println(lastRowID);
            lastID = Integer.parseInt(lastRowID);
            
            
            //lastID = Integer.parseInt(rs.getString("id"));
            //System.out.println("Result set: "+ Integer.toString(lastID));
            
        }catch(SQLException e){
            System.err.println(e);
            
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        
        return lastID; 
    }
    
    
    public boolean create( surveyData sv){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO datos_escuela (folio, encuesta, municipio, nivel, fecha, sistema, turno,modalidad,"
                + "antiguedad, sexo, edad, anios_servicio, nombre, archivo ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        System.out.println("before try catch");
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, sv.getFolio());
            ps.setString(2, sv.getEncuesta());
            ps.setString(3, sv.getMunicipio());
            ps.setString(4, sv.getNivel());
            ps.setString(5, sv.getFecha());
            ps.setString(6, sv.getSistema());
            ps.setString(7, sv.getTurno());
            ps.setString(8, sv.getModalidad());
            ps.setString(9, sv.getAntiguedad());
            ps.setString(10, sv.getSexo());
            ps.setString(11, sv.getEdad());
            ps.setString(12, sv.getAnios_servicio());
            ps.setString(13, sv.getNombre());
            System.out.println("before");
            System.out.println("archivo ps : "+sv.getArchivo());
            ps.setBinaryStream(14, sv.getArchivo());
            System.out.println(ps);
            ps.execute();
            
            /*Closing the conexion to not overload the memory*/
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
    
    public boolean createDes( desarrolloSurvey dsv){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO escuesta_desarrollo (folio, p1, p21, p22, p23, p31, p32, p33, p34, p41, p42, p43 "
                + "p44, p45, p51, p53, p54, p55, observaciones ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        System.out.println("before try catch");
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
    
   
    
    public boolean read( surveyData sv){
        
        PreparedStatement ps = null;
        ResultSet rs = null; //Result of the query
        Connection con = getConnection();
        
        String sql = "SELECT * FROM datos_escuela  WHERE folio=? ";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, sv.getFolio());
            
            rs= ps.executeQuery();
            
            if(rs.next()){
                sv.setFolio(rs.getString("folio"));
                sv.setEncuesta(rs.getString("encuesta"));
                sv.setMunicipio(rs.getString("municipio"));
                sv.setNivel(rs.getString("nivel"));
                sv.setSistema(rs.getString("sistema"));
                sv.setTurno(rs.getString("turno"));
                sv.setModalidad(rs.getString("modalidad"));
                sv.setAntiguedad(rs.getString("antiguedad"));
                sv.setSexo(rs.getString("sexo"));
                sv.setEdad(rs.getString("edad"));
                sv.setAnios_servicio(rs.getString("anios_servicio"));
                sv.setNombre(rs.getString("nombre"));
                sv.setFecha(rs.getString("fecha"));
                return true;

            }return false;
            
        }catch(SQLException e){
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
    
    public boolean update( surveyData sv){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE datos_escuela SET encuesta=?, municipio=?, nivel=?, fecha=?, sistema=?, turno=?,modalidad=?"
                + "antiguedad=?, sexo=?, edad=?, anios_servicio=?, nombre=? WHERE folio=? ";
        
        try{
            ps = con.prepareStatement(sql);
            
            ps.setString(1, sv.getEncuesta());
            ps.setString(2, sv.getMunicipio());
            ps.setString(3, sv.getNivel());
            ps.setString(4, sv.getFecha());
            ps.setString(5, sv.getSistema());
            ps.setString(6, sv.getTurno());
            ps.setString(7, sv.getModalidad());
            ps.setString(8, sv.getAntiguedad());
            ps.setString(9, sv.getSexo());
            ps.setString(10, sv.getEdad());
            ps.setString(11, sv.getAnios_servicio());
            ps.setString(12, sv.getNombre());
            ps.setString(13, sv.getFolio());
            ps.execute();
            return true;
            
        }catch(SQLException e){
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
    
    public boolean delete( surveyData sv){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM datos_escuela  WHERE folio=? ";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, sv.getFolio());
            ps.execute();
            return true;
            
        }catch(SQLException e){
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
    
    public String getLastFolio(){
        String lastfolio= null;
        String lastRow= null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql= "SELECT * FROM datos_escuela ORDER BY id DESC";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                lastRow = rs.getString("folio");
            }
            System.out.println(lastRow);
            
        }catch(SQLException e){
            System.err.println(e);
            
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        
        return lastfolio; 
    }
    
    
    
     
}
