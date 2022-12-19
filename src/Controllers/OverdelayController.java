package Controllers;

import Managers.EmpruntData;
import Models.Emprunt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Overdelay controller it communicates with EmpruntData and the view
 */
public class OverdelayController {
    //EmpruntData object
    private EmpruntData data = new EmpruntData();

    /**
     * it display in the view overdelay loans with displaying how many days the loan is late
     * @param table
     * @param model
     * @param search
     */
    public void fillTable(JTable table, DefaultTableModel model, String search){
        model.getDataVector().clear();
        try {
            if(search == null || search.trim().length() == 0){
                getAllData(model);
            }else{
                ArrayList<Emprunt> emprunts = data.getEmprunts(search);
                if(emprunts != null){
                    for(int i=0;i<emprunts.size();i++){
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(emprunts.get(i).getDate_l());
                        cal.add(Calendar.DAY_OF_MONTH,emprunts.get(i).getDuration());
                        Date expected_back = cal.getTime();

                        //back date
                        if(expected_back.compareTo(new Date(Calendar.getInstance().getTimeInMillis())) == -1){
                            long delay = Emprunt.delay(new Date(Calendar.getInstance().getTimeInMillis()),expected_back);
                            if(delay > 0){
                                model.addRow(new Object[]{emprunts.get(i).getStudent().getNom(),emprunts.get(i).getStudent().getPrenom(),emprunts.get(i).getStudent().getEmail(),emprunts.get(i).getMaterial().getTitre(),emprunts.get(i).getDate_l(),emprunts.get(i).getDuration(),delay});
                            }
                        }
                    }
                }else{
                    getAllData(model);
                    JOptionPane.showMessageDialog(null,"No data found","Information",JOptionPane.INFORMATION_MESSAGE);
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
     * it affects all loans that aren't back yet to the DefaultTableModel in params
     * @param model
     * @throws SQLException
     */
    private void getAllData(DefaultTableModel model) throws SQLException {
        ArrayList<Emprunt> emprunts = data.getEmprunts();
        if(emprunts != null){
            for(int i=0;i<emprunts.size();i++){
                Calendar cal = Calendar.getInstance();
                cal.setTime(emprunts.get(i).getDate_l());
                cal.add(Calendar.DAY_OF_MONTH,emprunts.get(i).getDuration());
                Date expected_back = cal.getTime();

                //back date
                if(expected_back.compareTo(new Date(Calendar.getInstance().getTimeInMillis())) == -1){
                    long delay = Emprunt.delay(new Date(Calendar.getInstance().getTimeInMillis()),expected_back);
                    if(delay > 0){
                        model.addRow(new Object[]{emprunts.get(i).getStudent().getNom(),emprunts.get(i).getStudent().getPrenom(),emprunts.get(i).getStudent().getEmail(),emprunts.get(i).getMaterial().getTitre(),emprunts.get(i).getDate_l(),emprunts.get(i).getDuration(),delay});
                    }
                }
            }
        }
    }


}