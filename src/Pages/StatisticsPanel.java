package Pages;

import Controllers.SensitiveController;
import Controllers.StatisticsController;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatisticsPanel extends JPanel {
    public StatisticsPanel(){
        FlatDarculaLaf.setup();
        StatisticsController controller = new StatisticsController();
        setPreferredSize(new Dimension(1040,700));
        setBackground(new Color(0,5,24));
        setLayout(new BorderLayout());
        JPanel left = new JPanel();
        left.setBorder(new EmptyBorder(0,0,10,0));
        left.setLayout(new BoxLayout(left,BoxLayout.Y_AXIS));
        left.setBackground(new Color(0,5,24));
        left.setPreferredSize(new Dimension(521,200));

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.setBorder(new EmptyBorder(50,0,0,0));
        searchPanel.setPreferredSize(new Dimension(521,100));
        searchPanel.setBackground(new Color(0,5,24));

        JLabel search = new JLabel("Search by email : ");
        search.setForeground(Color.white);
        search.setFont(new Font("groovy",Font.BOLD,15));
        searchPanel.add(search);

        JTextField email = new JTextField();
        email.setPreferredSize(new Dimension(200,25));
        email.setFont(new Font("groovy",Font.PLAIN,15));
        email.setForeground(Color.black);
        email.setBackground(Color.white);
        email.setBorder(new EmptyBorder(0,4,0,4));
        searchPanel.add(email);

        JButton button = new JButton("Search");
        button.setBorder(new EmptyBorder(0,0,0,0));
        button.setBackground(Color.white);
        button.setFocusPainted(false);
        button.setForeground(Color.black);
        button.setPreferredSize(new Dimension(100,25));
        searchPanel.add(button);

        left.add(searchPanel);
        controller.plotchart(left,null);
        button.addActionListener(e ->  {
            controller.plotchart(left,email.getText());
        });
        add(left,BorderLayout.WEST);

        JPanel right = new JPanel();
        right.setLayout(new FlowLayout());
        right.setBackground(new Color(0,5,24));
        right.setPreferredSize(new Dimension(521,200));
        right.setBorder(new EmptyBorder(0,20,0,20));
        add(right,BorderLayout.EAST);

        JPanel pie = new JPanel();
        pie.setPreferredSize(new Dimension(521,220));
        pie.setBackground(new Color(0,5,24));
        right.add(pie);

        controller.piechart(right);
    }
}
