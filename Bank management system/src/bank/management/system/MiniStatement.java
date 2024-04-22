package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;



public class MiniStatement extends JFrame implements ActionListener {
    
    String pinnum;
    JButton exit;
    JLabel l1;
   MiniStatement(String pinnum){
        this.pinnum = pinnum;
        setLayout(null);
        
        l1 = new JLabel();
        l1.setBounds(20, 140, 400, 200);
        add(l1);
        
        JLabel l2 = new JLabel("Indian Bank");
        l2.setBounds(150, 20, 100, 20);
        add(l2);
        
         JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);
        
        JLabel l4 = new JLabel();
        l4.setBounds(20, 380, 300, 20);
        add(l4);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where Pin_No = '"+pinnum+"'");
            while(rs.next()){
                l3.setText("Card Number:    " + rs.getString("Cardno").substring(0, 4)
                        + "XXXXXXXX" + rs.getString("Cardno").substring(12));
            }
        }catch(Exception e){
                System.out.println(e);
        }
         try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT *FROM bank where pin = '"+pinnum+"'");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
                        +rs.getString("time")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("type") 
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")
                        + "<br><br><html>");
                if(rs.getString("type").equals("Deposit ")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            System.out.println(e);
        }
        	 
        
        exit = new JButton("Exit");
        exit.setBounds(20, 410, 100, 25);
        exit.addActionListener(this);
        add(exit);
        
        setSize(400,500);
        setLocation(20,20);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
        }
        
    }
    
    public static void main(String args[]){
        new  MiniStatement("");
    }
}
