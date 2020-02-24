package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class PJconfirm  extends JFrame implements ActionListener {
     
	private JButton queren=new JButton("确认");
	private  JButton cancel =new JButton("取消");
	private JTextArea text = new JTextArea();	
	
	public PJconfirm(String name1,String reason1){
		this.setTitle("确认批假");
		this.setLocation(400, 300);
		this.setSize(400, 600);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel name=new JLabel("姓名");
		JLabel reason=new JLabel("原因:");
		
		name.setBounds(50,100,60,30);
		reason.setBounds(50,150,60,30);
		text.setBounds(50,200,200,100);
		queren.setBounds(25, 350, 60, 30);
		cancel.setBounds(105, 350, 60, 30);
		this.add(reason);
		this.add(name);
		this.add(cancel);
		this.add(queren);
		this.add(text);
		this.setVisible(true);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
     
}
