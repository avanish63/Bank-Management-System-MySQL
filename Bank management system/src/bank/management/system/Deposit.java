package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class Deposit  extends JFrame implements ActionListener{
    
    JLabel image,text;
    JTextField t1;
    JButton b1,b2;
    String pinnum;
    Deposit(String pinnum){
        this.pinnum = pinnum;
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Enter the Amount to Deposit");
        text.setBounds(180,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        t1 = new JTextField();
        text.setFont(new Font("System",Font.BOLD,22));
        t1.setBounds(170,350,320,20);
        image.add(t1);
        
        b1 = new JButton("Deposit");
        b1.setBounds(355,485,150,30);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(170,485,150,30);
        b2.addActionListener(this);
        image.add(b2);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== b1){
            String amount = t1.getText();
            Date d = new Date();
            SimpleDateFormat d1 = new SimpleDateFormat("dd/MM/yy");
            String date = d1.format(d);
            SimpleDateFormat t1 = new SimpleDateFormat("hh:mm:ss");
            String time = t1.format(d);
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Amout not entered!!!");
            }else{
                try{
                Conn c = new Conn();
                String query = "INSERT INTO bank values('"+pinnum+"','"+date+"','"+time+"','Deposit ','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs."+amount+" Deposited Successfully");
                }catch(Exception e){
                    System.out.println(e);
                }
                setVisible(false);
                new Transaction(pinnum).setVisible(true);
            }
        }else if(ae.getSource()== b2){
            setVisible(false);
            new Transaction(pinnum).setVisible(true);
        }
    }
    
    
    public static void main(String args[]){
        new Deposit("");
    }
}
