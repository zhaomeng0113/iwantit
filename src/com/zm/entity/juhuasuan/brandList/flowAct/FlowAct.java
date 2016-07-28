package com.zm.entity.juhuasuan.brandList.flowAct;

import java.util.List;
public class FlowAct{	private String flowDomain;	private long balance;	private String desc;	private long perUserMoney;	private long totalBudget;	private String clickUrl;	private String icon;	private long type;	private boolean empty;	private long flowId;
	public String getFlowDomain() {		return this.flowDomain;	}
	public void setFlowDomain(String flowDomain) {		this.flowDomain = flowDomain;	}
	public long getBalance() {		return this.balance;	}
	public void setBalance(long balance) {		this.balance = balance;	}
	public String getDesc() {		return this.desc;	}
	public void setDesc(String desc) {		this.desc = desc;	}
	public long getPerUserMoney() {		return this.perUserMoney;	}
	public void setPerUserMoney(long perUserMoney) {		this.perUserMoney = perUserMoney;	}
	public long getTotalBudget() {		return this.totalBudget;	}
	public void setTotalBudget(long totalBudget) {		this.totalBudget = totalBudget;	}
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

	public String toString() {
		return "FlowAct [flowDomain = " + flowDomain + ", balance = " + balance + ", desc = " + desc + ", perUserMoney = " + perUserMoney + ", totalBudget = " + totalBudget + ", clickUrl = " + clickUrl + ", icon = " + icon + ", type = " + type + ", empty = " + empty + ", flowId = " + flowId + "]";	}
}