package DAO;

import Models.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IStudent {
    ArrayList<Student> getStudents() throws SQLException;
    boolean addStudent(Student user) throws SQLException;
    boolean updateStudent(Student user);
    boolean deleteStudent(Student user);
    Student getStudentById(int id) throws SQLException;
    Student getStudentByEmail(String email);
}
