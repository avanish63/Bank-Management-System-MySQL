package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BalanceInquiry extends JFrame implements ActionListener{
    String pinnum;
    JButton back;
    JLabel image;
    
    BalanceInquiry(String pinnum){
     this.pinnum = pinnum ;
     setLayout(null);
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
     
     back = new JButton("Back");
     back.setBounds(355,520,150,30);
     back.addActionListener(this);
     image.add(back);
     
     Conn c = new Conn();
     int balance = 0;     
     try{
         ResultSet rs = c.s.executeQuery("SELECT *from bank where pin = '"+pinnum+"'");          
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit ")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }catch (Exception e){
                        System.out.print(e);
            }
    JLabel label = new JLabel("Your Current Acount Balance is  Rs."+ balance);
    label.setForeground(Color.WHITE);
    label.setFont(new Font("Raleway",Font.BOLD,16));
    label.setBounds(160,400,400,30);
    
    image.add(label);
     
    
     setLocation(300,0);
     setUndecorated(true);
     setSize(900,900);
     setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()== back){
            setVisible(false);
            new Transaction(pinnum).setVisible(true);
        }
    
    
    }
    
    public static void main(String args[]){
        new BalanceInquiry("");
    }
}
