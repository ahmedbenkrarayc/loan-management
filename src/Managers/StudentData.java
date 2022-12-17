package Managers;

import DAO.IStudent;
import Models.Student;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentData implements IStudent {
    private Database db;
    public StudentData(){
        db = new Database();
    }

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

    @Override
    public boolean updateStudent(Student user) {
        return false;
    }

    @Override
    public boolean deleteStudent(Student user) {
        return false;
    }

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
