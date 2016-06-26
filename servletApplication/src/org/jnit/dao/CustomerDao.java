package org.jnit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jnit.domain.Customer;

public class CustomerDao {
	public int insertCustomer(Customer customer){
		int noOfRowsEffected = 0;
		try {
			Connection conn = getMeAConnection();
			String query = "insert into customer(firstname, street, city, state, country, zipcode) values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, customer.getName());
			pst.setString(2, customer.getStreet());
			pst.setString(3, customer.getCity());
			pst.setString(4, customer.getState());
			pst.setString(5, customer.getCountry());
			pst.setString(6, customer.getZipCode());
			noOfRowsEffected = pst.executeUpdate();
			//System.out.println(noOfRowsEffected);
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noOfRowsEffected;
		
	}
	public Connection getMeAConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName(com.mysql.jdbc.Driver.class.getName());
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatutorial?serverTimezone=CST", "root", "R@man1611");
		return conn;
	}
	public List<Customer> fetchCustomerbyCity(String city) {
		
		List<Customer>customers = new ArrayList<>();
		try {
			Connection conn = getMeAConnection();
			String query = "select * from customer where city = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, city);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Customer cust = new Customer();
				cust.setCity(rs.getString("city"));
				cust.setName(rs.getString("firstname"));
				cust.setCustomerId(rs.getInt("customerId"));
				cust.setStreet(rs.getString("street"));
				cust.setState(rs.getString("state"));
				cust.setCountry(rs.getString("country"));
				customers.add(cust);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
		
	}
public List<Customer> fetchCustomerbyState(String state) {
		
		List<Customer>customers = new ArrayList<>();
		try {
			Connection conn = getMeAConnection();
			String query = "select * from customer where state = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, state);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Customer cust = new Customer();
				cust.setCity(rs.getString("city"));
				cust.setName(rs.getString("firstname"));
				cust.setCustomerId(rs.getInt("customerId"));
				cust.setStreet(rs.getString("street"));
				cust.setState(rs.getString("state"));
				cust.setCountry(rs.getString("country"));
				customers.add(cust);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
		
	}

}
