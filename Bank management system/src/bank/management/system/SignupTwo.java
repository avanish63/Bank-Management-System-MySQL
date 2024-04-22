package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;




public class SignupTwo extends JFrame  implements ActionListener {
    JLabel details,religion,category,income,edu,quali,occupation,pan,aadhar,senior,ea;
    JTextField tf1,tf2;
    JComboBox b1,b2,b3,b4,b5;
    JButton next;
    JRadioButton yes,no,y,n;
    String formno;
    
    
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("New Application-Page 2");
        getContentPane().setBackground(Color.WHITE);
        
        details = new JLabel("Page 2: Additional Details");
        details.setFont(new Font("Raleway",Font.BOLD,28));
        details.setBounds(280,30,400,50);
        add(details);
        
        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String valreligion[] = {"Hindu","Muslim","Sikh","Christain","Other"};
        b1 = new JComboBox(valreligion);
        b1.setBounds(300,140,400,30);
        b1.setBackground(Color.white);
        add(b1);
        
        
        category= new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        
        String valcat[] = {"General","OBC","SC","ST","Other"};
        b2 = new JComboBox(valcat);
        b2.setBounds(300,190,400,30);
        b2.setBackground(Color.white);
        add(b2);
        
        income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String valinc[] = {"<75,000","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        b3 = new JComboBox(valinc);
        b3.setBounds(300,240,200,30);
        b3.setBackground(Color.white);
        add(b3);
        
        edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,290,200,30);
        add(edu);
        
        quali = new JLabel("Qualification:");
        quali.setFont(new Font("Raleway",Font.BOLD,20));
        quali.setBounds(100,315,200,30);
        add(quali);
        
        String valEdu[] = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Other"};
        b4 = new JComboBox(valEdu);
        b4.setBounds(300,315,400,30);
        b4.setBackground(Color.white);
        add(b4);
        
        occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        
        String valOcc[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        b5 = new JComboBox(valOcc);
        b5.setBounds(300,390,100,30);
        b5.setBackground(Color.white);
        add(b5);
      
        pan = new JLabel("Pan No.:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        tf1 = new JTextField();
        tf1.setFont(new Font("Raleway",Font.BOLD,16));
        tf1.setBounds(300,440,400,30);
        add(tf1);
        
        aadhar = new JLabel("Aadhar:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);
        
        tf2 = new JTextField();
        tf2.setFont(new Font("Raleway",Font.BOLD,16));
        tf2.setBounds(300,490,400,30);
        add(tf2);
        
        senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,540,200,30);
        add(senior);
        
        yes = new JRadioButton("YES");
        yes.setBounds(300,540,60,30);
        add(yes);
        no = new JRadioButton("NO");
        no.setBounds(380,540,60,30);
        add(no);
        ButtonGroup sc = new ButtonGroup();
        sc.add(yes);
        sc.add(no);
       
        
        ea = new JLabel("Existing Account:");
        ea.setFont(new Font("Raleway",Font.BOLD,20));
        ea.setBounds(100,590,200,30);
        add(ea);
        
        y = new JRadioButton("YES");
        y.setBounds(300,590,60,30);
        add(y);
        n = new JRadioButton("NO");
        n.setBounds(380,590,60,30);
        add(n);
        ButtonGroup acc = new ButtonGroup();
        acc.add(yes);
        acc.add(no);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,20));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String sreligion = (String)b1.getSelectedItem();
        String scategory= (String)b2.getSelectedItem();
        String sincome = (String)b3.getSelectedItem();
        String seducation = (String)b4.getSelectedItem();
        String soccupation = (String)b5.getSelectedItem();
        
        String span = tf1.getText();
        String saadhar = tf2.getText();
        String ssenior = null;
        if(yes.isSelected()){
            ssenior = "YES";
        }
        else if(no.isSelected()){
            ssenior = "NO";
        }
        String saccount = null;
        if(y.isSelected()){
            saccount = "YES";
        }
        else if(n.isSelected()){
            saccount = "NO";
        }if(ae.getSource()==next){
        try{
            if(sreligion.equals("")){
                JOptionPane.showMessageDialog(null, "religion is Required ");
            }
            else{
                Conn c = new Conn();
                String query = "INSERT INTO signup2 VALUES"+ "('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome
                        +"','"+seducation+"','"+soccupation+"',"+ "'"
                        +span+"','"+saadhar+"','"+saccount+"','"+ssenior+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }   
        }catch(Exception e){
           System.out.println(e);
        }
     } 
    } 
    
    public static void main(String args[]){
        new SignupTwo("");
    }
}
