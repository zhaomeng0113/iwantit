package com.zm.entity.juhuasuan2;

import java.util.List;

import com.zm.entity.juhuasuan2.itemList.ItemList;
public class Data{	private long dataType;	private long totalPage;	private List<ItemList> itemList;	private long currentPage;	private long pageSize;	private long itemLen;	private long itemStyle;	private TrackParams trackParams;
	public long getDataType() {		return this.dataType;	}
	public void setDataType(long dataType) {		this.dataType = dataType;	}
	public long getTotalPage() {		return this.totalPage;	}
	public void setTotalPage(long totalPage) {		this.totalPage = totalPage;	}
	public List<ItemList> getItemList() {		return this.itemList;	}
	public void setItemList(List<ItemList> itemList) {		this.itemList = itemList;	}
	public long getCurrentPage() {		return this.currentPage;	}
	public void setCurrentPage(long currentPage) {		this.currentPage = currentPage;	}
	public long getPageSize() {		return this.pageSize;	}
	public void setPageSize(long pageSize) {		this.pageSize = pageSize;	}
	public long getItemLen() {		return this.itemLen;	}
	public void setItemLen(long itemLen) {		this.itemLen = itemLen;	}
	public long getItemStyle() {		return this.itemStyle;	}
	public void setItemStyle(long itemStyle) {		this.itemStyle = itemStyle;	}
	public TrackParams getTrackParams() {		return this.trackParams;	}
	public void setTrackParams(TrackParams trackParams) {		this.trackParams = trackParams;	}
	public Data() {}
	public Data(long dataType, long totalPage, List<ItemList> itemList, long currentPage, long pageSize, long itemLen, long itemStyle, TrackParams trackParams){
		super();		this.dataType = dataType;		this.totalPage = totalPage;		this.itemList = itemList;		this.currentPage = currentPage;		this.pageSize = pageSize;		this.itemLen = itemLen;		this.itemStyle = itemStyle;		this.trackParams = trackParams;
	}
	public String toString() {
		return "Data [dataType = " + dataType + ", totalPage = " + totalPage + ", itemList = " + itemList + ", currentPage = " + currentPage + ", pageSize = " + pageSize + ", itemLen = " + itemLen + ", itemStyle = " + itemStyle + ", trackParams = " + trackParams + "]";	}
}