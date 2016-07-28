package com.zm.entity.juhuasuan2.itemList;

import java.util.List;
public class Remind{	private long soldCount;	private long remindNum;	private boolean fire;
	public long getSoldCount() {		return this.soldCount;	}
	public void setSoldCount(long soldCount) {		this.soldCount = soldCount;	}
	public long getRemindNum() {		return this.remindNum;	}
	public void setRemindNum(long remindNum) {		this.remindNum = remindNum;	}
	public boolean getFire() {		return this.fire;	}
	public void setFire(boolean fire) {		this.fire = fire;	}
	public Remind() {}
	public Remind(long soldCount, long remindNum, boolean fire){
		super();		this.soldCount = soldCount;		this.remindNum = remindNum;		this.fire = fire;
	}
	public String toString() {
		return "Remind [soldCount = " + soldCount + ", remindNum = " + remindNum + ", fire = " + fire + "]";	}
}