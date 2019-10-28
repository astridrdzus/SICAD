/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import app.dataView;
import databaseConnection.dataQueries;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import surveyClasses.surveyData;

/**
 *
 * @author astri
 */
public class ctrlData implements ActionListener{
    
    private surveyData sv;
    private dataQueries dq;
    private dataView dataFrm;
    public int folioCont = 0;
    
    public ctrlData(surveyData sv, dataQueries dq, dataView dataFrm){
        this.sv = sv;
        this.dq = dq;
        this.dataFrm = dataFrm;
        this.dataFrm.btn_SaveData.addActionListener(this);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Button pushed");
        if(e.getSource() == dataFrm.btn_SaveData){
            sv.setFolio(folioCont);
            System.out.println(sv.getFolio());
            
            System.out.println(sv.getEncuesta());
            
            sv.setMunicipio(dataFrm.cbox_municipio.getSelectedItem().toString());
            System.out.println(sv.getMunicipio());
            
            sv.setNivel(dataFrm.cbox_nivel.getSelectedItem().toString());
            System.out.println(sv.getNivel());
            
            sv.setSistema(dataFrm.cbox_sistema.getSelectedItem().toString());
            System.out.println(sv.getSistema());
            
            sv.setTurno(dataFrm.cbox_turno.getSelectedItem().toString());
            System.out.println(sv.getTurno());
            
            sv.setModalidad(dataFrm.cbox_modalidad.getSelectedItem().toString());
            System.out.println(sv.getModalidad());
            
            sv.setAntiguedad(dataFrm.cbox_antiguedad.getSelectedItem().toString());
            System.out.println(sv.getAntiguedad());
            
            sv.setSexo(dataFrm.cbox_sexo.getSelectedItem().toString());
            System.out.println(sv.getSexo());
            
            sv.setEdad(dataFrm.cbox_edad.getSelectedItem().toString());
            System.out.println(sv.getEdad());
            
            sv.setAnios_servicio(dataFrm.cbox_aniosServicio.getSelectedItem().toString());
            System.out.println(sv.getAnios_servicio());
            
            sv.setNombre(dataFrm.txt_encuestador.getText());
            System.out.println(sv.getNombre());
            
            sv.setFecha(dataFrm.jDateChooser1.getDate().toString());
            System.out.println(sv.getFecha());
            
            System.out.println("Datos guardados");
            
            if(dq.create(sv)){
                JOptionPane.showMessageDialog(null, "Datos guardados");
                folioCont++;
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }
    }

    
    
}
