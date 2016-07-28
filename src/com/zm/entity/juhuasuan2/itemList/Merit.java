package com.zm.entity.juhuasuan2.itemList;

import java.util.List;
public class Merit{	private List<String> desc;	private List<String> up;	private List<String> down;
	public List<String> getDesc() {		return this.desc;	}
	public void setDesc(List<String> desc) {		this.desc = desc;	}
	public List<String> getUp() {		return this.up;	}
	public void setUp(List<String> up) {		this.up = up;	}
	public List<String> getDown() {		return this.down;	}
	public void setDown(List<String> down) {		this.down = down;	}
	public Merit() {}
	public Merit(List<String> desc, List<String> up, List<String> down){
		super();		this.desc = desc;		this.up = up;		this.down = down;
	}
	public String toString() {
		return "Merit [desc = " + desc + ", up = " + up + ", down = " + down + "]";	}
}