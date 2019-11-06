/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sicad.pkg0;

import app.dataView;
import app.mainMenu;
import controller.ctrlData;
import databaseConnection.dataQueries;
import surveyClasses.dataSurvey;

/**
 *
 * @author astri
 */
public class SICAD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        dataSurvey mod = new dataSurvey();
        dataQueries queries = new dataQueries();
        mainMenu  menuFrm = new mainMenu();
        dataView dataFrm = new dataView();
        //We initialize 
        ctrlData ctrl = new ctrlData(mod,queries,dataFrm);
        
        menuFrm.setVisible(true);
        
        
    }
    
}
