package Controllers;

import Managers.MaterialData;
import Models.Material;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Main controller it communcates with MaterialData and the view
 * @author ahmed benkrara
 */
public class MainController {
    //MaterialData object
    private MaterialData materialData = new MaterialData();

    /**
     * it gets all material data
     * @return
     */
    public ArrayList<Material> getAllMaterials(){
        try {
            return materialData.getMaterials();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * it looks for materials with their title
     * @param titre
     * @return
     */
    public ArrayList<Material> findMaterial(String titre){
        try {
            return materialData.getMaterial(titre);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * it checks if a material is available or no and alerts a message if the material isn't available to be loan
     * @param titre
     * @return
     */
    public Boolean isAvailable(String titre){
        try {
            if(materialData.isAvailable(titre)){
                return true;
            }else{
                new JOptionPane().showMessageDialog(null,"This material isn't available right now !","Information",JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
