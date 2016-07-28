package com.zm.entity.juhuasuan2.itemList;

import java.util.List;
public class JiaZhuang{	private String supplyChannel;	private String brandDesc;	private String brandLogo;	private String customerService;
	public String getSupplyChannel() {		return this.supplyChannel;	}
	public void setSupplyChannel(String supplyChannel) {		this.supplyChannel = supplyChannel;	}
	public String getBrandDesc() {		return this.brandDesc;	}
	public void setBrandDesc(String brandDesc) {		this.brandDesc = brandDesc;	}
	public String getBrandLogo() {		return this.brandLogo;	}
	public void setBrandLogo(String brandLogo) {		this.brandLogo = brandLogo;	}
	public String getCustomerService() {		return this.customerService;	}
	public void setCustomerService(String customerService) {		this.customerService = customerService;	}
	public JiaZhuang() {}
	public JiaZhuang(String supplyChannel, String brandDesc, String brandLogo, String customerService){
		super();		this.supplyChannel = supplyChannel;		this.brandDesc = brandDesc;		this.brandLogo = brandLogo;		this.customerService = customerService;
	}
	public String toString() {
		return "JiaZhuang [supplyChannel = " + supplyChannel + ", brandDesc = " + brandDesc + ", brandLogo = " + brandLogo + ", customerService = " + customerService + "]";	}
}