package info;

import java.sql.DriverManager;
import java.sql.*;

public class Connecting {
	public static Connection conn = null;
	public Connecting(){
		getconn();
	}
	public static Connection getconn()  {
		if(conn==null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("�ҵ�Mysql���ݿ���������");
			} catch (ClassNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				System.out.println("����·�����Ҳ���Mysql��������" + "������·�����Ƿ����mysql��jar��!");
			}
			try {
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Ssql" +
						"?useUnicode=true&characterEncoding=UTF8", "root", "root");
				System.out.println("�������ݿ����ӳɹ�");

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("�������ݿ�����ʧ�ܣ�");
			}
		}
		return conn;
	}
}
