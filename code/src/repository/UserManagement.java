package repository;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.Connection;

import model.User;

import java.sql.*;

public class UserManagement {
	
	private Connection cnx ; 
	
	public UserManagement() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/authentification";
			cnx = (Connection) DriverManager.getConnection(url,"root","12345678");
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	public void addUser(User u)
	{
		try {
			PreparedStatement stmt = cnx.prepareStatement("insert into user values (?,?,?,?,?,?)");
			stmt.setInt(1, 0);
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getName());
			stmt.setString(4, u.getLastname());
			stmt.setString(5, u.getUsername());
			stmt.setString(6, u.getPassword());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public User getUser(String username, String password) {
		User u = null;
		try {
			PreparedStatement stmt = cnx.prepareStatement("select * from user where username = ? and password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet result = stmt.executeQuery();
			if(result.next()) {
				u = new User(result.getInt(1),
				result.getString(2),
				result.getString(3),
				result.getString(4),
				result.getString(5)
				);
			}	
		}
		catch (Exception e) {
			e.getMessage();
		}
		return u;
	}
	
	public boolean verifUserByUsername(String username) {
		boolean test = false ; 
		try {
			PreparedStatement stmt = cnx.prepareStatement("select * from user where username = ?");
			stmt.setString(1, username);
			ResultSet rst = stmt.executeQuery();
			if(rst.next()) {
				test = true;
				
			}
		}
		catch(Exception e ) {
			e.getMessage();
		}
		return  test ; 
	}
	
	public Vector<User> getAllUsers(){
		Vector<User> alluser = new Vector<>();
		try {
			
			PreparedStatement stmt = cnx.prepareStatement("select * from user");
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				User u = new User(result.getInt(1),
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getString(5)
						);
				alluser.add(u);
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
		return alluser;
	}
	
	public void deleteUser(String username)
	{
		try {
			PreparedStatement stmt = cnx.prepareStatement("delete from user where username = ? ");
			stmt.setString(1, username);
			stmt.executeUpdate();
			
		}
		catch(Exception e) {
			
		}
	}

}
