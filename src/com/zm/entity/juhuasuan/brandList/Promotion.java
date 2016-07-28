package com.zm.entity.juhuasuan.brandList;

import java.util.List;

import com.zm.entity.juhuasuan.brandList.coupons.Coupons;
import com.zm.entity.juhuasuan.brandList.flowAct.FlowAct;
public class Promotion{	private List<Coupons> coupons;	private List<FlowAct> flowAct;
	public List<Coupons> getCoupons() {		return this.coupons;	}
	public void setCoupons(List<Coupons> coupons) {		this.coupons = coupons;	}
	public List<FlowAct> getFlowAct() {		return this.flowAct;	}
	public void setFlowAct(List<FlowAct> flowAct) {		this.flowAct = flowAct;	}

	public String toString() {
		return "Promotion [coupons = " + coupons + ", flowAct = " + flowAct + "]";	}
}