package org.jnit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDao {
	public static void insertCustomer(Customer customer){
		Connection conn = getMeAConnection();
		String query = "insert into customer(name, street, city, state, country, zipcode) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, customer.getName());
			pst.setString(1, customer.getStreet());
			pst.setString(1, customer.getCity());
			pst.setString(1, customer.getState());
			pst.setString(1, customer.getCountry());
			pst.setString(1, customer.getZipCode());
			int noOfRowsEffected = pst.executeUpdate();
			System.out.println(noOfRowsEffected);
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static Connection getMeAConnection()
	{
		Connection conn = DriverManager.getConnection(arg0);
		return conn;
	}

}
