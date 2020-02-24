package GUI;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import info.Connecting;

public class Insert {
	static PreparedStatement stmt = null;
	static ResultSet rs = null;
	static String sql = null; 
	public void AddMess(String []context,String re2) throws  SQLException{
		try{
		sql="insert into user(id,text,result) values(?,?,?)";
		stmt = Connecting.getconn().prepareStatement(sql);
		stmt.setString(1,context[2]);
		stmt.setString(2,context[1]);
		stmt.setString(3,re2);
		stmt.executeUpdate();
		JOptionPane.showMessageDialog(null,"提交成功");	
	}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void Update(Object object)throws SQLException{
		
		 String yes =new String("yes");
		System.out.println("500"+object);
         try{
        	 System.out.println("800"+object);
        	 sql="update user set result= ?    where id= ? ";
        	 stmt = Connecting.getconn().prepareStatement(sql);
        
			 stmt.setString(1,yes);
			 stmt.setObject(2,object);
        	 stmt.executeUpdate();
        	 JOptionPane.showMessageDialog(null,"批假成功");	
        	 
         }catch(SQLException e){
 			e.printStackTrace();
 		}
		
	}
	public boolean result(){
		boolean result=false;
		
		try{
			sql="select result from user where id=  '"+UserLogin.nameTxt.getText()+"' ";
			 stmt = Connecting.getconn().prepareStatement(sql);
			 rs=stmt.executeQuery();
			
			 while(rs.next()){
			 String DR=rs.getString(1);
			 if(DR.equals("yes")){
			    result=true;
				return result;
			}
			 }
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	
}
