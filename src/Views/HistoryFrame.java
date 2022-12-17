package Views;

import Controllers.HistoryController;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HistoryFrame extends JFrame {
    public HistoryFrame(){
        HistoryController controller = new HistoryController();
        FlatDarculaLaf.setup();
        setLayout(new BorderLayout());
        setSize(new Dimension(500,300));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setResizable(false);
        JTable table = new JTable();
        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("Material");
        tm.addColumn("Loan Date");
        tm.addColumn("Duration");
        tm.addColumn("Return Date");
        table.setModel(tm);
        JScrollPane sp = new JScrollPane(table);
        add(sp,BorderLayout.CENTER);
        controller.loanHistory(table,tm);
    }
}
