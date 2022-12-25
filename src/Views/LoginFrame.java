package Views;

import Controllers.LoginController;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.ui.FlatButtonUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * login frame
 * @author ahmed benkrara
 */
public class LoginFrame extends JFrame {
    /**
     * constructor for displaying controls
     */
    public LoginFrame(){
        super();
        this.setTitle("Login");
        LoginController controller = new LoginController();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        JPanel panel = new JPanel();
        panel.setSize(400,600);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBackground(new Color(0,5,24));
        panel.setBorder(new EmptyBorder(80,60,0,0));
        this.setSize(400,600);
        this.getContentPane().setBackground(new Color(0,5,24));
        JLabel title = new JLabel("Welcome Back");
        title.setForeground(Color.white);
        title.setFont(new Font("groovy",Font.BOLD,25));
        panel.add(title);

        JLabel desc = new JLabel("Connect to your account");
        desc.setFont(new Font("groovy",Font.BOLD,12));
        desc.setForeground(Color.lightGray);
        desc.setBorder(new EmptyBorder(8,0,0,0));
        panel.add(desc);

        JLabel user = new JLabel("UserName");
        user.setFont(new Font("groovy",Font.BOLD,12));
        user.setForeground(Color.lightGray);
        user.setBorder(new EmptyBorder(40,0,10,0));
        panel.add(user);

        JTextField email = new JTextField();
        email.setPreferredSize(new Dimension(500,30));
        email.setMaximumSize(new Dimension(500,30));
        email.setBorder(new EmptyBorder(0,4,0,4));
        email.setFont(new Font("Groovy",Font.BOLD,12));
        email.setForeground(new Color(0,5,24));
        panel.add(email);

        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("groovy",Font.BOLD,12));
        pass.setForeground(Color.lightGray);
        pass.setBorder(new EmptyBorder(20,0,10,0));
        panel.add(pass);

        JPasswordField password = new JPasswordField();
        password.setPreferredSize(new Dimension(500,30));
        password.setMaximumSize(new Dimension(500,30));
        password.setBorder(new EmptyBorder(0,4,0,4));
        password.setFont(new Font("Groovy",Font.BOLD,12));
        password.setForeground(new Color(0,5,24));
        panel.add(password);

        JLabel l = new JLabel();
        l.setBorder(new EmptyBorder(40,0,0,0));
        panel.add(l);

        JButton login = new JButton("Login");
        login.setSize(100,20);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        login.setBackground(new Color(37,0,85));
        login.setForeground(Color.white);
        login.setBorder(new EmptyBorder(10,105,10,105));
        login.setFocusPainted(false);
        panel.add(login);

        login.addActionListener(e->{
            controller.login(email.getText(),password.getText(),this,new MainFrame());
        });

        this.getContentPane().add(panel);
    }
}
