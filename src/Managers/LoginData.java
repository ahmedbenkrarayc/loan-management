package Managers;

import DAO.ILogin;
import Models.Material;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginData implements ILogin {
    private Database db;

    public LoginData(){
        db = new Database();
    }

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
