package com.zm.entity.juhuasuan;

import java.util.List;

import com.zm.entity.juhuasuan.brandList.BrandList;
public class Data{	private long dataType;	private long brandLen;	private long currentPage;	private List<BrandList> brandList;	private long pageSize;	private long brandStyle;	private long totalPage;	private TrackParams trackParams;
	public long getDataType() {		return this.dataType;	}
	public void setDataType(long dataType) {		this.dataType = dataType;	}
	public long getBrandLen() {		return this.brandLen;	}
	public void setBrandLen(long brandLen) {		this.brandLen = brandLen;	}
	public long getCurrentPage() {		return this.currentPage;	}
	public void setCurrentPage(long currentPage) {		this.currentPage = currentPage;	}
	public List<BrandList> getBrandList() {		return this.brandList;	}
	public void setBrandList(List<BrandList> brandList) {		this.brandList = brandList;	}
	public long getPageSize() {		return this.pageSize;	}
	public void setPageSize(long pageSize) {		this.pageSize = pageSize;	}
	public long getBrandStyle() {		return this.brandStyle;	}
	public void setBrandStyle(long brandStyle) {		this.brandStyle = brandStyle;	}
	public long getTotalPage() {		return this.totalPage;	}
	public void setTotalPage(long totalPage) {		this.totalPage = totalPage;	}
	public TrackParams getTrackParams() {		return this.trackParams;	}
	public void setTrackParams(TrackParams trackParams) {		this.trackParams = trackParams;	}

	public String toString() {
		return "Data [dataType = " + dataType + ", brandLen = " + brandLen + ", currentPage = " + currentPage + ", brandList = " + brandList + ", pageSize = " + pageSize + ", brandStyle = " + brandStyle + ", totalPage = " + totalPage + ", trackParams = " + trackParams + "]";	}
}