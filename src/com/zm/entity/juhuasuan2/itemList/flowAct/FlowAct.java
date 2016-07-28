package com.zm.entity.juhuasuan2.itemList.flowAct;

import java.util.List;
public class FlowAct{	private String flowDomain;	private long balance;	private long totalBudget;	private long perUserMoney;	private String clickUrl;	private String icon;	private long type;	private boolean empty;	private long flowId;
	public String getFlowDomain() {		return this.flowDomain;	}
	public void setFlowDomain(String flowDomain) {		this.flowDomain = flowDomain;	}
	public long getBalance() {		return this.balance;	}
	public void setBalance(long balance) {		this.balance = balance;	}
	public long getTotalBudget() {		return this.totalBudget;	}
	public void setTotalBudget(long totalBudget) {		this.totalBudget = totalBudget;	}
	public long getPerUserMoney() {		return this.perUserMoney;	}
	public void setPerUserMoney(long perUserMoney) {		this.perUserMoney = perUserMoney;	}
	public String getClickUrl() {		return this.clickUrl;	}
	public void setClickUrl(String clickUrl) {		this.clickUrl = clickUrl;	}
	public String getIcon() {		return this.icon;	}
	public void setIcon(String icon) {		this.icon = icon;	}
	public long getType() {		return this.type;	}
	public void setType(long type) {		this.type = type;	}
	public boolean getEmpty() {		return this.empty;	}
	public void setEmpty(boolean empty) {		this.empty = empty;	}
	public long getFlowId() {		return this.flowId;	}
	public void setFlowId(long flowId) {		this.flowId = flowId;	}
	public FlowAct() {}
	public FlowAct(String flowDomain, long balance, long totalBudget, long perUserMoney, String clickUrl, String icon, long type, boolean empty, long flowId){
		super();		this.flowDomain = flowDomain;		this.balance = balance;		this.totalBudget = totalBudget;		this.perUserMoney = perUserMoney;		this.clickUrl = clickUrl;		this.icon = icon;		this.type = type;		this.empty = empty;		this.flowId = flowId;
	}
	public String toString() {
		return "FlowAct [flowDomain = " + flowDomain + ", balance = " + balance + ", totalBudget = " + totalBudget + ", perUserMoney = " + perUserMoney + ", clickUrl = " + clickUrl + ", icon = " + icon + ", type = " + type + ", empty = " + empty + ", flowId = " + flowId + "]";	}
}