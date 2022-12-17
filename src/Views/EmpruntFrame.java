package Views;

import Controllers.EmpruntController;
import Managers.DataTransfer;
import Models.Emprunt;
import Models.Material;
import Models.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import java.util.Date;

/**
 * a small frame for the last step of adding a loan
 * @author ahmed benkrara
 */
public class EmpruntFrame extends JFrame {

    /**
     * a constructor to add controls
     */
    public EmpruntFrame(){
        super();

        EmpruntController controller = new EmpruntController();
        this.getContentPane().setLayout(null);
        this.setResizable(false);
        JPanel container = new JPanel();
        container.setSize(new Dimension(400,300));
        container.setBackground(new Color(0,5,24));
        container.setBorder(new EmptyBorder(30,0,20,0));

        this.getContentPane().setBackground(new Color(0,5,24));
        JLabel text = new JLabel("Duration :");
        text.setFont(new Font("groovy",Font.BOLD,18));
        text.setForeground(Color.white);
        container.add(text);

        JTextField duration = new JTextField();
        duration.setPreferredSize(new Dimension(200,30));
        duration.setMaximumSize(new Dimension(200,30));
        duration.setBorder(new EmptyBorder(0,0,0,0));
        duration.setFont(new Font("groovy",Font.PLAIN,18));
        container.add(duration);

        JLabel separ = new JLabel();
        separ.setBorder(new EmptyBorder(15,200,0,200));
        container.add(separ);

        JButton borrow = new JButton("Borrow Now");
        borrow.setBorder(new EmptyBorder(8,40,8,40));
        borrow.setBackground(Color.white);
        borrow.setForeground(Color.black);
        borrow.setFocusPainted(false);
        container.add(borrow);

        this.getContentPane().add(container);

        this.setSize(new Dimension(400,200));

        borrow.addActionListener(e->{
            try{
                if(Integer.parseInt(duration.getText().trim()) > 0){
                    //emprunt
                    if(controller.emprunter(new Emprunt(new Date(),null,Integer.parseInt(duration.getText().trim()),DataTransfer.material, DataTransfer.student))){
                        DataTransfer.studentframe.dispose();
                        this.dispose();
                        DataTransfer.main.setVisible(true);
                    }
                }else{
                    new JOptionPane().showMessageDialog(null,"Duration should be greater than 0 !","Error",JOptionPane.ERROR_MESSAGE);
                    duration.setText("");

                }
            }catch(NumberFormatException ex){
                new JOptionPane().showMessageDialog(null,"Duration should be a valid number !","Error",JOptionPane.ERROR_MESSAGE);
                duration.setText("");
            }
        });
    }


}
