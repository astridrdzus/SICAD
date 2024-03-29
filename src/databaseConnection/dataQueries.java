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

/**
 *
 * @author astri
 */
public class dataQueries extends connect{
    
    public boolean create( surveyData sv){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO datos_escuela (folio, encuesta, municipio, nivel, fecha, sistema, turno,modalidad,"
                + "antiguedad, sexo, edad, anios_servicio, nombre ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
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
            System.out.println(ps);
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
}
