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
	JLabel title = new JLabel("��ӭ��½���ϵͳ ");
	JLabel name = new JLabel("�û�����");
	JLabel password = new JLabel("��	  �룺");
	public static JTextField nameTxt = new JTextField(20);
	public static JPasswordField passwTxt = new JPasswordField(20);
	JButton login = new JButton("��½");
	JButton cannle = new JButton("ȡ��");
	JButton appear = new JButton("��ʾ����");
	ButtonGroup gb = new ButtonGroup();
	JRadioButton stu = new JRadioButton("ѧ��");
	JRadioButton tea = new JRadioButton("��ʦ");
	JRadioButton manager = new JRadioButton("����Ա");
	public ImageIcon background;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new UserLogin();
	}
   public UserLogin(){
	    setLayout(null);
		
		setTitle("�д��Ϸ����ϵͳ");
		setLocation(650,300); 
		setSize(520,400);
		title.setBounds(160,10,300,70);
		title.setFont(new Font("����", Font.BOLD, 20));
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

		login.setBorderPainted(false);		//ȥ����ť�ı߿������
		login.setBackground(Color.WHITE); //����ɫ
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
		Image temp=background.getImage().getScaledInstance(lab3.getWidth(),lab3.getHeight(),Image.SCALE_DEFAULT);   //ͼƬ����****
		background = new ImageIcon(temp);  
		lab3.setIcon(background);			
		add(lab3);
	   
	   
   }
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==login&&!stu.isSelected()&&!tea.isSelected()&&!manager.isSelected()){			//********************����ѡ�����
		Toolkit.getDefaultToolkit().beep();   //��������
		JOptionPane.showMessageDialog(null,"����ѡ���½���!");
		}
	else if(e.getSource()==login&&stu.isSelected())  						//********************ѧ����½
		{
		int  i = new Login().Login(1);
			if(i==1){
				Toolkit.getDefaultToolkit().beep();   //��������
				JOptionPane.showMessageDialog(null,"��½�ɹ�!");		
				new StudentHome();
				setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this, "��¼ʧ��\r\n��ȷ��ID������", "��ʾ",JOptionPane.ERROR_MESSAGE);
				nameTxt.setText("");
				passwTxt.setText("");
			}
		}
	else if(e.getSource()==login&&tea.isSelected())  						//********************��ʦ ��½
		{
		int  i = new Login().Login(2);
			if(i==1){
				Toolkit.getDefaultToolkit().beep();   //��������
				JOptionPane.showMessageDialog(null,"��½�ɹ�!");	
				new TeacherHome();
				setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this, "��¼ʧ��\r\n��ȷ��ID������", "��ʾ",JOptionPane.ERROR_MESSAGE);
				nameTxt.setText("");
				passwTxt.setText("");
			}
		}
	else if(e.getSource()==login&&manager.isSelected())  						//********************����Ա ��½
	{
		int  i = new Login().Login(3);
		if(i==1){
			Toolkit.getDefaultToolkit().beep();   //��������
			JOptionPane.showMessageDialog(null,"��½�ɹ�!");	
			new ManagerHome();
			setVisible(false);
		}else{
			JOptionPane.showMessageDialog(this, "��¼ʧ��\r\n��ȷ��ID������", "��ʾ",JOptionPane.ERROR_MESSAGE);
			nameTxt.setText("");
			passwTxt.setText("");
		}
	}
	if(e.getSource()==cannle){
		Toolkit.getDefaultToolkit().beep();   //��������
		nameTxt.setText("");
	 	passwTxt.setText("");
	}
	if(e.getSource()==appear){
		 if(appear.getText().compareTo("��ʾ����")==0){
			 UserLogin.passwTxt.setEchoChar('\0');
			 appear.setText("��������");
			 
	       }
	       else{
	    	   appear.setText("��ʾ����");
	    	   UserLogin.passwTxt.setEchoChar('*');
	       } 
	}
}


		
		
	

	

}

