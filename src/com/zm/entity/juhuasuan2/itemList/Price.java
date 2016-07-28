package com.zm.entity.juhuasuan2.itemList;

import java.util.List;
public class Price{	private String expandMoney;	private String origPrice;	private boolean longerPrice;	private String discount;	private boolean hangtagPrice;	private String frontMoney;	private List<String> priceParts;	private String actPrice;
	public String getExpandMoney() {		return this.expandMoney;	}
	public void setExpandMoney(String expandMoney) {		this.expandMoney = expandMoney;	}
	public String getOrigPrice() {		return this.origPrice;	}
	public void setOrigPrice(String origPrice) {		this.origPrice = origPrice;	}
	public boolean getLongerPrice() {		return this.longerPrice;	}
	public void setLongerPrice(boolean longerPrice) {		this.longerPrice = longerPrice;	}
	public String getDiscount() {		return this.discount;	}
	public void setDiscount(String discount) {		this.discount = discount;	}
	public boolean getHangtagPrice() {		return this.hangtagPrice;	}
	public void setHangtagPrice(boolean hangtagPrice) {		this.hangtagPrice = hangtagPrice;	}
	public String getFrontMoney() {		return this.frontMoney;	}
	public void setFrontMoney(String frontMoney) {		this.frontMoney = frontMoney;	}
	public List<String> getPriceParts() {		return this.priceParts;	}
	public void setPriceParts(List<String> priceParts) {		this.priceParts = priceParts;	}
	public String getActPrice() {		return this.actPrice;	}
	public void setActPrice(String actPrice) {		this.actPrice = actPrice;	}
	public Price() {}
	public Price(String expandMoney, String origPrice, boolean longerPrice, String discount, boolean hangtagPrice, String frontMoney, List<String> priceParts, String actPrice){
		super();		this.expandMoney = expandMoney;		this.origPrice = origPrice;		this.longerPrice = longerPrice;		this.discount = discount;		this.hangtagPrice = hangtagPrice;		this.frontMoney = frontMoney;		this.priceParts = priceParts;		this.actPrice = actPrice;
	}
	public String toString() {
		return "Price [expandMoney = " + expandMoney + ", origPrice = " + origPrice + ", longerPrice = " + longerPrice + ", discount = " + discount + ", hangtagPrice = " + hangtagPrice + ", frontMoney = " + frontMoney + ", priceParts = " + priceParts + ", actPrice = " + actPrice + "]";	}
}