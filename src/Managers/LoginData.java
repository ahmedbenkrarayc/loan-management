package Managers;

import DAO.ILogin;
import Models.Material;

import java.sql.SQLException;

/**
 * a class that implements ILogin and give a body to its methods to deal directly with database
 * @author ahmed benkrara
 */
public class LoginData implements ILogin {
    //private attribute from Database class
    private Database db;

    /**
     * Default constructor
     */
    public LoginData(){
        db = new Database();
    }

    /**
     * it checks if an admin exists with the given email and password if found it returns true else it returns false
     * @param email
     * @param password
     * @return Boolean
     * @throws SQLException
     */
    @Override
    public Boolean getAdmin(String email, String password) throws SQLException {
        var result = db.getConnection().prepareStatement("select * from admin where email like ? AND password like ?");
        result.setString(1,email);
        result.setString(2,password);
        var rs = result.executeQuery();
        if(rs.next()){
            return true;
        }
        return false;
    }
}
