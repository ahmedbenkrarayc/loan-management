package Controllers;

import Managers.StudentData;
import Models.Student;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Student controller it communicates with StudentData and its view too
 * @author ahmed benkrara
 */
public class StudentController {
    //StudentData object
    private StudentData data = new StudentData();

    /**
     * it adds a student to the database after checking if a student with same email already exists or no
     * if student already exists it alerts an error message
     * if student doesn't exist it inserts him to the database and alerts a success message
     * @param student
     */
    public void addStudent(Student student){
        try {
            JOptionPane pane = new JOptionPane();
            if(!data.addStudent(student)){
                pane.showMessageDialog(null,"A student with this email already exists !","student exists",JOptionPane.WARNING_MESSAGE);
            }else{
                pane.showMessageDialog(null,"Student Successfully added !","Success",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * it checks if a student already exists or no
     * if exists it returns an object Student class
     * else it returns null and alerts a warning message
     * @param email
     * @return
     */
    public Student isStudentExist(String email){
        var result = data.getStudentByEmail(email);
        if(result == null){
            new JOptionPane().showMessageDialog(null,"There is no student with this email !","Warning",JOptionPane.WARNING_MESSAGE);
            return null;
        }else{
            return result;
        }
    }


}
