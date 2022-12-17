package Controllers;

import Managers.DataTransfer;
import Managers.EmpruntData;
import Managers.StudentData;
import Models.Emprunt;
import Models.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class HistoryController {
    private StudentData data = new StudentData();
    private EmpruntData empruntData = new EmpruntData();

    public void refreshStudents(JTable table, DefaultTableModel model, String email){
        model.getDataVector().clear();
        try {
            if(email == null || email.trim().length() == 0){
                loadAllData(model);
            }else{
                Student student = data.getStudentByEmail(email);
                if(student != null){
                    model.addRow(new Object[]{student.getId(),student.getNom(),student.getPrenom(),student.getEmail()});
                }else{
                    new JOptionPane().showMessageDialog(null,"There is no student with this email !","Warning",JOptionPane.WARNING_MESSAGE);
                    loadAllData(model);
                }
            }
            table.invalidate();
            table.validate();
            table.repaint();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAllData(DefaultTableModel model) throws SQLException{
        ArrayList<Student> list = data.getStudents();
        for(int i=0;i<list.size();i++){
            model.addRow(new Object[]{list.get(i).getId(),list.get(i).getNom(),list.get(i).getPrenom(),list.get(i).getEmail()});
        }
    }

    public void loanHistory(JTable table, DefaultTableModel model){
        model.getDataVector().clear();
        try {
            ArrayList<Emprunt> emprunts = empruntData.getEmpruntByStudentId(DataTransfer.student_id);
            if(emprunts != null){
                for(int i=0;i<emprunts.size();i++){
                    model.addRow(new Object[]{emprunts.get(i).getMaterial().getTitre(),emprunts.get(i).getDate_l(),emprunts.get(i).getDuration(),emprunts.get(i).getDate_back() == null ? "null" : emprunts.get(i).getDate_back()});
                }
            }
            table.invalidate();
            table.validate();
            table.repaint();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}