package com.zm.entity.juhuasuan.brandList;

import java.util.List;
public class BaseInfo{	private long blockItemCount;	private long soldAmount;	private long sgFrontCatId;	private String activityStatus;	private long brandId;	private long ostime;	private long oetime;	private String minisiteWL;	private long blockType;	private String activityUrl;	private List<String> frontFirstCatIds;	private long juCategoryId;	private long sellerId;	private boolean isJmp;	private long tbFirstCatId;	private boolean isNew;	private String encode64ActivityId;	private boolean New;	private long businessId;	private String minisitePC;	private String brandName;	private long activityId;	private List<String> blockTags;
	public long getBlockItemCount() {		return this.blockItemCount;	}
	public void setBlockItemCount(long blockItemCount) {		this.blockItemCount = blockItemCount;	}
	public long getSoldAmount() {		return this.soldAmount;	}
	public void setSoldAmount(long soldAmount) {		this.soldAmount = soldAmount;	}
	public long getSgFrontCatId() {		return this.sgFrontCatId;	}
	public void setSgFrontCatId(long sgFrontCatId) {		this.sgFrontCatId = sgFrontCatId;	}
	public String getActivityStatus() {		return this.activityStatus;	}
	public void setActivityStatus(String activityStatus) {		this.activityStatus = activityStatus;	}
	public long getBrandId() {		return this.brandId;	}
	public void setBrandId(long brandId) {		this.brandId = brandId;	}
	public long getOstime() {		return this.ostime;	}
	public void setOstime(long ostime) {		this.ostime = ostime;	}
	public long getOetime() {		return this.oetime;	}
	public void setOetime(long oetime) {		this.oetime = oetime;	}
	public String getMinisiteWL() {		return this.minisiteWL;	}
	public void setMinisiteWL(String minisiteWL) {		this.minisiteWL = minisiteWL;	}
	public long getBlockType() {		return this.blockType;	}
	public void setBlockType(long blockType) {		this.blockType = blockType;	}
	public String getActivityUrl() {		return this.activityUrl;	}
	public void setActivityUrl(String activityUrl) {		this.activityUrl = activityUrl;	}
	public List<String> getFrontFirstCatIds() {		return this.frontFirstCatIds;	}
	public void setFrontFirstCatIds(List<String> frontFirstCatIds) {		this.frontFirstCatIds = frontFirstCatIds;	}
	public long getJuCategoryId() {		return this.juCategoryId;	}
	public void setJuCategoryId(long juCategoryId) {		this.juCategoryId = juCategoryId;	}
	public long getSellerId() {		return this.sellerId;	}
	public void setSellerId(long sellerId) {		this.sellerId = sellerId;	}
	public boolean getIsJmp() {		return this.isJmp;	}
	public void setIsJmp(boolean isJmp) {		this.isJmp = isJmp;	}
	public long getTbFirstCatId() {		return this.tbFirstCatId;	}
	public void setTbFirstCatId(long tbFirstCatId) {		this.tbFirstCatId = tbFirstCatId;	}
	public boolean getIsNew() {		return this.isNew;	}
	public void setIsNew(boolean isNew) {		this.isNew = isNew;	}
	public String getEncode64ActivityId() {		return this.encode64ActivityId;	}
	public void setEncode64ActivityId(String encode64ActivityId) {		this.encode64ActivityId = encode64ActivityId;	}
	public boolean getNew() {		return this.New;	}
	public void setNew(boolean New) {		this.New = New;	}
	public long getBusinessId() {		return this.businessId;	}
	public void setBusinessId(long businessId) {		this.businessId = businessId;	}
	public String getMinisitePC() {		return this.minisitePC;	}
	public void setMinisitePC(String minisitePC) {		this.minisitePC = minisitePC;	}
	public String getBrandName() {		return this.brandName;	}
	public void setBrandName(String brandName) {		this.brandName = brandName;	}
	public long getActivityId() {		return this.activityId;	}
	public void setActivityId(long activityId) {		this.activityId = activityId;	}
	public List<String> getBlockTags() {		return this.blockTags;	}
	public void setBlockTags(List<String> blockTags) {		this.blockTags = blockTags;	}

	public String toString() {
		return "BaseInfo [blockItemCount = " + blockItemCount + ", soldAmount = " + soldAmount + ", sgFrontCatId = " + sgFrontCatId + ", activityStatus = " + activityStatus + ", brandId = " + brandId + ", ostime = " + ostime + ", oetime = " + oetime + ", minisiteWL = " + minisiteWL + ", blockType = " + blockType + ", activityUrl = " + activityUrl + ", frontFirstCatIds = " + frontFirstCatIds + ", juCategoryId = " + juCategoryId + ", sellerId = " + sellerId + ", isJmp = " + isJmp + ", tbFirstCatId = " + tbFirstCatId + ", isNew = " + isNew + ", encode64ActivityId = " + encode64ActivityId + ", New = " + New + ", businessId = " + businessId + ", minisitePC = " + minisitePC + ", brandName = " + brandName + ", activityId = " + activityId + ", blockTags = " + blockTags + "]";	}
}