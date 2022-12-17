import Views.EmpruntFrame;
import Views.HistoryFrame;
import Views.LoginFrame;
import Views.MainFrame;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        try{
            LoginFrame login = new LoginFrame();
            login.setVisible(true);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}