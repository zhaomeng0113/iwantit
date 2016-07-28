package com.zm.entity.juhuasuan;

public class FloorTitle{	private boolean show;	private boolean navShow;	private String name;
	public boolean getShow() {		return this.show;	}
	public void setShow(boolean show) {		this.show = show;	}
	public boolean getNavShow() {		return this.navShow;	}
	public void setNavShow(boolean navShow) {		this.navShow = navShow;	}
	public String getName() {		return this.name;	}
	public void setName(String name) {		this.name = name;	}

	public String toString() {
		return "FloorTitle [show = " + show + ", navShow = " + navShow + ", name = " + name + "]";	}
}