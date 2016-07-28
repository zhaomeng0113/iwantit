package com.zm.entity.juhuasuan2.itemList.promInfos;

import java.util.List;
public class PromInfos{	private long money;	private long subMoney;	private long number;	private long discount;
	public long getMoney() {		return this.money;	}
	public void setMoney(long money) {		this.money = money;	}
	public long getSubMoney() {		return this.subMoney;	}
	public void setSubMoney(long subMoney) {		this.subMoney = subMoney;	}
	public long getNumber() {		return this.number;	}
	public void setNumber(long number) {		this.number = number;	}
	public long getDiscount() {		return this.discount;	}
	public void setDiscount(long discount) {		this.discount = discount;	}
	public PromInfos() {}
	public PromInfos(long money, long subMoney, long number, long discount){
		super();		this.money = money;		this.subMoney = subMoney;		this.number = number;		this.discount = discount;
	}
	public String toString() {
		return "PromInfos [money = " + money + ", subMoney = " + subMoney + ", number = " + number + ", discount = " + discount + "]";	}
}