package CRUD;

import java.sql.*;

import Database.DBConnection;

public class Add_Value {
	
	public static void Invite_Account(String email, String userType) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		String password = "P@ssw0rd";
		
		try {
			String query ="INSERT INTO account.users "
					 + "(email, password, userType) "
					 + "VALUES (?,?,?)";
			ps=connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, userType);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (USERS)");
			
		}
		
	}
	
	public static void Brand(String brand) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO inventory.brand "
					 + "(brand) "
					 + "VALUES (?)";
			ps=connection.prepareStatement(query);
			ps.setString(1, brand);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Brand)");
			
		}
		
	}

	public static void Category(String category) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO inventory.category "
					 + "(category) "
					 + "VALUES (?)";
			ps=connection.prepareStatement(query);
			ps.setString(1, category);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Brand)");
			
		}
		
	}	

	public static void Product(String name, int quantity, float price, String brand, String category) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO inventory.product "
					 + "(name, quantity, price, brand, category) "
					 + "VALUES (?,?,?,?,?)";
			
			ps=connection.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, quantity);
			ps.setFloat(3, price);
			ps.setString(4, brand);
			ps.setString(5, category);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Product)");
			
		}
		
	}	
	
	public static void Create_Serial(String name) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="CREATE TABLE `serialnumber`.`"+ name +"` (\r\n" + 
					"    `tag` INT AUTO_INCREMENT,\r\n" + 
					"    `name` VARCHAR(30),\r\n" + 
					"    `serialNumber` VARCHAR(30),\r\n" + 
					"    KEY (`tag`)\r\n" + 
					")";

			ps=connection.prepareStatement(query);
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in Add_Value(serial)");
			
		}
		
	}	
	
	public static void Create_Demand(String name) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO demand.product (name, quantity) VALUES ('"+ name +"', '0')";

			ps=connection.prepareStatement(query);
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in Add_Value(Create_Demand)");
			
		}
		
	}	
	
	public static void Serial_Number(String name, String serialNumber) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO serialnumber.`"+ name +"` "
					 + "(serialNumber, name) "
					 + "VALUES (?,?)";
			
			ps=connection.prepareStatement(query);
			ps.setString(1, serialNumber);
			ps.setString(2, name);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (SerialNumber)");
			
		}
		
	}

	public static void Order(String clientName, String contactNumber, float total, float finalTotal, String location) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO inventory.order "
					 + "(clientName, contactNumber, total, finalTotal, location, incharge) "
					 + "VALUES (?,?,?,?,?,?)";
			
			ps=connection.prepareStatement(query);
			ps.setString(1, clientName);
			ps.setString(2, contactNumber);
			ps.setFloat(3, total);
			ps.setFloat(4, finalTotal);
			ps.setString(5, location);
			ps.setString(6, "Pending");
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Order)");
			
		}
		
	}

	public static void Client(String clientName, String newProduct, int newQuantity) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO client.`"+ clientName +"` "
					 + "(clientName, product, quantity) "
					 + "VALUES (?,?,?)";
			
			ps=connection.prepareStatement(query);
			ps.setString(1, clientName);
			ps.setString(2, newProduct);
			ps.setInt(3, newQuantity);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Client)");
			
		}
		
	}

	public static void Demand(String newProduct) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="UPDATE demand.product\r\n" + 
					"SET quantity = quantity + '1'\r\n" + 
					"WHERE name ='"+ newProduct +"';";
			
			ps=connection.prepareStatement(query);			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Client)");
			
		}
		
	}
	
	public static void Create_Client(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="CREATE TABLE `client`.`"+ clientName +"` (\r\n" + 
					"    `tag` INT AUTO_INCREMENT ,\r\n" + 
					"    `date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\r\n" + 
					"    `clientName` VARCHAR(30),\r\n" + 
					"    `product` VARCHAR(30),\r\n" + 
					"    `quantity` INT,\r\n" + 
					"    key(`tag`)\r\n" + 
					")";

			ps=connection.prepareStatement(query);
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in Add_Value(Create_Client)");
			
		}
		
	}	
	
	public static void Quantity(int left, String productName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="UPDATE inventory.product\r\n" + 
					"SET quantity = '"+ left +"'\r\n" + 
					"WHERE name = '"+ productName +"';";

			ps=connection.prepareStatement(query);
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in Add_Value(Create_Client)");
			
		}
		
	}	
	
	public static void Create_Schema(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="CREATE SCHEMA `"+ clientName +"`;";

			ps=connection.prepareStatement(query);
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in Add_Value(Create_Schema)");
			
		}
		
	}
	
	public static void Transfer_Serial(String clientName, String productName, int productQuantity, int left) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="CREATE TABLE `"+ clientName +"`.`"+ productName +"`\r\n" + 
					"SELECT tag, serialnumber\r\n" + 
					"FROM serialnumber.`"+ productName +"` \r\n" + 
					"WHERE tag > '"+ left +"' && tag <= '"+ productQuantity +"' ;";

			ps=connection.prepareStatement(query);
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in Add_Value(Transfer_Serial)");
			
		}
		
	}
	
	public static void Delete_Serial(String productName, int productQuantity, int left) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="DELETE FROM serialnumber.`"+ productName +"`\r\n" + 
					"WHERE tag > '"+ left +"' && tag <= '"+ productQuantity +"';";

			ps=connection.prepareStatement(query);
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in Add_Value(Delete_Serial)");
			
		}
		
	}	
	
	public static void New_Quantity(String name, int quantity, int quanquan) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="UPDATE inventory.product SET QUANTITY = '"+ quanquan +"' + '"+ quantity +"' WHERE NAME='"+ name +"';";

			ps=connection.prepareStatement(query);
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in Add_Value(Create_Client)");
			
		}
		
	}	

	public static void Quanquan(int quanquan, String name) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO quanquan.quan (quanquan,name) VALUES('"+ quanquan +"','"+ name +"')";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Client)");
			
		}
		
	}

	public static void OnGoing(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO inventory.ongoing\r\n" + 
					"SELECT * FROM inventory.order\r\n" + 
					"WHERE clientName='"+ clientName +"';";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (OnGoing)");
			
		}
		
	}

	public static void QCPassed(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO inventory.qcpassed\r\n" + 
					"SELECT * FROM inventory.ongoing\r\n" + 
					"WHERE clientName='"+ clientName +"';";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (QCPassed)");
			
		}
		
	}

	public static void ForRelease(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO inventory.forrelease\r\n" + 
					"SELECT * FROM inventory.qcpassed\r\n" + 
					"WHERE clientName='"+ clientName +"';";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (ForRelease)");
			
		}
		
	}

	public static void Archive(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO inventory.archive \r\n" + 
					"SELECT * FROM inventory.product WHERE name='"+ clientName +"';";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (ForRelease)");
			
		}
		
	}

	public static void Archive1(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO inventory.product \r\n" + 
					"SELECT * FROM inventory.archive WHERE name='"+ clientName +"';";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (ForRelease)");
			
		}
		
	}

	public static void ArchiveDelete(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="DELETE FROM inventory.product WHERE name = '"+ clientName +"'";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (ForRelease)");
			
		}
		
	}

	public static void ArchiveDelete1(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="DELETE FROM inventory.archive WHERE name = '"+ clientName +"'";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (ForRelease)");
			
		}
		
	}


	public static void OnGoing_Delete(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="Delete FROM inventory.order\r\n" + 
					"WHERE clientName='"+ clientName +"';";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (OnGoing_Delete)");
			
		}
		
	}

	public static void QCPassed_Delete(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="Delete FROM inventory.ongoing\r\n" + 
					"WHERE clientName='"+ clientName +"';";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (QCPassed_Delete)");
			
		}
		
	}

	public static void ForRelease_Delete(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="Delete FROM inventory.qcpassed\r\n" + 
					"WHERE clientName='"+ clientName +"';";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (ForRelease_Delete)");
			
		}
		
	}

	public static void Delivered(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO inventory.delivered\r\n" + 
					"SELECT * FROM inventory.forrelease\r\n" + 
					"WHERE clientName='"+ clientName +"';";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Delivered)");
			
		}
		
	}

	public static void Delivered_Delete(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="Delete FROM inventory.forrelease\r\n" + 
					"WHERE clientName='"+ clientName +"';";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Delivered_Delete)");
			
		}
		
	}

	public static void Ongoing_Incharge(String clientName, String username) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="UPDATE inventory.ongoing\r\n" + 
					"SET incharge = '"+ username +"'\r\n" + 
					"WHERE clientName='"+ clientName +"';";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Ongoing_Incharge)");
			
		}
		
	}

	public static void ChangeAccount(String username) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		try {
			String query ="UPDATE account.users\r\n" + 
					"SET userType = 'fdg'\r\n" + 
					"WHERE username = '"+ username +"';";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Ongoing_Incharge)");
			
		}
		
	}

	public static void DeleteAccount(String username) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		try {
			String query ="INSERT INTO account.delete\r\n" + 
					"SELECT * FROM account.users WHERE username ='"+ username +"'";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Ongoing_Incharge)");
			
		}
		
	}

	public static void Delete_Account(String username) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="DELETE FROM account.users WHERE username = '"+ username +"'";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (ForRelease)");
			
		}
		
	}

	public static void ChangeAccount1(String name) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="UPDATE account.users\r\n" + 
					"SET userType = 'po'\r\n" + 
					"WHERE name = '"+ name +"';";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Ongoing_Incharge)");
			
		}
		
	}

	public static void ChangeAccount2(String contactNumber) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="UPDATE account.users\r\n" + 
					"SET userType = 'qcg'\r\n" + 
					"WHERE contactNumber = '"+ contactNumber +"';";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Ongoing_Incharge)");
			
		}
		
	}

	public static void Add_Accounts(String email, String name, String username, String password, String contactNumber) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String query ="INSERT INTO account.incharge (name, email, username, password, contactNumber) \r\n" + 
					"VALUES('"+ name +"', '"+ email +"', '"+ username +"','"+ password +"', '"+ contactNumber +"');";
			
			ps=connection.prepareStatement(query);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			
			System.out.print("Error in CRUD.Add_Value (Delivered)");
			
		}
		
	}
	
}
