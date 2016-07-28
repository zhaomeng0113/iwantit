package com.zm.entity.juhuasuan;

public class JuHuaSuanBrand {
	private String id;
	private FloorTitle floorTitle;
	private Boolean search;
	private Data data;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public FloorTitle getFloorTitle() {
		return floorTitle;
	}
	public void setFloorTitle(FloorTitle floorTitle) {
		this.floorTitle = floorTitle;
	}
	public Boolean getSearch() {
		return search;
	}
	public void setSearch(Boolean search) {
		this.search = search;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JuHuaSuan [id=" + id + ", floorTitle=" + floorTitle.toString() + ", search=" + search + ", data=" + data.toString() + "]";
	}
	
}
