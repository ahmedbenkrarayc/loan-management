package Views;

import Managers.DataTransfer;
import Pages.StudentPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * student frame that contains student panel and listens on closing event to display main on closing
 * @author ahmed benrkara
 */
public class StudentFrame extends JFrame {
    /**
     * a constructor for displaying controls
     */
    public StudentFrame(){
        super();
        DataTransfer.main.setVisible(false);
        DataTransfer.studentframe = this;
        this.setResizable(false);
        this.setTitle("Add a student");
        this.getContentPane().setBackground(new Color(0,5,24));
        this.setSize(1040,700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        getContentPane().add(new StudentPanel());
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                DataTransfer.main.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }
}
