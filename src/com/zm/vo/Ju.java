package com.zm.vo;

public class Ju {
	private String goodsName;
    private String goodsPrice;
    private String hongbaoPrice;
    private String totalPrice;
    private String isFree;
    private String hasMoney;
    private String goodsUrl;
    
    private Integer isImportant;
    
	public Ju(String goodsName, String goodsPrice, String hongbaoPrice, String totalPrice, String isFree,
			String hasMoney, String goodsUrl, Integer isImportant) {
		super();
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.hongbaoPrice = hongbaoPrice;
		this.totalPrice = totalPrice;
		this.isFree = isFree;
		this.hasMoney = hasMoney;
		this.goodsUrl = goodsUrl;
		this.isImportant = isImportant;
	}
	public Integer getIsImportant() {
		return isImportant;
	}
	public void setIsImportant(Integer isImportant) {
		this.isImportant = isImportant;
	}
	public Ju() {
		super();
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getHongbaoPrice() {
		return hongbaoPrice;
	}
	public void setHongbaoPrice(String hongbaoPrice) {
		this.hongbaoPrice = hongbaoPrice;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getIsFree() {
		return isFree;
	}
	public void setIsFree(String isFree) {
		this.isFree = isFree;
	}
	public String getHasMoney() {
		return hasMoney;
	}
	public void setHasMoney(String hasMoney) {
		this.hasMoney = hasMoney;
	}
	public String getGoodsUrl() {
		return goodsUrl;
	}
	public void setGoodsUrl(String goodsUrl) {
		this.goodsUrl = goodsUrl;
	}
}
