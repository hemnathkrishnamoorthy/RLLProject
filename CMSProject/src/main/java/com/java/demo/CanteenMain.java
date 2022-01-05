package com.java.demo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class CanteenMain {
	
	static Scanner sc = new Scanner(System.in);
	static RestaurantDAO dao = new RestaurantDAO();
	static MenuDAO mdao = new MenuDAO();
	static CustomerDAO cdao = new CustomerDAO();
	static VendorDAO vdao = new VendorDAO();
	static WalletDAO wdao=new WalletDAO();
	
	
	public static void showVendor() {
		List<Vendor> vendor = null;
		try {
			vendor = vdao.showVendor();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Vendor id : vendor) {
			System.out.println(id);
		}
	}
	public static void searchVendor() {
		int vendorid;
		System.out.println("Enter vendor Id  ");
		vendorid = sc.nextInt();
		Vendor vendor = null;
		try {
			vendor = vdao.searchVendor(vendorid);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (vendor!=null) {
			System.out.println(vendor);
		} else {
			System.out.println("*** Record Not Found ***");
		}
		}
	public static void showCustomer() {
		List<Customer> customer = null;
		try {
			customer = cdao.showCustomer();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Customer id : customer) {
			System.out.println(id);
		}
	}
	public static void searchCustomer() {
	int customerid;
	System.out.println("Enter customer Id  ");
	customerid = sc.nextInt();
	Customer customer = null;
	try {
		customer = cdao.searchCustomer(customerid);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if (customer!=null) {
		System.out.println(customer);
	} else {
		System.out.println("*** Record Not Found ***");
	}
	}
	
	public static void showMenu() {
		List<Menu> menu = null;
		try {
			menu = mdao.showMenu();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Menu id : menu) {
			System.out.println(id);
		}
	}
	
	public static void showRestaurant() {
		List<Restaurant> rest = null;
		try {
			rest = dao.showRestaurant();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Restaurant ld : rest) {
			System.out.println(ld);
		}
	}
	public static void searchMenu() {
	int menuid;
	System.out.println("Enter menu Id  ");
	menuid = sc.nextInt();
	Menu menu = null;
	try {
		menu = mdao.searchMenu(menuid);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if (menu!=null) {
		System.out.println(menu);
	} else {
		System.out.println("*** Record Not Found ***");
	}
	}
	public static void searchRestaurant() {
	int restaurantID;
	System.out.println("Enter restaurant Id  ");
	restaurantID = sc.nextInt();
	Restaurant rest = null;
	try {
		rest = dao.searchRestaurant(restaurantID);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if (rest!=null) {
		System.out.println(rest);
	} else {
		System.out.println("*** Record Not Found ***");
	}
	}
	public static void searchWalletbycid() throws ClassNotFoundException, SQLException {
		int customerid;
		System.out.println("Enter customer Id to search wallet  ");
		customerid = sc.nextInt();
		List<Wallet> wallet = new WalletDAO().searchByCustomerId(customerid);
		System.out.println(wallet);
		
	}
	public static void searchWalletbywid() throws ClassNotFoundException, SQLException {
		int walletid;
		System.out.println("Enter wallet Id to search wallet  ");
		walletid = sc.nextInt();
		Wallet wallet = new WalletDAO().searchByWalletId(walletid);
		System.out.println(wallet);
		
	}

	public static void placeOrder() throws ClassNotFoundException, SQLException {
		Orders order = new Orders();
		System.out.println("Enter Customer Id   ");
		order.setCustomerId(sc.nextInt());
		System.out.println("Enter Vendor Id  ");
		order.setVendorId(sc.nextInt());
		System.out.println("Enter Menu Id  ");
		order.setMenuId(sc.nextInt());
		System.out.println("Enter Wallet Id  ");
		order.setWalletId(sc.nextInt());
		System.out.println("Enter Quantity Ordered  ");
		order.setQuantityOrdered(sc.nextInt());
		System.out.println("Enter Comments  ");
		order.setOrderComments(sc.next());
		OrdersDAO dao = new OrdersDAO();
		System.out.println(dao.placeOrder(order));
	}
	
	public static void acceptOrReject() throws ClassNotFoundException, SQLException {
		int vendorId;
		int orderId;
		String status;
		System.out.println("Enter Vendor Id   ");
		vendorId = sc.nextInt();
		System.out.println("Enter Order Id   ");
		orderId = sc.nextInt();
		System.out.println("Enter Status   ");
		status =sc.next();
		System.out.println(new OrdersDAO().acceptOrRejectOrder(orderId, vendorId, status));
	}
	public static void main(String[] args) throws ParseException {
		int choice;
		do {
			System.out.println(" O P T I O N S");
			System.out.println("---------------");
			System.out.println("1. show restaurant  ");
			System.out.println("2. search restaurant");
		    System.out.println("3. show menu");
		    System.out.println("4. search menu");
		    System.out.println("5. show customer");
		    System.out.println("6. search restaurant");
		    System.out.println("7. show vendor");
		    System.out.println("8. search vendor");
		    System.out.println("9. Search Wallet by C.id");
			System.out.println("10. Search Wallet by W.id");
			System.out.println("11. Place Order");
			System.out.println("12. Accept Or Reject Order");
			System.out.println("Enter Your Choice   ");
			choice = sc.nextInt();
			switch(choice) {
			case 1 : 
				showRestaurant();
				break;
			case 2 : 
				searchRestaurant();
				break;
			case 3 :
				showMenu();
			break;
			case 4 :
				searchMenu();
				break;
			case 5 :
				showCustomer();
				break;
			case 6 :
				searchCustomer();
				break;
			case 7 :
				showVendor();
				break;
			case 8 :
				searchVendor();
				break;
			case 9 :
				try {
					searchWalletbycid();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case 10 :
				try {
					searchWalletbywid();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case 11 : 
					try {
						placeOrder();
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 12 : 
					try {
						acceptOrReject();
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					break;
				}
		
		} while(choice!=13);

	}

}


