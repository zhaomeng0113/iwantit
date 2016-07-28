package com.zm.entity.juhuasuan;

import java.util.List;
public class ExampleBean{	private FloorTitle floorTitle;	private String id;	private boolean search;	private Data data;
	public FloorTitle getFloorTitle() {		return this.floorTitle;	}
	public void setFloorTitle(FloorTitle floorTitle) {		this.floorTitle = floorTitle;	}
	public String getId() {		return this.id;	}
	public void setId(String id) {		this.id = id;	}
	public boolean getSearch() {		return this.search;	}
	public void setSearch(boolean search) {		this.search = search;	}
	public Data getData() {		return this.data;	}
	public void setData(Data data) {		this.data = data;	}

	public String toString() {
		return "ExampleBean [floorTitle = " + floorTitle + ", id = " + id + ", search = " + search + ", data = " + data + "]";	}
}