package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class StudentHome extends JFrame implements ActionListener  {
	private JButton TJ=new JButton("�ύ");
	private JRadioButton QJ=new JRadioButton("���");
	private JButton check=new JButton("���ٲ鿴");
	private JTextArea text = new JTextArea();		
	
    public StudentHome(){
    	this.setTitle("���ϵͳ");
    	this.setLayout(null);
    	setLocation(650,300); 
		setSize(520,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		TJ.setBounds(120,290,100,30);
		QJ.setBounds(160,80,100,30);
		check.setBounds(240, 290, 100, 30);
		text.setBounds(100,150,340,100);
		JLabel PJ=new JLabel("����:");
		PJ.setBounds(100,110,100,30);
		
		
		TJ.addActionListener(this);
		check.addActionListener(this);
   	    text.setLineWrap(true);    //�����Զ����й��� 
   	    text.setWrapStyleWord(true);  // ������в����ֹ���
   	    
   	    this.add(QJ);
		this.add(TJ);
		this.add(check);
		this.add(text);
		this.add(PJ);

		this.setVisible(true);
		
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		String[] context = new String[100];
		// TODO Auto-generated method stub
		context[1]=text.getText();
		String re2=new String("no");
		context[2]=UserLogin.nameTxt.getText();
		
		if(!QJ.isSelected()&&e.getSource()==TJ){
			JOptionPane.showMessageDialog(this, "�빴ѡ��ٿ�");
		}
		else if(QJ.isSelected()&&text.getText().equals("")&&e.getSource()==TJ){
			
			JOptionPane.showMessageDialog(this, "����������", "��ʾ",JOptionPane.ERROR_MESSAGE);
		}
			
		else if(QJ.isSelected()&&!text.getText().equals("")&&e.getSource()==TJ){
		
			try {
				new Insert().AddMess(context,re2);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==check){
			//new Insert().result();
			boolean id_result=new Insert().result();
			if(id_result==true){
				JOptionPane.showMessageDialog(this, "�Ѿ�����");
			}
			else{
				JOptionPane.showMessageDialog(this, "��δ����");
			}
			
		}
		
		
		}
	}


