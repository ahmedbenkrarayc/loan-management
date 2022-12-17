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

/**
 * History controller that communicates with StudentData and EmpruntData and the view in same time
 * @author ahmed benkrara
 */
public class HistoryController {
    //StudentData object
    private StudentData data = new StudentData();
    //EmpruntData object
    private EmpruntData empruntData = new EmpruntData();

    /**
     * it displays student informations and loan data in the JTable in params using the DefaultTableModel in params
     * if email is empty or null it displays all data
     * if email has a value it displays th data based on the email and if no data found it alerts a message to inform user and loads all data in the table
     * @param table
     * @param model
     * @param email
     */
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

    /**
     * it reads all data and add it to the model param
     * @param model
     * @throws SQLException
     */
    private void loadAllData(DefaultTableModel model) throws SQLException{
        ArrayList<Student> list = data.getStudents();
        for(int i=0;i<list.size();i++){
            model.addRow(new Object[]{list.get(i).getId(),list.get(i).getNom(),list.get(i).getPrenom(),list.get(i).getEmail()});
        }
    }

    /**
     * it reads loans history by a student id and displays it in the JTable passed in params using DefaultTableModel in params
     * @param table
     * @param model
     */
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