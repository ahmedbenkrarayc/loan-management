package Controllers;

import DAO.ILogin;
import Managers.LoginData;

import javax.swing.*;
import java.sql.SQLException;

public class LoginController {
    private LoginData login = new LoginData();
    public void login(String email, String password, JFrame from, JFrame to){
        try {
            if(!login.getAdmin(email,password)){
                JOptionPane pane = new JOptionPane();
                pane.showMessageDialog(null,"Email or password is wrong !","Login error",JOptionPane.WARNING_MESSAGE);
            }else{
                from.setVisible(false);
                to.setVisible(true);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
