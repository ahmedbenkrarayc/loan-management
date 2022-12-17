package Pages;

import Controllers.HistoryController;
import Managers.DataTransfer;
import Models.Student;
import Views.HistoryFrame;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.ui.FlatButtonUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HistoryPanel extends JPanel {
    private JButton tablebtn;
    public HistoryPanel(){
        FlatDarculaLaf.setup();
        HistoryController controller = new HistoryController();
        tablebtn = new JButton("History");
        setPreferredSize(new Dimension(1040,700));
        setBackground(new Color(0,5,24));
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        top.setBackground(new Color(0,5,24));
        top.setPreferredSize(new Dimension(1042,100));
        top.setBorder(new EmptyBorder(20,0,0,0));

        JLabel search = new JLabel("Search by email : ");
        search.setForeground(Color.white);
        search.setFont(new Font("groovy",Font.BOLD,18));
        top.add(search);

        JTextField email = new JTextField();
        email.setPreferredSize(new Dimension(250,30));
        email.setFont(new Font("groovy",Font.PLAIN,15));
        email.setForeground(Color.black);
        email.setBackground(Color.white);
        email.setBorder(new EmptyBorder(0,4,0,4));
        top.add(email);

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
        tm.addColumn("ID");
        tm.addColumn("Last Name");
        tm.addColumn("First Name");
        tm.addColumn("Email");
        tm.addColumn("Action");
        table.setModel(tm);
        table.getColumn("Action").setCellRenderer(new ButtonRenderTable("History"));
        table.getColumn("Action").setCellEditor(new ButtonEditorTable(new JCheckBox(),tablebtn));
        table.setPreferredSize(new Dimension(1042,700));
        JScrollPane sp = new JScrollPane(table);
        add(sp,BorderLayout.CENTER);
        controller.refreshStudents(table,tm,null);

        tablebtn.addActionListener(e->{
            var row = ((DefaultTableModel)table.getModel()).getDataVector().elementAt(table.getSelectedRow());
            int id = (int)row.get(0);
            DataTransfer.student_id = id;
            HistoryFrame historyFrame = new HistoryFrame();
            historyFrame.setVisible(true);
            System.out.println(id);
        });

        button.addActionListener(e -> {
            controller.refreshStudents(table,tm,email.getText());
        });
    }
}
