package Controllers;

import Managers.EmpruntData;
import Managers.MaterialData;
import Models.Emprunt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Return controller that communicates with EmpruntData and MaterialData and also the view
 * @author ahmed benkrara
 */
public class ReturnController {
    //EmpruntData object
    private EmpruntData empruntData = new EmpruntData();
    //MaterialData object
    private MaterialData materialData = new MaterialData();

    /**
     * it displays in a JTable loans that aren't back yet and searchs by material name
     * if name is null or empty it display all loans
     * if name has a value it displays data based on name
     * if no data found in search it alerts a message and displays all data in same time
     * @param table
     * @param model
     * @param name
     */
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

    /**
     * it reads all loan data that isn't back yet and affect it to the DefaultTableModel in params
     * @param model
     * @throws SQLException
     */
    private void allData(DefaultTableModel model) throws SQLException {
        ArrayList<Emprunt> emprunts = empruntData.getEmprunts();
        if(emprunts != null){
            for(int i=0;i<emprunts.size();i++){
                model.addRow(new Object[]{emprunts.get(i).getId(),emprunts.get(i).getStudent().getNom(),emprunts.get(i).getStudent().getPrenom(),emprunts.get(i).getStudent().getEmail(),emprunts.get(i).getMaterial().getId(),emprunts.get(i).getMaterial().getTitre(),emprunts.get(i).getDate_l(),emprunts.get(i).getDuration()});
            }
        }
    }

    /**
     * id is the id of loan
     * this method changes the status of a material to 1 after the loan is back and it updates the loan back date from null ro today's date
     * it alerts a message of success and reload table data
     * if there's some exception it alerts an error message
     * @param id
     * @param material_id
     * @param table
     * @param model
     */
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
