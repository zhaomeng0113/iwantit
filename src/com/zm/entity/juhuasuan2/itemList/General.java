package com.zm.entity.juhuasuan2.itemList;

import java.util.List;
public class General{	private long mixType;
	public long getMixType() {		return this.mixType;	}
	public void setMixType(long mixType) {		this.mixType = mixType;	}
	public General() {}
	public General(long mixType){
		super();		this.mixType = mixType;
	}
	public String toString() {
		return "General [mixType = " + mixType + "]";	}
}