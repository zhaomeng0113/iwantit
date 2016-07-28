package com.zm.entity.juhuasuan.brandList;

import java.util.List;
public class BrandList{	private Materials materials;	private Price price;	private BaseInfo baseInfo;	private General general;	private Remind remind;	private Promotion promotion;
	public Materials getMaterials() {		return this.materials;	}
	public void setMaterials(Materials materials) {		this.materials = materials;	}
	public Price getPrice() {		return this.price;	}
	public void setPrice(Price price) {		this.price = price;	}
	public BaseInfo getBaseInfo() {		return this.baseInfo;	}
	public void setBaseInfo(BaseInfo baseInfo) {		this.baseInfo = baseInfo;	}
	public General getGeneral() {		return this.general;	}
	public void setGeneral(General general) {		this.general = general;	}
	public Remind getRemind() {		return this.remind;	}
	public void setRemind(Remind remind) {		this.remind = remind;	}
	public Promotion getPromotion() {		return this.promotion;	}
	public void setPromotion(Promotion promotion) {		this.promotion = promotion;	}
}