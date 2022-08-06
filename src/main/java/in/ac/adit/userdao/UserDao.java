package in.ac.adit.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.ac.adit.user.User;

public class UserDao {
	final static String URL="jdbc:mysql://localhost:3306/loginsystem_db";
	final static String USERNAME="root";
	final static String PASSWORD="";
	private Connection connection=null;
	private PreparedStatement pstmt=null;
	
	public UserDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean signUp(User user) {
		try {
			pstmt=connection.prepareStatement("insert into loginsystem (name,email,password,cpassword) values(?,?,?,?)");
			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getEmail());
			pstmt.setString(3,user.getPassword());
			pstmt.setString(4,user.getCpassword());
			pstmt.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean login(User userlogin) {
		try {
			pstmt=connection.prepareStatement("select email,password from loginsystem where email=? AND password=?");
			pstmt.setString(1,userlogin.getEmail());
			pstmt.setString(2,userlogin.getPassword());
			pstmt.executeQuery();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
}
