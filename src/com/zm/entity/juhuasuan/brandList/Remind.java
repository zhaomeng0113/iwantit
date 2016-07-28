package com.zm.entity.juhuasuan.brandList;

import java.util.List;
public class Remind{	private long soldCount;	private long remindNum;	private String timeRemind;
	public long getSoldCount() {		return this.soldCount;	}
	public void setSoldCount(long soldCount) {		this.soldCount = soldCount;	}
	public long getRemindNum() {		return this.remindNum;	}
	public void setRemindNum(long remindNum) {		this.remindNum = remindNum;	}
	public String getTimeRemind() {		return this.timeRemind;	}
	public void setTimeRemind(String timeRemind) {		this.timeRemind = timeRemind;	}

	public String toString() {
		return "Remind [soldCount = " + soldCount + ", remindNum = " + remindNum + ", timeRemind = " + timeRemind + "]";	}
}