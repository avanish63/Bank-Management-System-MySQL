package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Fastcash extends JFrame implements ActionListener{
    
    JLabel image,text;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinnum;
    Fastcash(String pinnum){
        this.pinnum = pinnum;
        setLayout(null);
        setUndecorated(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Select Withdrawl Amound");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        b1 = new JButton("Rs 100");
        b1.setBounds(160,415,150,30);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Rs 500");
        b2.setBounds(355,415,150,30);
        b2.addActionListener(this);
        image.add(b2);
        
        b3 = new JButton("Rs 1000");
        b3.setBounds(160,450,150,30);
        b3.addActionListener(this);
        image.add(b3);
        
        b4 = new JButton("Rs 2000");
        b4.setBounds(355,450,150,30);
        b4.addActionListener(this);
        image.add(b4);
        
        b5 = new JButton("Rs 5000");
        b5.setBounds(160,485,150,30);
        b5.addActionListener(this);
        image.add(b5);
        
        b6 = new JButton("Rs 10000");
        b6.setBounds(355,485,150,30);
        b6.addActionListener(this);
        image.add(b6);
        
        b7 = new JButton("Back");
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
            setVisible(false);
            new Transaction(pinnum).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Date d = new Date();
                SimpleDateFormat d1 = new SimpleDateFormat("dd/MM/yy");
                String date = d1.format(d);
                SimpleDateFormat t1 = new SimpleDateFormat("hh:mm:ss");
                String time = t1.format(d);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("SELECT *from bank where pin = '"+pinnum+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit ")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=b7 && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!!!");
                    return ;
                }
                String query = "INSERT INTO bank values('"+pinnum+"','"+date+"','"+time+"','Withdraw','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs."+amount+" Withdrawed Successfully");
                   
                setVisible(false);
                new Transaction(pinnum).setVisible(true);
                }
            catch(Exception e ){
                System.out.println(e);
            }
        }
    }
    
    
    
    public static void main(String args[]){
           new Fastcash("");
           
    }
}

