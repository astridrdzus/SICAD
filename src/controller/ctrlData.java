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
import surveyClasses.dataSurvey;
import java.sql.SQLException;

/**
 *
 * @author astri
 */
public class ctrlData implements ActionListener{
    
    private dataSurvey sv;
    private dataQueries dq;
    private dataView dataFrm;
    public String lastFolio;

    public String getLastFolio() {
        return lastFolio;
    }

    public void setLastFolio(String lastFolio) {
        this.lastFolio = lastFolio;
    }
    
    public ctrlData(dataSurvey sv, dataQueries dq, dataView dataFrm){
        this.sv = sv;
        this.dq = dq;
        this.dataFrm = dataFrm;
        this.dataFrm.btn_SaveData.addActionListener(this);
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        //System.out.println("Button pushed");
        if(e.getSource() == dataFrm.btn_SaveData){
            
            /*sv.setFolio(Integer.toString(folioCont));
            System.out.println(sv.getFolio());*/
            
            String preFolio = sv.getFolio();
            sv.setFolio(calculateFolio(preFolio));
            System.out.println("sv.setFolio: "+sv.getFolio());
            this.setLastFolio(sv.getFolio());
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
            System.out.println("Path archivo: "+sv.getArchivo());
            
            boolean flag = dq.create(sv);
            //dq.getLastID();
            System.out.println(flag);
            
            //if(dq.create(sv)){
            if(flag){
                JOptionPane.showMessageDialog(null, "Datos guardados");
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }

        }
    }
    
    public String calculateFolio(String preFolio){
        try{
            System.out.println("prefolio :"+preFolio);
            int nFolio= dq.getLastID();
            System.out.println(Integer.toString(nFolio));
            preFolio = preFolio+ Integer.toString(nFolio);
            System.out.println("postfolio: "+preFolio);
            return preFolio;
            
        }catch (Exception e){
            System.err.println(e);
            preFolio = preFolio+ Integer.toString(0);
            return preFolio;
        }
        
    }
    
    
    public String returnSurveyViewType(){
        return sv.getEncuesta();
    }

    
    
}
