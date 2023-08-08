

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

        JLabel l1;
        JButton b1;
        
        public HotelManagementSystem() {
		
                setSize(1260,700);          // setContentPane(300,300,1366,390);   frame size
                setLayout(null);
                setLocation(10,20);

		// l1 = new JLabel("");
                b1 = new JButton("GO");
                
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
               
                
				
                
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/hotel3.jpg"));
                Image i3 = i1.getImage().getScaledInstance(1260, 700,Image.SCALE_SMOOTH);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                
                JLabel lid=new JLabel("HOTEL MANAGEMENT SYSTEM");
                lid.setBounds(200,50,1500,100);
                lid.setFont(new Font("serif",Font.PLAIN,50));
                lid.setForeground(Color.GREEN);
                l1.add(lid);
                
                b1.setBounds(1100,600,100,50);
		l1.setBounds(0, 0, 1260, 700);
                
                l1.add(b1);
		add(l1);
 
                b1.addActionListener(this);
                setVisible(true);
                
                while(true){
                        lid.setVisible(false); // lid =  j label
                    try{
                        Thread.sleep(500); //1000 = 1 second
                    }catch(Exception e){} 
                        lid.setVisible(true);
                    try{
                        Thread.sleep(500);
                    }catch(Exception e){}
                }
	}
        
        public void actionPerformed(ActionEvent ae){
                new Login().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                HotelManagementSystem window = new HotelManagementSystem();
                window.setVisible(true);			
	}
}
