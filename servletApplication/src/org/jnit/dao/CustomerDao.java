package org.jnit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CustomerDao {
	public static void insertCustomer(Customer customer){
		Connection conn = getMeAConnection();
		String query = "insert into customer(name, street, city, state, country, zipcode) values(?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1, customer.getName());
		pst.setString(1, customer.getStreet());
		pst.setString(1, customer.getCity());
		pst.setString(1, customer.getState());
		pst.setString(1, customer.getCountry());
		pst.setString(1, customer.getZip());
		int noOfRowsEffected = pst.executeUpdate();
		System.out.println(noOfRowsEffected);
		pst.close();
		conn.close();
	}
	public static Connection getMeAConnection()
	{
		Connection conn = DriverManager.getConnection(arg0);
		return conn;
	}

}
