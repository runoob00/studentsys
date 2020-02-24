package info;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;

import GUI.UserLogin;

public class Login  {
	 java.sql.Statement stmt = null;
	public  int Login(int s) {
		
			
		
		ResultSet rs = null;
		String sel = null;
		if(s==1)
			 sel = "SELECT*FROM student WHERE id = '"+UserLogin.nameTxt.getText()
			 	+"'and password = '"+UserLogin.passwTxt.getText()+"'";
		else if(s==2)
			 sel = "SELECT*FROM teacher WHERE id = '"+UserLogin.nameTxt.getText()
			 	+"'and password = '"+UserLogin.passwTxt.getText()+"'";
		else if(s==3)
			 sel = "SELECT*FROM manager WHERE id = '"+UserLogin.nameTxt.getText()
			 	+"'and password = '"+UserLogin.passwTxt.getText()+"'";
		try {
			stmt = Connecting.getconn().prepareStatement(sel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs = stmt.executeQuery(sel);
			
			while(rs.next()){
				return 1;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("µÇÂ½Ê§°Ü");
		}
		return 0;
	}

}
