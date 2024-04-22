package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;



public class SignupOne extends JFrame  implements ActionListener {
    JLabel formno,details,name,fname,dob,gender,email,marital,address,city,state,pc;
    JDateChooser dc;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    JButton next;
    JRadioButton m,fm,other,married,unmarried;
    
    
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);
    SignupOne(){
        setLayout(null);
        setTitle("New Application -Page 1");
        getContentPane().setBackground(Color.WHITE);
        
        formno = new JLabel("Application Form No. : "+first);
        formno.setFont(new Font("Raleway",Font.BOLD,36));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        details = new JLabel("Page 1: Personal Details");
        details.setFont(new Font("Raleway",Font.BOLD,22));
        details.setBounds(290,80,400,20);
        add(details);
        
        name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        tf1 = new JTextField();
        tf1.setFont(new Font("Raleway",Font.BOLD,16));
        tf1.setBounds(300,140,400,30);
        add(tf1);
        
        fname = new JLabel("Father's name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        tf2 = new JTextField();
        tf2.setFont(new Font("Raleway",Font.BOLD,16));
        tf2.setBounds(300,190,400,30);
        add(tf2);
        
        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dc = new JDateChooser();
        dc.setBounds(300,240,200,30);
        dc.setForeground(Color.BLACK);
        add(dc);
        
        
        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        m = new JRadioButton("Male");
        m.setBounds(300,290,80,30);
        m.setBackground(Color.white);
        add(m);
        fm = new JRadioButton("Female");
        fm.setBounds(400,290,80,30);
        fm.setBackground(Color.white);
        add(fm);
        other = new JRadioButton("Other");
        other.setBounds(500,290,80,30);
        other.setBackground(Color.white);
        add(other);
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(m);
        gendergroup.add(fm);
        gendergroup.add(other);
        
        email = new JLabel("Email Adress:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        tf3 = new JTextField();
        tf3.setFont(new Font("Raleway",Font.BOLD,16));
        tf3.setBounds(300,340,400,30);
        add(tf3);
        
        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.white);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        ButtonGroup status = new ButtonGroup();
        status.add(married);
        status.add(unmarried);
        
        address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        tf4 = new JTextField();
        tf4.setFont(new Font("Raleway",Font.BOLD,16));
        tf4.setBounds(300,440,400,30);
        add(tf4);
        
        city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        tf5 = new JTextField();
        tf5.setFont(new Font("Raleway",Font.BOLD,16));
        tf5.setBounds(300,490,400,30);
        add(tf5);
        
        state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        tf6 = new JTextField();
        tf6.setFont(new Font("Raleway",Font.BOLD,16));
        tf6.setBounds(300,540,400,30);
        add(tf6);
        
        pc = new JLabel("Pin Code:");
        pc.setFont(new Font("Raleway",Font.BOLD,20));
        pc.setBounds(100,590,200,30);
        add(pc);
        
        tf7 = new JTextField();
        tf7.setFont(new Font("Raleway",Font.BOLD,16));
        tf7.setBounds(300,590,400,30);
        add(tf7);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,20));
        next.setBounds(620,600,80,30);
        next.addActionListener(this);
        add(next);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = ""+first;
        String name = tf1.getText();
        String fname = tf2.getText();
        String dob = ((JTextField) dc.getDateEditor().getUiComponent()).getText();
        System.out.println(dob);
        String gender = null;
        if(m.isSelected()){ 
            gender = "Male";
        }else if(fm.isSelected()){ 
            gender = "Female";
        }
        else if(other.isSelected()){ 
            gender = "Other";
        }
        String email = tf3.getText();
        String marital = null;
        if(married.isSelected()){ 
            marital  = "Married";
        }else if(unmarried.isSelected()){ 
            marital= "Unmarried";
        }  
        String address = tf4.getText();
        String city = tf5.getText();
        String state = tf6.getText();
        String pincode = tf7.getText();
        if(ae.getSource()==next){
        try{
            
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required ");
            }
            else{
                Conn c = new Conn();
                String query = "INSERT INTO signup1 VALUES"+ "('"+formno+"','"+name+"','"+fname+"','"+dob+"','"
                        +gender+"','"+email+"','"+marital+"',"+ "'"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
            
        }catch(Exception e){
           System.out.println(e);
        }
        }  
    } 
    
    public static void main(String args[]){
        new SignupOne();
    }
}
