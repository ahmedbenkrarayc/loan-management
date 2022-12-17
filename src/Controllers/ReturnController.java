package Controllers;

import Managers.DataTransfer;
import Managers.EmpruntData;
import Managers.MaterialData;
import Models.Emprunt;
import Models.Material;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ReturnController {
    /*int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to return this material?","Warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
        JOptionPane.showMessageDialog(null,"success","success",JOptionPane.INFORMATION_MESSAGE);
    }*/
    private EmpruntData empruntData = new EmpruntData();
    private MaterialData materialData = new MaterialData();

    public void returnData(JTable table, DefaultTableModel model, String name){
        model.getDataVector().clear();
        try {
            if(name == null || name.trim().length() == 0){
                allData(model);
            }else{
                ArrayList<Emprunt> emprunts = empruntData.getEmpruntByMaterial(name);
                if(emprunts != null){
                    for(int i=0;i<emprunts.size();i++){
                        model.addRow(new Object[]{emprunts.get(i).getId(),emprunts.get(i).getStudent().getNom(),emprunts.get(i).getStudent().getPrenom(),emprunts.get(i).getStudent().getEmail(),emprunts.get(i).getMaterial().getId(),emprunts.get(i).getMaterial().getTitre(),emprunts.get(i).getDate_l(),emprunts.get(i).getDuration()});
                    }
                }else{
                    allData(model);
                    new JOptionPane().showMessageDialog(null,"No data found !","Warning",JOptionPane.WARNING_MESSAGE);
                }
            }
            table.invalidate();
            table.validate();
            table.repaint();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void allData(DefaultTableModel model) throws SQLException {
        ArrayList<Emprunt> emprunts = empruntData.getEmprunts();
        if(emprunts != null){
            for(int i=0;i<emprunts.size();i++){
                model.addRow(new Object[]{emprunts.get(i).getId(),emprunts.get(i).getStudent().getNom(),emprunts.get(i).getStudent().getPrenom(),emprunts.get(i).getStudent().getEmail(),emprunts.get(i).getMaterial().getId(),emprunts.get(i).getMaterial().getTitre(),emprunts.get(i).getDate_l(),emprunts.get(i).getDuration()});
            }
        }
    }

    public void returnLoan(int id, int material_id,JTable table,DefaultTableModel model){
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to return this material?","Warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            try {
                materialData.changeStatus(material_id,1);
                empruntData.effectBackDate(id);
                JOptionPane.showMessageDialog(null,"success","success",JOptionPane.INFORMATION_MESSAGE);
                model.getDataVector().clear();
                table.removeEditor();
                allData(model);
                table.invalidate();
                table.validate();
                table.repaint();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Ooops something went wrong !","Failure",JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException(e);
            }
        }
    }
}
