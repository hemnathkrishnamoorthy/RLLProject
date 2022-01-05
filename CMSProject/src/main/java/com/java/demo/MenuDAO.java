package com.java.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {
      Connection connection;
      PreparedStatement pst;
      
      public List<Menu> showMenu() throws ClassNotFoundException, SQLException{
    	  List<Menu> menuList=new ArrayList<Menu>();
    	  connection=ConnectionHelper.getConnection();
    	  String cmd="select * from Menu";
    	  pst=connection.prepareStatement(cmd);
    	  ResultSet rs=pst.executeQuery();
    	  Menu menu=null;
    	  while(rs.next()) {
    		  menu=new Menu();
    		  menu.setMenuid(rs.getInt("menuid"));
    		  menu.setRestaurantid(rs.getInt("restaurantid"));
    		  menu.setItemname(rs.getString("itemname"));
    		  menu.setMenutype(rs.getString("menutype"));
    		  menu.setCalories(rs.getInt("calories"));
    		  menu.setPrice(rs.getInt("price"));
    		  menuList.add(menu);
    	  }
		return menuList;
    	  
      }
      public Menu searchMenu(int menuId) throws ClassNotFoundException, SQLException {
  		connection = ConnectionHelper.getConnection();
  		String cmd = "select * from menu where menuid=?";
  		pst = connection.prepareStatement(cmd);
  		pst.setInt(1, menuId);
  		ResultSet rs = pst.executeQuery();
  	    Menu menu=null; 
  		if(rs.next()) {
  		 menu=new Menu();
  		 menu.setMenuid(rs.getInt("menuid"));
   		  menu.setRestaurantid(rs.getInt("restaurantid"));
   		  menu.setItemname(rs.getString("itemname"));
   		  menu.setMenutype(rs.getString("menutype"));
   		  menu.setCalories(rs.getInt("calories"));
   		  menu.setPrice(rs.getInt("price"));
  		}
  		return menu;
  		
  	}
}
