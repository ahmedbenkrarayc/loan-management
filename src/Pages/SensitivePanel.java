package Pages;

import Controllers.OverdelayController;
import Controllers.SensitiveController;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * delay sensitive loans panel
 * @author ahmed
 */
public class SensitivePanel extends JPanel {
    /**
     * constructor for displaying controls
     */
    public SensitivePanel(){
        FlatDarculaLaf.setup();
        SensitiveController controller = new SensitiveController();
        setPreferredSize(new Dimension(1040,700));
        setBackground(new Color(0,5,24));
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        top.setBackground(new Color(0,5,24));
        top.setPreferredSize(new Dimension(1042,100));
        top.setBorder(new EmptyBorder(20,0,0,0));

        //Search by Material or Email
        JLabel search = new JLabel("Search : ");
        search.setForeground(Color.white);
        search.setFont(new Font("groovy",Font.BOLD,18));
        top.add(search);

        JTextField material = new JTextField();
        material.setPreferredSize(new Dimension(250,30));
        material.setFont(new Font("groovy",Font.PLAIN,15));
        material.setForeground(Color.black);
        material.setBackground(Color.white);
        material.setBorder(new EmptyBorder(0,4,0,4));
        top.add(material);

        JButton button = new JButton("Search");
        button.setBorder(new EmptyBorder(0,0,0,0));
        button.setBackground(Color.white);
        button.setFocusPainted(false);
        button.setForeground(Color.black);
        button.setPreferredSize(new Dimension(150,30));
        top.add(button);
        add(top,BorderLayout.NORTH);

        JTable table = new JTable();
        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("Last Name");
        tm.addColumn("First Name");
        tm.addColumn("Email");
        tm.addColumn("Material");
        tm.addColumn("Date Loan");
        tm.addColumn("Duration");
        tm.addColumn("Remainning days");
        table.setModel(tm);
        table.setPreferredSize(new Dimension(1042,700));
        JScrollPane sp = new JScrollPane(table);
        add(sp,BorderLayout.CENTER);
        controller.fillTable(table,tm,null);

        button.addActionListener(e -> {
            controller.fillTable(table,tm,material.getText());
        });
    }
}
