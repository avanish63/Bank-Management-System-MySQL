package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class SignupThree extends JFrame implements ActionListener {
    JLabel l1,type,card,pin,number,pnumber,cdetail,pdetail,services;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7; 
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("Page-3");
        getContentPane().setBackground(Color.WHITE);
        
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,28));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setBackground(Color.white);
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,150,20);
        add(r1);
        
        r2 = new JRadioButton("Current Account");
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(100,220,150,20);
        add(r2);
        
        r3 = new JRadioButton("Fixed Deposit Account");
        r3.setBackground(Color.WHITE);
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(350,180,200,20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBackground(Color.WHITE);
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,220,250,20);
        add(r4);
        
        ButtonGroup acctype = new ButtonGroup();
        acctype.add(r1);
        acctype.add(r2);
        acctype.add(r3);
        acctype.add(r4);
        
        card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        cdetail = new JLabel("Your 16-digit card number");
        cdetail.setFont(new Font("Raleway",Font.BOLD,12));
        cdetail.setBounds(100,330,200,30);
        add(cdetail);
        number = new JLabel("xxx xxx xxx 4528");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(300,300,200,30);
        add(number);
        
        pin = new JLabel("Card Number:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        pdetail = new JLabel("Your 4-digit card number");
        pdetail.setFont(new Font("Raleway",Font.BOLD,12));
        pdetail.setBounds(100,400,200,30);
        add(pdetail);
        pnumber = new JLabel("xxxx");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(300,370,200,30);
        add(pnumber);
        
        services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,200,30);
        add(services);
        
        c1 = new JCheckBox("ATM card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,14));
        c1.setBounds(100,500,200,20);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,14));
        c2.setBounds(350,500,200,20);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,14));
        c3.setBounds(100,550,200,20);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,14));
        c4.setBounds(350,550,200,20);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,14));
        c5.setBounds(100,600,200,20);
        add(c5);
        
        c6 = new JCheckBox("E-statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,14));
        c6.setBounds(350,600,200,20);
        add(c6);
        
        c7 = new JCheckBox("I herby declares above entered details are correct to the best of my knowldge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        c7.setBounds(100,610,800,20);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,16));
        submit.setBounds(280,640,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,16));
        cancel.setBounds(400,640,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(850,820);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            String account = null;
            if(r1.isSelected()){
                account = "Saving Account";
            }else if(r2.isSelected()){
                account = "Current Account";
            }else if(r3.isSelected()){
                account = "Fixed Deposit Account";
            }else if(r4.isSelected()){
                account = "Recurring Deposit Account";
            }
            
            Random random = new Random();
            String cardnum = ""+Math.abs((random.nextLong()%9000L)+5040936000000000L);
            String pinnum = ""+Math.abs((random.nextLong()%9000L)+1000L);
            
            String required = "";
            if(c1.isSelected()){
                required = required +"ATM card";
            }
            if(c2.isSelected()){
                required = required +" Internet Banking";
            }
            if(c3.isSelected()){
                required = required +" Mobile Banking";
            }
            if(c4.isSelected()){
                required = required +" Email & SMS alerts";
            }
            if(c5.isSelected()){
                required = required +" Cheque Book";
            }
            if(c6.isSelected()){
                required = required +" E-Statements";
            }
            
            try{
                if(account.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }
                else{
                    Conn c = new Conn();
                    String query1 = "INSERT INTO signup3 VALUES"+ "('"+formno+"','"+account+"','"+cardnum+"','"+pinnum +"','"+required+"')";
                    String query2 = "INSERT INTO login VALUES"+ "('"+formno+"','"+cardnum+"','"+pinnum+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null,"Card Number "+cardnum+"\nPIN "+pinnum);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            setVisible(false);
            new Deposit(pinnum).setVisible(true);
            
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    
    public static void main(String args[]){
        new SignupThree("");
    }
}
