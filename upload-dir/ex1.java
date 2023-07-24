/**
 * @(#)ex1.java
 *
 *
 * @author 
 * @version 1.00 2019/11/30
 */

import javax.swing.JOptionPane;
import java.awt.*;  
import javax.swing.*;
import java.awt.event.*;

public class ex1  extends JFrame  implements ActionListener {
JLabel label ;
JButton btn1,btn2,btn3,btn4;
public ex1(){
this.setTitle("Tp3 Ex1 ");
this.setSize(850,350);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
    this.setLocationRelativeTo(null);


JPanel p1 = new JPanel();

p1.setLayout(new GridLayout(4,1));


btn1 = new JButton("Nature");
btn1.addActionListener(this);
// btn1.setBounds(10,10,100,20);
btn2 = new JButton("Tree");
btn2.addActionListener(this);
btn3 = new JButton("Flower");
btn3.addActionListener(this);
btn4 = new JButton("Sky");
btn4.addActionListener(this);


p1.add(btn1);
p1.add(btn2);
p1.add(btn3);
p1.add(btn4);

// this.getContentPane().add(p1);

JPanel p2 = new JPanel();
 label = new JLabel(new ImageIcon("nature.jpg"));

p2.add(label);
// this.getContentPane().add(p2);

JPanel p = new JPanel();

p.setLayout(new GridLayout(1,2));

p.add(p1);
p.add(p2);
this.setContentPane(p);
this.setVisible(true);

}

public void actionPerformed(ActionEvent e) {
       
        if  (e.getSource()==btn1){
            System.out.println("btn1 : natrure");
            ImageIcon icon = new ImageIcon("nature.jpg");
            label.setIcon(icon);}
       else if(e.getSource()==btn2){
        System.out.println("btn2 : Tree");
        ImageIcon icon = new ImageIcon("tree.jpg");
            label.setIcon(icon);
       }
       else if(e.getSource()==btn3){
        System.out.println("btn3 : flower");
        ImageIcon icon = new ImageIcon("flower.jpg");
            label.setIcon(icon);
       }
       else if(e.getSource()==btn4){
        System.out.println("btn4 : sky");
        ImageIcon icon = new ImageIcon("sky.jpg");
            label.setIcon(icon);
       }
}
}

