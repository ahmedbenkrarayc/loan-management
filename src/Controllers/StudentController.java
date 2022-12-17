package Controllers;

import Managers.StudentData;
import Models.Student;

import javax.swing.*;
import java.sql.SQLException;

public class StudentController {
    private StudentData data = new StudentData();

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
