package info;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Search {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String sql = null; 
	private Object[][]  context= new Object[100][100];
	public Object[][] getname() {
		// TODO Auto-generated method stub
		sql="select id,text from user  ";
		try{
	
			stmt = Connecting.getconn().prepareStatement(sql);
			rs = stmt.executeQuery();
			int i=0;
			while (rs.next()) {
				
				context[i][0] = rs.getObject(1)+"";
				context[i][1] = rs.getObject(2)+"";
				System.out.println("10"+context[i][0]);
				System.out.println("10"+context[i][1]);
				i++;
				
			} 
			

		}catch(SQLException e){
			e.printStackTrace();
		}

		return context;
	}

	
	
	
	
	

}
