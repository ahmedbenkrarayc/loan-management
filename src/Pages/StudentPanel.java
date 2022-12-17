package Pages;

import Controllers.StudentController;
import Managers.DataTransfer;
import Models.Student;
import Views.EmpruntFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Student Panel for adding a new student or liking an existing student to a loan
 */
public class StudentPanel extends JPanel {
    /**
     * constructor for displaying controls
     */
    public StudentPanel(){
        StudentController controller = new StudentController();
        setPreferredSize(new Dimension(1040,700));
        setBackground(new Color(0,5,24));
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(40,0,0,0));

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.CENTER));
        top.setPreferredSize(new Dimension(1040,60));
        top.setMaximumSize(new Dimension(1040,60));
        top.setBackground(new Color(0,0,0,0));

        JLabel title = new JLabel("Student");
        title.setFont(new Font("groovy",Font.BOLD,25));
        title.setForeground(Color.white);
        top.add(title);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
        main.setPreferredSize(new Dimension(1040,100));
        main.setMaximumSize(new Dimension(1040,100));
        main.setBackground(new Color(0,0,0,0));

        JPanel exists = new JPanel();
        exists.setLayout(new FlowLayout(FlowLayout.CENTER));
        exists.setPreferredSize(new Dimension(500,100));
        exists.setMaximumSize(new Dimension(500,100));
        exists.setBackground(new Color(0,0,0,0));

        JLabel text1 = new JLabel("Student Email :");
        text1.setFont(new Font("groovy",Font.BOLD,18));
        text1.setForeground(Color.white);
        exists.add(text1);
        JTextField email = new JTextField();
        email.setPreferredSize(new Dimension(250,30));
        email.setFont(new Font("groovy",Font.BOLD,15));
        email.setBorder(new EmptyBorder(5,5,5,5));
        exists.add(email);
        JLabel label = new JLabel();
        label.setBorder(new EmptyBorder(20,250,0,250));
        exists.add(label);
        JButton next = new JButton("Next");
        next.setBorder(new EmptyBorder(0,0,0,0));
        next.setBackground(new Color(37,0,85));
        next.setForeground(Color.white);
        next.setPreferredSize(new Dimension(160,30));
        next.setMinimumSize(new Dimension(160,30));
        next.setFocusPainted(false);
        next.setFont(new Font("groovy",Font.BOLD,16));
        exists.add(next);
        main.add(exists);

        JLabel line = new JLabel();
        line.setBorder(new EmptyBorder(50,0,0,0));
        main.add(line);

        JPanel separator = new JPanel();
        separator.setPreferredSize(new Dimension(1042,1));
        separator.setMaximumSize(new Dimension(1042,1));
        separator.setBackground(Color.gray);
        main.add(separator);

        JPanel title2 = new JPanel();
        title2.setLayout(new FlowLayout());
        title2.setPreferredSize(new Dimension(1042,50));
        title2.setMaximumSize(new Dimension(1042,50));
        title2.setBackground(new Color(0,0,0,0));

        JLabel title1 = new JLabel("Add new student");
        title1.setFont(new Font("groovy",Font.BOLD,25));
        title1.setForeground(Color.white);
        title2.add(title1);
        main.add(title2);

        JPanel name = new JPanel();
        name.setLayout(new FlowLayout());
        name.setPreferredSize(new Dimension(1042,100));
        name.setMaximumSize(new Dimension(1042,100));
        name.setBackground(new Color(0,0,0,0));

        JLabel name1 = new JLabel("First Name :");
        name1.setFont(new Font("groovy",Font.BOLD,18));
        name1.setForeground(Color.white);
        name.add(name1);
        JTextField fname = new JTextField();
        fname.setPreferredSize(new Dimension(250,30));
        fname.setMaximumSize(new Dimension(250,30));
        fname.setFont(new Font("groovy",Font.BOLD,15));
        fname.setBorder(new EmptyBorder(5,5,5,5));
        name.add(fname);
        JLabel name2 = new JLabel("   Last Name :");
        name2.setFont(new Font("groovy",Font.BOLD,18));
        name2.setForeground(Color.white);
        name.add(name2);
        JTextField lname = new JTextField();
        lname.setPreferredSize(new Dimension(250,30));
        lname.setMaximumSize(new Dimension(250,30));
        lname.setFont(new Font("groovy",Font.BOLD,15));
        lname.setBorder(new EmptyBorder(5,5,5,5));
        name.add(lname);
        main.add(name);

        JPanel mail = new JPanel();
        mail.setLayout(new FlowLayout(FlowLayout.LEFT));
        mail.setPreferredSize(new Dimension(660,100));
        mail.setMaximumSize(new Dimension(660,100));
        mail.setBackground(new Color(0,0,0,0));

        JLabel ml = new JLabel("Email :");
        ml.setFont(new Font("groovy",Font.BOLD,18));
        ml.setForeground(Color.white);
        mail.add(ml);
        JTextField mailr = new JTextField();
        mailr.setPreferredSize(new Dimension(250,30));
        mailr.setMaximumSize(new Dimension(250,30));
        mailr.setFont(new Font("groovy",Font.BOLD,15));
        mailr.setBorder(new EmptyBorder(5,5,5,5));
        mail.add(mailr);

        JLabel space = new JLabel();
        space.setBorder(new EmptyBorder(0,150,0,0));
        mail.add(space);

        JButton add = new JButton("Add Student");
        add.setBorder(new EmptyBorder(0,0,0,0));
        add.setBackground(new Color(37,0,85));
        add.setForeground(Color.white);
        add.setPreferredSize(new Dimension(160,30));
        add.setMinimumSize(new Dimension(160,30));
        add.setFocusPainted(false);
        add.setFont(new Font("groovy",Font.BOLD,16));

        mail.add(add);
        main.add(mail);

        add(top,BorderLayout.NORTH);
        add(main,BorderLayout.CENTER);

        add.addActionListener(e -> {
            if(valider(lname.getText(), "last name") && valider(fname.getText(), "first name") && valider(mailr.getText(),"email")){
                controller.addStudent(new Student(lname.getText(),fname.getText(),mailr.getText()));
            }
        });

        next.addActionListener(e->{
            if(valider(email.getText(),"email")){
                Student result = controller.isStudentExist(email.getText());
                if(result != null){
                    DataTransfer.student = result;
                    EmpruntFrame frame = new EmpruntFrame();
                    frame.show();
                }
            }
        });
    }

    private Boolean valider(String name, String titre){
        JOptionPane optionPane = new JOptionPane();
        if(name.trim().length() == 0){
            optionPane.showMessageDialog(null,titre+" is required required !","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
