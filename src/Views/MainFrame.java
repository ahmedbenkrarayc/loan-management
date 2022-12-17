package Views;

import Managers.DataTransfer;
import Pages.*;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        super();
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0,5,24));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1040,700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        JMenuBar bar = new JMenuBar();
        bar.setBackground(Color.white);
        bar.setForeground(Color.black);
        JMenu menu = new JMenu("Loans");
        JMenuItem loans = new JMenuItem("Add a loan");
        loans.addActionListener(e->{
            getContentPane().remove(0);
            getContentPane().add(new MaterialPanel());
            refresh();
        });
        menu.add(loans);
        bar.add(menu);
        JMenu menu1 = new JMenu("Consultation");
        JMenuItem history = new JMenuItem("History");
        history.addActionListener(e->{
            getContentPane().remove(0);
            getContentPane().add(new HistoryPanel());
            refresh();
        });
        menu1.add(history);
        JMenuItem statistics = new JMenuItem("Statistics");
        statistics.addActionListener(e->{
            getContentPane().remove(0);
            getContentPane().add(new StatisticsPanel());
            refresh();
        });
        menu1.add(statistics);
        JMenuItem overdue = new JMenuItem("Overdue loans");
        overdue.addActionListener(e->{
            getContentPane().remove(0);
            getContentPane().add(new OverdelayPanel());
            refresh();
        });
        menu1.add(overdue);
        JMenuItem sensitive = new JMenuItem("Delay sensitive loans");
        sensitive.addActionListener(e->{
            getContentPane().remove(0);
            getContentPane().add(new SensitivePanel());
            refresh();
        });
        menu1.add(sensitive);
        bar.add(menu1);

        JMenu menu2 = new JMenu("Returns");
        JMenuItem returns = new JMenuItem("Add a return");
        returns.addActionListener(e->{
            getContentPane().remove(0);
            getContentPane().add(new ReturnPanel());
            refresh();
        });
        menu2.add(returns);
        bar.add(menu2);
        getContentPane().add(new MaterialPanel());
        //getContentPane().add(new HistoryPanel());
        //getContentPane().add(new ReturnPanel());
        //getContentPane().add(new OverdelayPanel());
        //getContentPane().add(new SensitivePanel());
        //getContentPane().add(new StatisticsPanel());

        this.setJMenuBar(bar);
        DataTransfer.main = this;
    }

    private void refresh(){
        getContentPane().invalidate();
        getContentPane().validate();
        getContentPane().repaint();
    }
}