package CRUD;

import java.sql.*;
import java.util.*;

import Database.DBConnection;
import Database.Variable_Product;
import Database.Variable_Category;
import Database.Variable_Brand;
import Database.Variable_Order;
import Database.Variable;
import Database.Variable_Serial;
import Database.Variable_Purchasing;
import Database.Variable_Product1;

public class Get_Value {
	
	public List<Variable> Inventory_gettingValue() {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable> list = new ArrayList<Variable>();
		
		try {
			String query ="SELECT *, DATE_FORMAT(receiveTime, '%m/%d/%Y') AS dateReceive FROM inventorymanagementsystem.inventory";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {
				
				Variable obj_Variable = new Variable();

				obj_Variable.setProductTag(rs.getInt("productTag"));
				obj_Variable.setDateReceive(rs.getString("dateReceive"));
				obj_Variable.setSerialNumber(rs.getString("serialNumber"));
				obj_Variable.setBrand(rs.getString("brand"));
				obj_Variable.setProductModel(rs.getString("productModel"));
				obj_Variable.setProductDescription(rs.getString("productDescription"));
				
				list.add(obj_Variable);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Data Displayed");
			
		}
		
		return list;
		
	}
	
	public List<Variable_Category> Status() {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Category> list = new ArrayList<Variable_Category>();
		
		try {
			String query ="SELECT * FROM inventory.status";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			while (rs.next()) {
				
				Variable_Category obj_Variable_Category = new Variable_Category();
				
				obj_Variable_Category.setStatus(rs.getString("status"));
				
				list.add(obj_Variable_Category);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (Status)");
			
		}
		
		return list;
		
	}
	
	public List<Variable_Brand> Brand() {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Brand> list = new ArrayList<Variable_Brand>();
		
		try {
			String query ="SELECT *, DATE_FORMAT(date, '%m/%d/%Y') AS dateReceive FROM inventory.brand";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {
				
				Variable_Brand obj_Variable_Brand = new Variable_Brand();

				obj_Variable_Brand.setDateReceive(rs.getString("dateReceive"));
				obj_Variable_Brand.setBrand(rs.getString("brand"));
				
				list.add(obj_Variable_Brand);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (Brand)");
			
		}
		
		return list;
		
	}
	
	public List<Variable_Category> Category() {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Category> list = new ArrayList<Variable_Category>();
		
		try {
			String query ="SELECT *, DATE_FORMAT(date, '%m/%d/%Y') AS dateReceive FROM inventory.category";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {
				
				Variable_Category obj_Variable_Category = new Variable_Category();

				obj_Variable_Category.setDateReceive(rs.getString("dateReceive"));
				obj_Variable_Category.setCategory(rs.getString("category"));
				
				list.add(obj_Variable_Category);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (Brand)");
			
		}
		
		return list;
		
	}	
	
	public List<Variable_Product> Product() {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Product> list = new ArrayList<Variable_Product>();
		
		try {
			String query ="SELECT *, DATE_FORMAT(date, '%m/%d/%Y') AS dateReceive, FORMAT(price, 2) AS newprice FROM inventory.product";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {
				
				Variable_Product obj_Variable_Product = new Variable_Product();

				obj_Variable_Product.setTag(rs.getString("tag"));
				obj_Variable_Product.setDateReceive(rs.getString("dateReceive"));
				obj_Variable_Product.setName(rs.getString("name"));
				obj_Variable_Product.setBrand(rs.getString("brand"));
				obj_Variable_Product.setCategory(rs.getString("category"));
				obj_Variable_Product.setQuantity(rs.getInt("quantity"));
				obj_Variable_Product.setPrice(rs.getInt("price"));
				obj_Variable_Product.setNewprice(rs.getString("newprice"));
				
				list.add(obj_Variable_Product);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (Product)");
			
		}
		
		return list;
		
	}
	
	public List<Variable_Product> Archive() {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Product> list = new ArrayList<Variable_Product>();
		
		try {
			String query ="SELECT *, DATE_FORMAT(date, '%m/%d/%Y') AS dateReceive, FORMAT(price, 2) AS newprice FROM inventory.archive";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {
				
				Variable_Product obj_Variable_Product = new Variable_Product();

				obj_Variable_Product.setTag(rs.getString("tag"));
				obj_Variable_Product.setDateReceive(rs.getString("dateReceive"));
				obj_Variable_Product.setName(rs.getString("name"));
				obj_Variable_Product.setBrand(rs.getString("brand"));
				obj_Variable_Product.setCategory(rs.getString("category"));
				obj_Variable_Product.setQuantity(rs.getInt("quantity"));
				obj_Variable_Product.setPrice(rs.getInt("price"));
				obj_Variable_Product.setNewprice(rs.getString("newprice"));
				
				list.add(obj_Variable_Product);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (Product)");
			
		}
		
		return list;
		
	}
	
	public List<Variable_Product> Product_Demand() {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Product> list = new ArrayList<Variable_Product>();
		
		try {
			String query ="SELECT * FROM demand.product";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {
				
				Variable_Product obj_Variable_Product = new Variable_Product();

				obj_Variable_Product.setTag(rs.getString("tag"));
				obj_Variable_Product.setName(rs.getString("name"));
				obj_Variable_Product.setTag(rs.getString("tag"));
				obj_Variable_Product.setQuantity(rs.getInt("quantity"));
				
				list.add(obj_Variable_Product);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (Product_Demand)");
			
		}
		
		return list;
		
	}
	
	public List<Variable_Order> Order() {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Order> list = new ArrayList<Variable_Order>();
		
		try {
			String query ="SELECT *, DATE_FORMAT(date, '%m/%d/%Y') AS dateReceive, FORMAT(finalTotal, 2) AS newprice FROM inventory.order";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {
				
				Variable_Order obj_Variable_Order = new Variable_Order();

				obj_Variable_Order.setTag(rs.getString("tag"));
				obj_Variable_Order.setDateReceive(rs.getString("dateReceive"));
				obj_Variable_Order.setClientName(rs.getString("clientName"));
				obj_Variable_Order.setNewprice(rs.getString("newprice"));
				obj_Variable_Order.setContactNumber(rs.getString("contactNumber"));
				obj_Variable_Order.setTotal(rs.getFloat("total"));
				obj_Variable_Order.setFinalTotal(rs.getFloat("finalTotal"));
				obj_Variable_Order.setLocation(rs.getString("location"));
				obj_Variable_Order.setIncharge(rs.getString("incharge"));
				
				list.add(obj_Variable_Order);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (Product)");
			
		}
		
		return list;
		
	}
	
	public List<Variable_Serial> Serial(String name) {
      	//System.out.println(name);
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Serial> list = new ArrayList<Variable_Serial>();
		
		try {
			String query ="SELECT serialNumber FROM serialnumber.`"+ name +"` ";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {

				Variable_Serial obj_Variable_Serial = new Variable_Serial();

				obj_Variable_Serial.setSerialNumber(rs.getString("serialNumber"));
				
				list.add(obj_Variable_Serial);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (Serial)");
			
		}
		
		return list;
		
	}
	
	public Variable_Purchasing Purchasing(String clientName) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Variable_Purchasing obj_Variable_Purchasing = new Variable_Purchasing();
		
		try {
			String query ="SELECT *, DATE_FORMAT(date, '%m/%d/%Y') AS dateReceive, FORMAT(finalTotal, 2) AS newPrice FROM inventory.order WHERE clientName='"+ clientName +"'";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			while (rs.next()) {

				obj_Variable_Purchasing.setTag(rs.getInt("tag"));
				obj_Variable_Purchasing.setDateReceive(rs.getString("dateReceive"));
				obj_Variable_Purchasing.setClientName(rs.getString("clientName"));
				obj_Variable_Purchasing.setContactNumber(rs.getString("contactNumber"));
				obj_Variable_Purchasing.setLocation(rs.getString("location"));
				obj_Variable_Purchasing.setTotal(rs.getInt("total"));
				obj_Variable_Purchasing.setFinalTotal(rs.getInt("finalTotal"));	
				obj_Variable_Purchasing.setNewPrice(rs.getString("newPrice"));				
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("ERROR");
			
		}
		
		return obj_Variable_Purchasing;
		
	}
	
	public List<Variable_Order> Product(String clientName) {
      	//System.out.println(name);
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Order> list = new ArrayList<Variable_Order>();
		
		try {
			String query ="SELECT * FROM client.`"+ clientName +"`;";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {

				Variable_Order obj_Variable_Order = new Variable_Order();

				obj_Variable_Order.setClientName(rs.getString("clientName"));
				obj_Variable_Order.setProduct(rs.getString("product"));
				obj_Variable_Order.setQuantity(rs.getInt("quantity"));
				
				list.add(obj_Variable_Order);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (Counter)");
			
		}
		
		return list;
		
	}
	
	public List<Variable_Order> Product_Serial(String clientName, String product) {
      	//System.out.println(name);
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Order> list = new ArrayList<Variable_Order>();
		
		try {
			String query ="SELECT * FROM `"+ clientName +"`.`"+ product +"`;";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {

				Variable_Order obj_Variable_Order = new Variable_Order();

				obj_Variable_Order.setSerialNumber(rs.getString("serialNumber"));
				
				list.add(obj_Variable_Order);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (Counter)");
			
		}
		
		return list;
		
	}
	
	public List<Variable_Order> Product_Category(String product) {
      	//System.out.println(name);
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Order> list = new ArrayList<Variable_Order>();
		
		try {
			String query ="SELECT category FROM inventory.product where name = '"+ product +"';";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {

				Variable_Order obj_Variable_Order = new Variable_Order();

				obj_Variable_Order.setCategory(rs.getString("category"));
				
				list.add(obj_Variable_Order);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (Counter)");
			
		}
		
		return list;
		
	}
	
	public Variable_Product1 View_Product(String name) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Variable_Product1 obj_Variable_Product1 = new Variable_Product1();
		
		try {
			String query ="SELECT *, DATE_FORMAT(date, '%m/%d/%Y') AS dateReceive, FORMAT(price, 2) AS newPrice FROM inventory.product WHERE name='"+ name +"'";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			while (rs.next()) {

				obj_Variable_Product1.setTag(rs.getInt("tag"));
				obj_Variable_Product1.setDateReceive(rs.getString("dateReceive"));
				obj_Variable_Product1.setName(rs.getString("name"));
				obj_Variable_Product1.setNewprice(rs.getString("newPrice"));
				obj_Variable_Product1.setBrand(rs.getString("brand"));
				obj_Variable_Product1.setCategory(rs.getString("category"));	
				obj_Variable_Product1.setQuantity(rs.getInt("quantity"));				
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("ERROR");
			
		}
		
		return obj_Variable_Product1;
		
	}
	
	public Variable_Product1 Get_Quan(String name) {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Variable_Product1 obj_Variable_Product1 = new Variable_Product1();
		
		try {
			String query ="SELECT quanquan FROM quanquan.quan where name = '"+ name +"'";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			while (rs.next()) {
	
				obj_Variable_Product1.setQuanquan(rs.getInt("quanquan"));				
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("ERROR");
			
		}
		
		return obj_Variable_Product1;
		
	}
	
	public List<Variable_Order> OnGoing() {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Order> list = new ArrayList<Variable_Order>();
		
		try {
			String query ="SELECT *, DATE_FORMAT(date, '%m/%d/%Y') AS dateReceive, FORMAT(finalTotal, 2) AS newprice FROM inventory.ongoing";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {
				
				Variable_Order obj_Variable_Order = new Variable_Order();

				obj_Variable_Order.setTag(rs.getString("tag"));
				obj_Variable_Order.setDateReceive(rs.getString("dateReceive"));
				obj_Variable_Order.setClientName(rs.getString("clientName"));
				obj_Variable_Order.setNewprice(rs.getString("newprice"));
				obj_Variable_Order.setContactNumber(rs.getString("contactNumber"));
				obj_Variable_Order.setTotal(rs.getFloat("total"));
				obj_Variable_Order.setFinalTotal(rs.getFloat("finalTotal"));
				obj_Variable_Order.setLocation(rs.getString("location"));
				obj_Variable_Order.setIncharge(rs.getString("incharge"));
				
				list.add(obj_Variable_Order);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (OnGoing)");
			
		}
		
		return list;
		
	}
	
	public List<Variable_Order> QCPassed() {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Order> list = new ArrayList<Variable_Order>();
		
		try {
			String query ="SELECT *, DATE_FORMAT(date, '%m/%d/%Y') AS dateReceive, FORMAT(finalTotal, 2) AS newprice FROM inventory.qcpassed";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {
				
				Variable_Order obj_Variable_Order = new Variable_Order();

				obj_Variable_Order.setTag(rs.getString("tag"));
				obj_Variable_Order.setDateReceive(rs.getString("dateReceive"));
				obj_Variable_Order.setClientName(rs.getString("clientName"));
				obj_Variable_Order.setNewprice(rs.getString("newprice"));
				obj_Variable_Order.setContactNumber(rs.getString("contactNumber"));
				obj_Variable_Order.setTotal(rs.getFloat("total"));
				obj_Variable_Order.setFinalTotal(rs.getFloat("finalTotal"));
				obj_Variable_Order.setLocation(rs.getString("location"));
				obj_Variable_Order.setIncharge(rs.getString("incharge"));
				
				list.add(obj_Variable_Order);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (QCPassed)");
			
		}
		
		return list;
		
	}
	
	public List<Variable_Order> ForRelease() {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Order> list = new ArrayList<Variable_Order>();
		
		try {
			String query ="SELECT *, DATE_FORMAT(date, '%m/%d/%Y') AS dateReceive, FORMAT(finalTotal, 2) AS newprice FROM inventory.forrelease";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {
				
				Variable_Order obj_Variable_Order = new Variable_Order();

				obj_Variable_Order.setTag(rs.getString("tag"));
				obj_Variable_Order.setDateReceive(rs.getString("dateReceive"));
				obj_Variable_Order.setClientName(rs.getString("clientName"));
				obj_Variable_Order.setNewprice(rs.getString("newprice"));
				obj_Variable_Order.setContactNumber(rs.getString("contactNumber"));
				obj_Variable_Order.setTotal(rs.getFloat("total"));
				obj_Variable_Order.setFinalTotal(rs.getFloat("finalTotal"));
				obj_Variable_Order.setLocation(rs.getString("location"));
				
				list.add(obj_Variable_Order);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (Product)");
			
		}
		
		return list;
		
	}
	
	public List<Variable_Order> Delivered() {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Order> list = new ArrayList<Variable_Order>();
		
		try {
			String query ="SELECT *, DATE_FORMAT(date, '%m/%d/%Y') AS dateReceive, FORMAT(finalTotal, 2) AS newprice FROM inventory.delivered";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {
				
				Variable_Order obj_Variable_Order = new Variable_Order();

				obj_Variable_Order.setTag(rs.getString("tag"));
				obj_Variable_Order.setDateReceive(rs.getString("dateReceive"));
				obj_Variable_Order.setClientName(rs.getString("clientName"));
				obj_Variable_Order.setNewprice(rs.getString("newprice"));
				obj_Variable_Order.setContactNumber(rs.getString("contactNumber"));
				obj_Variable_Order.setTotal(rs.getFloat("total"));
				obj_Variable_Order.setFinalTotal(rs.getFloat("finalTotal"));
				obj_Variable_Order.setLocation(rs.getString("location"));
				obj_Variable_Order.setIncharge(rs.getString("incharge"));
				
				list.add(obj_Variable_Order);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (Product)");
			
		}
		
		return list;
		
	}
	
	public List<Variable_Order> QCG() {
		
		DBConnection obj_Database = new DBConnection();
		Connection connection = obj_Database.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			List<Variable_Order> list = new ArrayList<Variable_Order>();
		
		try {
			String query ="SELECT * FROM account.users";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			
			rs.afterLast();
			
			while (rs.previous()) {
				
				Variable_Order obj_Variable_Order = new Variable_Order();

				obj_Variable_Order.setContactNumber(rs.getString("contactNumber"));
				obj_Variable_Order.setEmail(rs.getString("email"));
				obj_Variable_Order.setName(rs.getString("name"));
				obj_Variable_Order.setUsername(rs.getString("username"));
				obj_Variable_Order.setPassword(rs.getString("password"));
				obj_Variable_Order.setUserType(rs.getString("userType"));
				
				list.add(obj_Variable_Order);
				
			}			
			
		}catch (Exception e) {
			
			System.out.print("Error in Get_Value (Product)");
			
		}
		
		return list;
		
	}

}
