/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import app.dataView;
import app.desarrolloView_0;
import databaseConnection.dataQueries;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import surveyClasses.surveyData;
import java.sql.SQLException;
import surveyClasses.desarrolloSurvey;

/**
 *
 * @author astri
 */
public class ctrlDesarrollo implements ActionListener{
    
    private desarrolloSurvey  dsv;
    private dataQueries dq;
    private desarrolloView_0 dataFrm;
    
    public ctrlDesarrollo(desarrolloSurvey  dsv, dataQueries dq, desarrolloView_0 dataFrm){
        this.dsv = dsv;
        this.dq = dq;
        this.dataFrm = dataFrm;
        this.dataFrm.btn_save_D.addActionListener(this);
  
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        //System.out.println("Button pushed");
        if(e.getSource() == dataFrm.btn_SaveData){
            
            /*sv.setFolio(Integer.toString(folioCont));
            System.out.println(sv.getFolio());*/
            
            String preFolio = sv.getFolio();
            sv.setFolio(calculateFolio(preFolio));
            System.out.println("folio calculated");
            
            //System.out.println(sv.getEncuesta());
            dataFrm.encuesta_label.setText(sv.getEncuesta());
            
            sv.setMunicipio(dataFrm.cbox_municipio.getSelectedItem().toString());
            //System.out.println(sv.getMunicipio());
            
            sv.setNivel(dataFrm.cbox_nivel.getSelectedItem().toString());
            //System.out.println(sv.getNivel());
            
            sv.setSistema(dataFrm.cbox_sistema.getSelectedItem().toString());
            //System.out.println(sv.getSistema());
            
            sv.setTurno(dataFrm.cbox_turno.getSelectedItem().toString());
            //System.out.println(sv.getTurno());
            
            sv.setModalidad(dataFrm.cbox_modalidad.getSelectedItem().toString());
            //System.out.println(sv.getModalidad());
            
            sv.setAntiguedad(dataFrm.cbox_antiguedad.getSelectedItem().toString());
            //System.out.println(sv.getAntiguedad());
            
            sv.setSexo(dataFrm.cbox_sexo.getSelectedItem().toString());
            //System.out.println(sv.getSexo());
            
            sv.setEdad(dataFrm.cbox_edad.getSelectedItem().toString());
            //System.out.println(sv.getEdad());
            
            sv.setAnios_servicio(dataFrm.cbox_aniosServicio.getSelectedItem().toString());
            //System.out.println(sv.getAnios_servicio());
            
            sv.setNombre(dataFrm.txt_encuestador.getText());
            //System.out.println(sv.getNombre());
            
            sv.setFecha(dataFrm.jDateChooser1.getDate().toString());
            //System.out.println(sv.getFecha());
            
            System.out.println(sv.getArchivo());

        }
    }
    
    public String calculateFolio(String preFolio){
        try{
            int nFolio= dq.getLastID();
            preFolio = preFolio+ Integer.toString(nFolio);
            return preFolio;
            
        }catch (Exception e){
            System.err.println(e);
            preFolio = preFolio+ Integer.toString(0);
            return preFolio;
        }
        
    }
    
    public void insert_Data(){
        boolean flag = dq.create(this.sv);
            //dq.getLastID();
            System.out.println(flag);
            
            //if(dq.create(sv)){
            if(flag){
                JOptionPane.showMessageDialog(null, "Datos guardados");
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
    }
    
    public String returnSurveyViewType(){
        return sv.getEncuesta();
    }

    
    
}
