package Controllers;

import DAO.ILogin;
import Managers.LoginData;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Login controller it communicates with LoginData and also the login view
 * @author ahmed benkrara
 */
public class LoginController {
    //LoginData object
    private LoginData login = new LoginData();

    /**
     * it logs in using email and password if they are correct it moves the user from the JFrame of login that is named from to the MainFrame that is name to in params
     * if the email or password are wrong it alerts an error message
     * @param email
     * @param password
     * @param from
     * @param to
     */
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
