package Controllers;

import Managers.MaterialData;
import Models.Material;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainController {
    private MaterialData materialData = new MaterialData();
    public ArrayList<Material> getAllMaterials(){
        try {
            return materialData.getMaterials();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Material> findMaterial(String titre){
        try {
            return materialData.getMaterial(titre);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
