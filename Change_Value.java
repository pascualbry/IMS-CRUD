package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.DBConnection;

public class Change_Value {

	public void forgotPassword(String email, String password) {
		
		DBConnection obj_DBConnection = new DBConnection();
		Connection connection = obj_DBConnection.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="UPDATE account.users SET password = '"+ password +"' WHERE email = '"+ email +"'";
			ps=connection.prepareStatement(query);
			ps.executeUpdate();
					
			
		}catch (Exception e) {
			
			System.out.print("Error in Change_Value");
			
		}
		
	}

	public void New_Password(String email, String password, String name, String username, String contactNumber) {
		
		DBConnection obj_DBConnection = new DBConnection();
		Connection connection = obj_DBConnection.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="UPDATE account.users \r\n" + 
					"SET name = '"+ name +"', username = '"+ username +"', contactNumber = '"+ contactNumber +"', password = '"+ password +"'\r\n" + 
					"WHERE email = '"+ email +"'";
			ps=connection.prepareStatement(query);
			ps.executeUpdate();
					
			
		}catch (Exception e) {
			
			System.out.print("Error in Change_Value");
			
		}
		
	}

	public static void Change_Password(String email, String password) {
		
		DBConnection obj_DBConnection = new DBConnection();
		Connection connection = obj_DBConnection.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="UPDATE account.account SET password = ? WHERE email = ?";
			ps=connection.prepareStatement(query);
			ps.setString(1, password);;
			ps.setString(2, email);;
			ps.executeUpdate();
					
			
		}catch (Exception e) {
			
			System.out.print("Error in Change_Value");
			
		}
		
	}
	
}
