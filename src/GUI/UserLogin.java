package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.*;




import info.Login;


public class UserLogin extends JFrame implements ActionListener{
	JLabel title = new JLabel("欢迎登陆请假系统 ");
	JLabel name = new JLabel("用户名：");
	JLabel password = new JLabel("密	  码：");
	public static JTextField nameTxt = new JTextField(20);
	public static JPasswordField passwTxt = new JPasswordField(20);
	JButton login = new JButton("登陆");
	JButton cannle = new JButton("取消");
	JButton appear = new JButton("显示密码");
	ButtonGroup gb = new ButtonGroup();
	JRadioButton stu = new JRadioButton("学生");
	JRadioButton tea = new JRadioButton("教师");
	JRadioButton manager = new JRadioButton("管理员");
	public ImageIcon background;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new UserLogin();
	}
   public UserLogin(){
	    setLayout(null);
		
		setTitle("中大南方请假系统");
		setLocation(650,300); 
		setSize(520,400);
		title.setBounds(160,10,300,70);
		title.setFont(new Font("宋体", Font.BOLD, 20));
		name.setBounds(50,80,80,30);
		name.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		password.setBounds(50,120,80,30);
		password.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		nameTxt.setBounds(150,80,200,30);
		nameTxt.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
	
		passwTxt.setBounds(150,120,200,30);
		passwTxt.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
	
		appear.setBounds(360,120,90,30);
		appear.setFont(new Font(Font.DIALOG, Font.BOLD, 11));
		

		stu.setBounds(90,160,90,60);

		tea.setBounds(200,160,90,60);

		manager.setBounds(340,160,90,60);

		login.setBounds(120,240,80,40);

		login.setBorderPainted(false);		//去掉按钮的边框的设置
		login.setBackground(Color.WHITE); //背景色
		cannle.setBounds(280,240,80,40);
		gb = new ButtonGroup();
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		
		login.addActionListener(this);
		cannle.addActionListener(this);
		appear.addActionListener(this);
		
		Container c = this.getContentPane();
		c.add(title);
		c.add(name);
		c.add(password);
		c.add(nameTxt);
		c.add(passwTxt);
		c.add(appear);
		c.add(stu);
		c.add(tea);
		c.add(manager);
		gb.add(stu);
		gb.add(tea);
		gb.add(manager);
		c.add(login);
		c.add(cannle);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		background = new ImageIcon("priture/01.jpg");
		JLabel lab3 = new JLabel(background);
		lab3.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.getLayeredPane().add(lab3, new Integer(Integer.MIN_VALUE));
		background.getImage();
		Image temp=background.getImage().getScaledInstance(lab3.getWidth(),lab3.getHeight(),Image.SCALE_DEFAULT);   //图片伸缩****
		background = new ImageIcon(temp);  
		lab3.setIcon(background);			
		add(lab3);
	   
	   
   }
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==login&&!stu.isSelected()&&!tea.isSelected()&&!manager.isSelected()){			//********************优先选择身份
		Toolkit.getDefaultToolkit().beep();   //发出声音
		JOptionPane.showMessageDialog(null,"请先选择登陆身份!");
		}
	else if(e.getSource()==login&&stu.isSelected())  						//********************学生登陆
		{
		int  i = new Login().Login(1);
			if(i==1){
				Toolkit.getDefaultToolkit().beep();   //发出声音
				JOptionPane.showMessageDialog(null,"登陆成功!");		
				new StudentHome();
				setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this, "登录失败\r\n请确认ID与密码", "提示",JOptionPane.ERROR_MESSAGE);
				nameTxt.setText("");
				passwTxt.setText("");
			}
		}
	else if(e.getSource()==login&&tea.isSelected())  						//********************老师 登陆
		{
		int  i = new Login().Login(2);
			if(i==1){
				Toolkit.getDefaultToolkit().beep();   //发出声音
				JOptionPane.showMessageDialog(null,"登陆成功!");	
				new TeacherHome();
				setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this, "登录失败\r\n请确认ID与密码", "提示",JOptionPane.ERROR_MESSAGE);
				nameTxt.setText("");
				passwTxt.setText("");
			}
		}
	else if(e.getSource()==login&&manager.isSelected())  						//********************管理员 登陆
	{
		int  i = new Login().Login(3);
		if(i==1){
			Toolkit.getDefaultToolkit().beep();   //发出声音
			JOptionPane.showMessageDialog(null,"登陆成功!");	
			new ManagerHome();
			setVisible(false);
		}else{
			JOptionPane.showMessageDialog(this, "登录失败\r\n请确认ID与密码", "提示",JOptionPane.ERROR_MESSAGE);
			nameTxt.setText("");
			passwTxt.setText("");
		}
	}
	if(e.getSource()==cannle){
		Toolkit.getDefaultToolkit().beep();   //发出声音
		nameTxt.setText("");
	 	passwTxt.setText("");
	}
	if(e.getSource()==appear){
		 if(appear.getText().compareTo("显示密码")==0){
			 UserLogin.passwTxt.setEchoChar('\0');
			 appear.setText("隐藏密码");
			 
	       }
	       else{
	    	   appear.setText("显示密码");
	    	   UserLogin.passwTxt.setEchoChar('*');
	       } 
	}
}


		
		
	

	

}

