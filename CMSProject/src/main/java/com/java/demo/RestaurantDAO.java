package com.java.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO {

	Connection connection;
	PreparedStatement pst;
	public List<Restaurant> showRestaurant() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from restaurant";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		Restaurant restaurant = null;
		while(rs.next()) {
			restaurant = new Restaurant();
			restaurant.setRid(rs.getInt("restaurantid"));
			restaurant.setRname(rs.getString("restaurantname"));
			restaurant.setCity(rs.getString("city"));
			restaurant.setBranch(rs.getString("branch"));
			restaurant.setEmail(rs.getString("email"));
			restaurant.setContactNo(rs.getString("contactnumber"));
			restaurantList.add(restaurant);
		}
		return restaurantList;
	}
	
	public Restaurant searchRestaurant(int restaurantId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from restaurant where restaurantid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, restaurantId);
		ResultSet rs = pst.executeQuery();
		Restaurant restaurant = null;
		if(rs.next()) {
			restaurant = new Restaurant();
			restaurant.setRid(rs.getInt("restaurantid"));
			restaurant.setRname(rs.getString("restaurantname"));
			restaurant.setCity(rs.getString("city"));
			restaurant.setBranch(rs.getString("branch"));
			restaurant.setEmail(rs.getString("email"));
			restaurant.setContactNo(rs.getString("ContactNumber"));
		}
		return restaurant;
		
	}
}
 