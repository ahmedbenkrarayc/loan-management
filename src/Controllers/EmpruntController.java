package Controllers;

import Managers.EmpruntData;
import Managers.MaterialData;
import Models.Emprunt;
import Models.Material;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Emprunt controller that communicates with EmpruntData and MaterialData and the view in same time
 * @author ahmed benkrara
 */
public class EmpruntController {
    //EmpruntData object
    EmpruntData data = new EmpruntData();
    //MaterialData object
    MaterialData materialData = new MaterialData();

    /**
     * it adds a loan and alerts a success message if it went correctly or failure message if something was wrong
     * @param emprunt
     * @return
     */
    public Boolean emprunter(Emprunt emprunt){
        try {
            if(data.addEmprunt(emprunt)){
               materialData.changeStatus(emprunt.getMaterial().getId(),0);
               new JOptionPane().showMessageDialog(null,emprunt.getMaterial().getTitre()+" is successfully borrowed by "+emprunt.getStudent().getNom()+" "+emprunt.getStudent().getPrenom(),"Success",JOptionPane.INFORMATION_MESSAGE);
               return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        new JOptionPane().showMessageDialog(null,"Something went wrong please try again later !","Failure",JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
