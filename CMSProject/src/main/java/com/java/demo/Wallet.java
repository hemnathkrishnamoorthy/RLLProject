package com.java.demo;

public class Wallet {
       private int walletid;
       private int customerid;
       private String wallettype;
       private int amount;
	@Override
	public String toString() {
		return "Wallet [walletid=" + walletid + ", customerid=" + customerid + ", wallettype=" + wallettype
				+ ", amount=" + amount + "]";
	}
	public int getWalletid() {
		return walletid;
	}
	public void setWalletid(int walletid) {
		this.walletid = walletid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getWallettype() {
		return wallettype;
	}
	public void setWallettype(String wallettype) {
		this.wallettype = wallettype;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
       
}
