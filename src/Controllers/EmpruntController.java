package Controllers;

import Managers.EmpruntData;
import Managers.MaterialData;
import Models.Emprunt;
import Models.Material;

import javax.swing.*;
import java.sql.SQLException;

public class EmpruntController {
    EmpruntData data = new EmpruntData();
    MaterialData materialData = new MaterialData();

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
        return false;
    }
}
