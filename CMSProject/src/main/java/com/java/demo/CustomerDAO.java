package com.java.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	Connection connection;
	PreparedStatement pst;
    public List<Customer> showCustomer() throws ClassNotFoundException, SQLException{
	
	List<Customer> customerList=new ArrayList<Customer>();
	connection=ConnectionHelper.getConnection();
	String cmd="Select * from Customer1";
	pst=connection.prepareStatement(cmd);
	ResultSet rs=pst.executeQuery();
	Customer customer=null;
	while(rs.next()) {
		customer=new Customer();
		customer.setCustomerid(rs.getInt("customerid"));
		customer.setCustomername(rs.getString("customername"));
		customer.setCustomerstate(rs.getString("customerstate"));
		customer.setCustomercity(rs.getString("customercity"));
		customer.setCustomeremail(rs.getString("customeremail"));
		customer.setCustomercontactnum(rs.getString("customermobile"));
		customerList.add(customer);
	}
	return customerList;
}
public Customer searchCustomer(int customerid) throws ClassNotFoundException, SQLException {
	connection = ConnectionHelper.getConnection();
		String cmd = "select * from customer1 where customerid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, customerid);
		ResultSet rs = pst.executeQuery();
	Customer customer=null;
	while(rs.next()) {
		customer=new Customer();
		customer.setCustomerid(rs.getInt("customerid"));
		customer.setCustomername(rs.getString("customername"));
		customer.setCustomerstate(rs.getString("customerstate"));
		customer.setCustomercity(rs.getString("customercity"));
		customer.setCustomeremail(rs.getString("customeremail"));
		customer.setCustomercontactnum(rs.getString("customermobile"));
	}
	return customer;
	
	
}
}
