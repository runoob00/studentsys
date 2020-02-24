package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


import info.Search;

public class pijiaUI extends JFrame implements ActionListener{
	 
	   private JButton check1=new JButton("确认");
	   private JTable tableResult = null;
		DefaultTableModel tableModelDefault = null;
		private JTextField JY=new JTextField(20);		
		
	 
       public pijiaUI(){
    	  
    	    Object[] name = {"姓名","理由"};
    	    Object[][] rowData=new Object[100][100];
    	    rowData = new Search().getname();
    	    tableModelDefault = new DefaultTableModel( rowData,name);
    		tableResult = new JTable(tableModelDefault);
    
    		
    		Vector<String[]> dataVector=new Vector<String[]>();
    		((DefaultTableModel) tableResult.getModel()).addRow(dataVector);//添加空白行
    		
    		int count=tableResult.getRowCount();//获得总行数
    		tableResult.requestFocus();
    		tableResult.setRowSelectionInterval(count-1, count-1);//最后一行获得焦点
    		//Vector<Vector> vector =new Vector<Vector>();
    		//vector=tableModelDefault.getDataVector();
    		//Vector<Vector> v =vector;
    		int selectedRow = tableResult.getSelectedRow();
    		
    		//v.get(getX()).elementAt(0);
    		
    		//for(Vector v : vector){
    		//if(selectedRow==1){
    		//System.out.println("180"+v.get(selectedRow).elementAt(0));
    			//System.out.println("120"+v.get	(getX()).elementAt(0));
    		//}
    		//}
    		//Object k=v.get(selectedRow).elementAt(0);
    	    //JY.setText((String) k);
    	    //System.out.println("180"+v.get(selectedRow).elementAt(0));
            /*for(int i=0;i<count;i++){
            	if(selectedRow==i){
            		Object k=v.get(selectedRow).elementAt(0);
            		JY.setText((String) k);
            		System.out.println("180"+v.get(selectedRow).elementAt(0));
            		return;
            		
            	}
            	continue;
            }*/
    		
    	    JY.addActionListener(this);
    	  
    		tableResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//一次只能选择一次
    	    
    		JScrollPane scrollPane = new JScrollPane(tableResult);
    	    this.setTitle("请假系统");
    		this.setLocation(400, 300);
    		this.setSize(400, 600);
    		this.setLayout(null);
   		    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   		    JPanel upper = new JPanel();
 		    JPanel middle = new JPanel();
 		 
 			upper.setLocation(0, 0);
 			upper.setSize(400, 100);
 			middle.setLocation(0, 100);
 			middle.setSize(400, 400);
 			
 			upper.setLayout(new FlowLayout());
 			JLabel text=new JLabel("欢迎使用");
 			upper.add(text);
 			
 			upper.add(new JLabel());
 			check1.setBounds(160, 50, 60, 30);
 			check1.addActionListener(this);
 			
 			this.add(upper);
 			this.add(check1);
 			middle.setLayout(new BorderLayout());
 			
   	       

   		    this.setVisible(true);
   		    middle.add(scrollPane);
 		    this.add(middle);
 		    
 		    
 		    
    	   
    	   
  
       }
	



	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Vector<Vector> vector =new Vector<Vector>();
		vector=tableModelDefault.getDataVector();
		
		Vector<Vector> v =vector;;
	
		
		if(e.getSource()==check1){
			int selectedRow = tableResult.getSelectedRow();
			int count=tableResult.getRowCount();
		
			if (selectedRow < 0) {
				JOptionPane.showMessageDialog(this, "请选择");
			} 
			
			
			else  {
				for(int i=0;i<count;i++){
				if(selectedRow==i){
				Object k=v.get(i).elementAt(0);
	    	    JY.setText((String) k);
	    	    break;
				}
				continue;
				}
				
				System.out.println("120"+JY.getText());
					
					try {
						new Insert().Update( JY.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
			
	}



	
}
