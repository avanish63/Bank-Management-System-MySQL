package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{ 
    JLabel label,card,pin,text;
    JButton login,signup,clear;
    JTextField tf1;
    JPasswordField pf1;
    Login(){
        setTitle("Automatic Teller Machine");
        setLayout(null);
        //Icon
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        getContentPane().setBackground(Color.WHITE);
        
        text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        card = new JLabel("Card No : ");
        card.setFont(new Font("Raleway",Font.BOLD,28));
        card.setBounds(120,150,200,40);
        add(card);
        
        tf1 = new JTextField();
        tf1.setBounds(300,150,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);
        
        pin = new JLabel("PIN : ");
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(120,200,200,40);
        add(pin);
        
        pf1 = new JPasswordField();
        pf1.setBounds(300,220,230,30);
        pf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(pf1);
        
        login = new JButton("LOGIN");
        login.setBounds(300,300,100,30);
        login.setFont(new Font("Arial",Font.BOLD,14));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setFont(new Font("Arial",Font.BOLD,14));
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setFont(new Font("Arial",Font.BOLD,14));
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        setSize(800,480);
        setLocation(350,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            tf1.setText("");
            pf1.setText("");
        }
        else if(ae.getSource()==login){
            Conn c = new Conn();
            String cardnum = tf1.getText();
            String pinnum = pf1.getText();
            String query = "SELECT *from  login WHERE Cardno = '"+cardnum+"'and Pin_No = '"+pinnum+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnum).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup){
            setVisible(false);  
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Login();
             }
}

