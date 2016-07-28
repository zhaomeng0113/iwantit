package com.zm.entity.juhuasuan.brandList;

import java.util.List;
public class Price{	private String discount;	private boolean hasCoupon;	private List<Object> fullCuts;	private String promotion;	private Coupon coupon;
	public String getDiscount() {		return this.discount;	}
	public void setDiscount(String discount) {		this.discount = discount;	}
	public boolean getHasCoupon() {		return this.hasCoupon;	}
	public void setHasCoupon(boolean hasCoupon) {		this.hasCoupon = hasCoupon;	}
	public List<Object> getFullCuts() {		return this.fullCuts;	}
	public void setFullCuts(List<Object> fullCuts) {		this.fullCuts = fullCuts;	}
	public String getPromotion() {		return this.promotion;	}
	public void setPromotion(String promotion) {		this.promotion = promotion;	}
	public Coupon getCoupon() {		return this.coupon;	}
	public void setCoupon(Coupon coupon) {		this.coupon = coupon;	}

	public String toString() {
		return "Price [discount = " + discount + ", hasCoupon = " + hasCoupon + ", fullCuts = " + fullCuts + ", promotion = " + promotion + ", coupon = " + coupon + "]";	}
}