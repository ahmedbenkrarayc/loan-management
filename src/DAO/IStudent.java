package DAO;

import Models.Student;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface for definning Student methods
 */
public interface IStudent {
    /**
     *
     * @return ArrayList<Student>
     * @throws SQLException
     */
    ArrayList<Student> getStudents() throws SQLException;

    /**
     *
     * @param user
     * @return boolean
     * @throws SQLException
     */
    boolean addStudent(Student user) throws SQLException;

    /**
     *
     * @param user
     * @return boolean
     */
    boolean updateStudent(Student user);

    /**
     *
     * @param user
     * @return boolean
     */
    boolean deleteStudent(Student user);

    /**
     *
     * @param id
     * @return Student
     * @throws SQLException
     */
    Student getStudentById(int id) throws SQLException;

    /**
     *
     * @param email
     * @return Student
     */
    Student getStudentByEmail(String email);
}
