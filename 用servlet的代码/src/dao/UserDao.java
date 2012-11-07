package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	Connection conn = null;
	int userId;
	int sinaId;
	public UserDao(int userid,int sinaid){
		this.userId = userid;
		this.sinaId = sinaid;
	}
	public  void getCon(){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/webobase?useUnicode=true" +
				"&amp;characterEncoding=GBK";
		String root = "root";
		String password = "1234";
		
		try{Class.forName(driver);	
			try {
			
				conn = DriverManager.getConnection(url,root,password);
				System.out.println("数据库连接成功");
				System.out.println(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			try{
				PreparedStatement stat = conn.prepareStatement("insert userinfo(userId,sinaId)value(?,?)");
				stat.setLong(1, userId);
				stat.setLong(2, sinaId);
				stat.executeUpdate();
			}catch(SQLException e){
			}
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
