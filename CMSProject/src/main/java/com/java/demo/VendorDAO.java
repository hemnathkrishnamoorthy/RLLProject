package com.java.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {
	Connection connection;
	PreparedStatement pst;
    public List<Vendor> showVendor() throws ClassNotFoundException, SQLException{
	
	List<Vendor> vendorList=new ArrayList<Vendor>();
	connection=ConnectionHelper.getConnection();
	String cmd="Select * from Vendor";
	pst=connection.prepareStatement(cmd);
	ResultSet rs=pst.executeQuery();
	Vendor vendor=null;
	while(rs.next()) {
		vendor=new Vendor();
		vendor.setVendorid(rs.getInt("vendorid"));
		vendor.setVendorname(rs.getString("vendorname"));
		vendor.setVendorstate(rs.getString("vendorstate"));
		vendor.setVendorcity(rs.getString("vendorcity"));
		vendor.setVendoremail(rs.getString("vendoremail"));
		vendor.setVendorcontactnum(rs.getString("vendormobile"));
		vendorList.add(vendor);
	}
	return vendorList;
}
public Vendor searchVendor(int vendorid) throws ClassNotFoundException, SQLException {
	connection = ConnectionHelper.getConnection();
		String cmd = "select * from vendor where vendorid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, vendorid);
		ResultSet rs = pst.executeQuery();
		Vendor vendor=null;
	while(rs.next()) {
		vendor=new Vendor();
		vendor.setVendorid(rs.getInt("vendorid"));
		vendor.setVendorname(rs.getString("vendorname"));
		vendor.setVendorstate(rs.getString("vendorstate"));
		vendor.setVendorcity(rs.getString("vendorcity"));
		vendor.setVendoremail(rs.getString("vendoremail"));
		vendor.setVendorcontactnum(rs.getString("vendormobile"));
		
	}
	
	return vendor;
	
}
}
