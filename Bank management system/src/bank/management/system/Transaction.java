package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transaction extends JFrame implements ActionListener{
    
    JLabel image,text;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinnum;
    Transaction(String pinnum){
        this.pinnum = pinnum;
        setLayout(null);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        b1 = new JButton("Deposit");
        b1.setBounds(160,415,150,30);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Cash Withdraw");
        b2.setBounds(355,415,150,30);
        b2.addActionListener(this);
        image.add(b2);
        
        b3 = new JButton("Fast Cash");
        b3.setBounds(160,450,150,30);
        b3.addActionListener(this);
        image.add(b3);
        
        b4 = new JButton("Mini Statement");
        b4.setBounds(355,450,150,30);
        b4.addActionListener(this);
        image.add(b4);
        
        b5 = new JButton("Pin Change");
        b5.setBounds(160,485,150,30);
        b5.addActionListener(this);
        image.add(b5);
        
        b6 = new JButton("Balance Enquiry");
        b6.setBounds(355,485,150,30);
        b6.addActionListener(this);
        image.add(b6);
        
        b7 = new JButton("Exit");
        b7.setBounds(355,520,150,30);
        b7.addActionListener(this);
        image.add(b7);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b7){
            System.exit(0);
        }else if(ae.getSource() == b1){
            setVisible(false);
            new Deposit(pinnum).setVisible(true);
        }else if(ae.getSource() == b2){
            setVisible(false);
            new Withdraw(pinnum).setVisible(true);
        }else if(ae.getSource() == b3){
            setVisible(false);
            new Fastcash(pinnum).setVisible(true);
        }else if(ae.getSource() == b4){
            new MiniStatement(pinnum).setVisible(true);
        }else if(ae.getSource() == b5){
            setVisible(false);
            new Pin(pinnum).setVisible(true);
        }else if(ae.getSource() == b6){
            setVisible(false);
            new BalanceInquiry(pinnum).setVisible(true);
        }
    }
    
    
    
    public static void main(String args[]){
           new Transaction("");
           
    }
}
