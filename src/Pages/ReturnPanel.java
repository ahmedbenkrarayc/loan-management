package Pages;

import Controllers.HistoryController;
import Controllers.ReturnController;
import Managers.DataTransfer;
import Views.HistoryFrame;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ReturnPanel extends JPanel {
    private JButton tablebtn;
    public ReturnPanel(){
        FlatDarculaLaf.setup();
        ReturnController controller = new ReturnController();
        tablebtn = new JButton("Return");
        setPreferredSize(new Dimension(1040,700));
        setBackground(new Color(0,5,24));
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        top.setBackground(new Color(0,5,24));
        top.setPreferredSize(new Dimension(1042,100));
        top.setBorder(new EmptyBorder(20,0,0,0));

        JLabel search = new JLabel("Search by Material : ");
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
        tm.addColumn("ID");
        tm.addColumn("Last Name");
        tm.addColumn("First Name");
        tm.addColumn("Email");
        tm.addColumn("Material id");
        tm.addColumn("Material");
        tm.addColumn("Date Loan");
        tm.addColumn("Duration");
        tm.addColumn("Action");
        table.setModel(tm);
        table.getColumn("Action").setCellRenderer(new ButtonRenderTable("Return"));
        table.getColumn("Action").setCellEditor(new ButtonEditorTable(new JCheckBox(),tablebtn));
        table.setPreferredSize(new Dimension(1042,700));
        JScrollPane sp = new JScrollPane(table);
        add(sp,BorderLayout.CENTER);
        controller.returnData(table,tm,null);

        tablebtn.addActionListener(e->{
            var row = ((DefaultTableModel)table.getModel()).getDataVector().elementAt(table.getSelectedRow());
            int id = (int)row.get(0);
            int mid = (int)row.get(4);
            controller.returnLoan(id,mid,table,tm);
        });

        button.addActionListener(e -> {
            controller.returnData(table,tm,material.getText());
        });
    }
}
