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
        
        if(e.getSource() == dataFrm.btn_SaveData){
            sv.setFolio(folioCont);
            sv.setMunicipio(dataFrm.cbox_municipio.getName());
            sv.setNivel(dataFrm.cbox_nivel.getName());
            sv.setSistema(dataFrm.cbox_sistema.getName());
            sv.setTurno(dataFrm.cbox_turno.getName());
            sv.setModalidad(dataFrm.cbox_modalidad.getName());
            sv.setAntiguedad(dataFrm.cbox_antiguedad.getName());
            sv.setSexo(dataFrm.cbox_sexo.getName());
            sv.setEdad(dataFrm.cbox_edad.getName());
            sv.setAnios_servicio(dataFrm.cbox_aniosServicio.getName());
            sv.setNombre(dataFrm.txt_encuestador.getName());
            sv.setFecha(dataFrm.jDateChooser1.getDateFormatString());
            
            if(dq.create(sv)){
                JOptionPane.showMessageDialog(null, "Datos guardados");
                folioCont++;
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }
    }

    
    
}
