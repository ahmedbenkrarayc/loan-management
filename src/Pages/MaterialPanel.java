package Pages;

import Controllers.MainController;
import Managers.DataTransfer;
import Models.Material;
import Views.StudentFrame;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * inherits JPanel and displays materials
 * @author ahmed benkrara
 */
public class MaterialPanel extends JPanel {
    //MainController object
    private MainController materialData = new MainController();

    /**
     * Constructor for desplaying the view controlls
     */
    public MaterialPanel(){
        setPreferredSize(new Dimension(1040,700));
        setBackground(new Color(0,5,24));
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(40,0,0,0));

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.CENTER));
        top.setPreferredSize(new Dimension(1040,100));
        top.setMaximumSize(new Dimension(1040,100));
        top.setBackground(new Color(0,0,0,0));
        JLabel ser = new JLabel("Search : ");
        ser.setForeground(Color.white);
        ser.setFont(new Font("groovy",Font.BOLD,20));
        top.add(ser);
        JTextField search = new JTextField();
        search.setPreferredSize(new Dimension(250,25));
        search.setFont(new Font("groovy",Font.BOLD,16));
        search.setBorder(new EmptyBorder(0,4,0,4));

        top.add(search);
        this.add(top,BorderLayout.NORTH);
        JPanel pn = new JPanel();
        pn.setBackground(new Color(0,5,24));
        JPanel container = new JPanel();
        container.setBackground(new Color(0,5,24));
        container.setPreferredSize(new Dimension(1040,600));
        GridLayout grid = new GridLayout(0,5);
        grid.setVgap(10);
        grid.setHgap(10);
        container.setLayout(new FlowLayout(FlowLayout.LEFT));
        JScrollPane scrollPane = new JScrollPane(pn);;

        search.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                container.invalidate();
                container.validate();
                container.repaint();
                display(materialData.findMaterial(search.getText()),container);
            }
        });

        display(materialData.getAllMaterials(),container);
        pn.add(container);

        scrollPane.setHorizontalScrollBar(null);
        this.add(scrollPane,BorderLayout.CENTER);
    }

    /**
     * method for displaying Materials data
     * @param data
     * @param container
     */
    private void display(ArrayList<Material> data, JPanel container){
        container.removeAll();
        for(int i=0;i<data.size();i++){
            JPanel main = new JPanel();
            main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
            main.setPreferredSize(new Dimension(160,240));
            main.setBorder(new EmptyBorder(5,5,5,5));
            main.setBackground(Color.white);
            int finalI = i;
            main.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //check if material available
                    if(materialData.isAvailable(data.get(finalI).getTitre())){
                        DataTransfer.material = data.get(finalI);
                        StudentFrame student = new StudentFrame();
                        student.setVisible(true);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });

            JPanel card = new JPanel();
            JLabel label;
            card.setBackground(Color.white);
            card.setBorder(new EmptyBorder(-5,0,0,0));
            card.setPreferredSize(new Dimension(150,200));
            try{
                ImageIcon image = new ImageIcon(getClass().getResource("../"+data.get(i).getCover()));
                Image newImage = image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
                label = new JLabel(new ImageIcon(newImage));
                card.add(label);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            main.add(card);
            JPanel title = new JPanel();
            title.setBackground(new Color(0,0,0,0));
            StringBuilder builder = new StringBuilder(data.get(i).getTitre());
            builder.setLength(14);
            builder.append("...");
            JLabel tit = new JLabel(builder.toString());
            tit.setFont(new Font("groovy",Font.BOLD,16));
            tit.setBorder(new EmptyBorder(-5,0,0,0));
            tit.setForeground(Color.black);
            title.add(tit);
            main.add(title);
            container.add(main);
            container.invalidate();
            container.validate();
            container.repaint();
        }
    }
}
