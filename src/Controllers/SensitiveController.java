package Controllers;

import Managers.EmpruntData;
import Models.Emprunt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SensitiveController {
    public EmpruntData data = new EmpruntData();

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
                        cal.setTime(expected_back);
                        cal.add(Calendar.DAY_OF_MONTH,-2);
                        // Fri Dec 09 00:00:00 CET 2022
                        String[] two = String.valueOf(cal.getTime()).split(" ");
                        String[] today = String.valueOf(new Date(Calendar.getInstance().getTimeInMillis())).split(" ");
                        int todayDay = Integer.parseInt(today[5].trim());
                        int twoday = Integer.parseInt(two[5].trim());
                        if(two[1].trim().equalsIgnoreCase(today[1].trim()) && two[2].trim().equalsIgnoreCase(today[2].trim()) && todayDay >= twoday){
                            long delay = Emprunt.delay(expected_back,cal.getTime());
                            model.addRow(new Object[]{emprunts.get(i).getStudent().getNom(),emprunts.get(i).getStudent().getPrenom(),emprunts.get(i).getStudent().getEmail(),emprunts.get(i).getMaterial().getTitre(),emprunts.get(i).getDate_l(),emprunts.get(i).getDuration(),delay});
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

    private void getAllData(DefaultTableModel model) throws SQLException {
        ArrayList<Emprunt> emprunts = data.getEmprunts();
        if(emprunts != null){
            for(int i=0;i<emprunts.size();i++){
                Calendar cal = Calendar.getInstance();
                cal.setTime(emprunts.get(i).getDate_l());
                cal.add(Calendar.DAY_OF_MONTH,emprunts.get(i).getDuration());
                Date expected_back = cal.getTime();
                cal.setTime(expected_back);
                cal.add(Calendar.DAY_OF_MONTH,-2);
               // Fri Dec 09 00:00:00 CET 2022
                String[] two = String.valueOf(cal.getTime()).split(" ");
                String[] today = String.valueOf(new Date(Calendar.getInstance().getTimeInMillis())).split(" ");
                int todayDay = Integer.parseInt(today[5].trim());
                int twoday = Integer.parseInt(two[5].trim());
                if(two[1].trim().equalsIgnoreCase(today[1].trim()) && two[2].trim().equalsIgnoreCase(today[2].trim()) && todayDay >= twoday){
                    long delay = Emprunt.delay(expected_back,cal.getTime());
                    model.addRow(new Object[]{emprunts.get(i).getStudent().getNom(),emprunts.get(i).getStudent().getPrenom(),emprunts.get(i).getStudent().getEmail(),emprunts.get(i).getMaterial().getTitre(),emprunts.get(i).getDate_l(),emprunts.get(i).getDuration(),delay});
                }
            }
        }
    }
}
