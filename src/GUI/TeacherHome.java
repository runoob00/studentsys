package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TeacherHome extends JFrame implements ActionListener{
	private JButton check=new JButton("查看信息");
	
	
	
	
      public TeacherHome(){
    	  this.setTitle("请假系统");
    	  this.setLayout(null);
      	  setLocation(650,300); 
  		  setSize(520,400);
  		  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  		  check.setBounds(180,180,100,30);
  		  this.add(check);
  		  check.addActionListener(this);
  		  this.setVisible(true);
      }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==check){
			new pijiaUI(); 
		}
		
	}
    
}
