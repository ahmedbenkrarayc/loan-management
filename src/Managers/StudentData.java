package Managers;

import DAO.IStudent;
import Models.Student;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * a class that implements IStudent and give a body to its methods to deal directly with database
 * @author ahmed benkrara
 */
public class StudentData implements IStudent {
    //private attribute from Database class
    private Database db;
    /**
     * Default constructor
     */
    public StudentData(){
        db = new Database();
    }

    /**
     * it reads all students from database
     * @return ArrayList<Student>
     * @throws SQLException
     */
    @Override
    public ArrayList<Student> getStudents() throws SQLException {
        PreparedStatement result = null;
        try {
            result = db.getConnection().prepareStatement("select * from student");
            var rs = result.executeQuery();
            ArrayList<Student> students = new ArrayList<>();
            while(rs.next()){
                 students.add(new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * creating a new student
     * @param user
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean addStudent(Student user) throws SQLException {
        try {
            if(getStudentByEmail(user.getEmail()) == null){
                var prs = db.getConnection().prepareStatement("insert into student(nom,prenom,email) values (?,?,?)");
                prs.setString(1, user.getPrenom());
                prs.setString(2, user.getNom());
                prs.setString(3, user.getEmail());

                int row = prs.executeUpdate();
                if (row == 0){
                    return false;
                }
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    /**
     * it will be used in future versions to update student informations
     * @param user
     * @return
     */
    @Override
    public boolean updateStudent(Student user) {
        return false;
    }

    /**
     * it will be used in future versions to delete a student
     * @param user
     * @return
     */
    @Override
    public boolean deleteStudent(Student user) {
        return false;
    }

    /**
     * it reads from database a student by his id
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Student getStudentById(int id) throws SQLException {
        PreparedStatement result = null;
        try {
            result = db.getConnection().prepareStatement("select * from student where id = ?");

            result.setInt(1,id);
            var rs = result.executeQuery();
            if(rs.next()){
                return new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    /**
     * it reads from database a student by his email
     * @param email
     * @return Student
     */

    @Override
    public Student getStudentByEmail(String email) {
        PreparedStatement result = null;
        try {
        result = db.getConnection().prepareStatement("select * from student where email like ?");

        result.setString(1,email);
        var rs = result.executeQuery();
        if(rs.next()){
            return new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
