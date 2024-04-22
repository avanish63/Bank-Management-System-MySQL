package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener{
    String pinnum;
    JLabel image,change,l1,l2;
    JButton b1,b2;
    JPasswordField t1,t2;
    Pin(String pinnum){
        this.pinnum = pinnum;
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        change = new JLabel("CHANGE YOUR PIN");
        change.setFont(new Font("System", Font.BOLD, 16));
        change.setForeground(Color.WHITE);
        change.setBounds(260,300,800,35);
        image.add(change);
        
        l1 = new JLabel("New PIN:");
        l1.setFont(new Font("System", Font.BOLD, 14));
        l1.setForeground(Color.WHITE);
        l1.setBounds(180,390,150,35);
        image.add(l1);
        
        l2 = new JLabel("Re-Enter New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 14));
        l2.setForeground(Color.WHITE);
        l2.setBounds(180,440,200,35);
        image.add(l2);
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setBounds(350,390,100,25);
        image.add(t1);
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        t2.setBounds(350,440,100,25);
        image.add(t2);
        
        b1 = new JButton( "Change Pin");
        b1.setBounds(355,485,150,30);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(170,485,150,30);
        b2.addActionListener(this);
        image.add(b2);
        
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            String npin = t1.getText();
            String rpin = t2.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==b1){
                if (t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                Conn c1 = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnum+"' ";
                String q2 = "update login set Pin_No = '"+rpin+"' where Pin_No = '"+pinnum+"' ";
                String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pinnum+"' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);
            
            }else if(ae.getSource()==b2){
                new Transaction(pinnum).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public static void main(String args[]){
        new Pin("");
    }
}
