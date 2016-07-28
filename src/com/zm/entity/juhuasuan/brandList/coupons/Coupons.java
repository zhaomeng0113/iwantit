package com.zm.entity.juhuasuan.brandList.coupons;

import java.util.List;
public class Coupons{	private long sellerId;	private String promotion;	private String title;	private long id;	private long fazhi;	private long mianzhi;	private long type;
	public long getSellerId() {		return this.sellerId;	}
	public void setSellerId(long sellerId) {		this.sellerId = sellerId;	}
	public String getPromotion() {		return this.promotion;	}
	public void setPromotion(String promotion) {		this.promotion = promotion;	}
	public String getTitle() {		return this.title;	}
	public void setTitle(String title) {		this.title = title;	}
	public long getId() {		return this.id;	}
	public void setId(long id) {		this.id = id;	}
	public long getFazhi() {		return this.fazhi;	}
	public void setFazhi(long fazhi) {		this.fazhi = fazhi;	}
	public long getMianzhi() {		return this.mianzhi;	}
	public void setMianzhi(long mianzhi) {		this.mianzhi = mianzhi;	}
	public long getType() {		return this.type;	}
	public void setType(long type) {		this.type = type;	}

	public String toString() {
		return "Coupons [sellerId = " + sellerId + ", promotion = " + promotion + ", title = " + title + ", id = " + id + ", fazhi = " + fazhi + ", mianzhi = " + mianzhi + ", type = " + type + "]";	}
}