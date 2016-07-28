package com.zm.entity.juhuasuan2.itemList;

import java.util.List;

import com.zm.entity.juhuasuan2.itemList.flowAct.FlowAct;
public class Promotion{	private Long hongbaoTotalCount;	private Long hongbaoPrice;	private List<FlowAct> flowAct;	private Long hongbao;	private Long couponActivityId;	private String coupon;	private List<String> hongbaoPeriods;
	public Long getHongbaoTotalCount() {
		return hongbaoTotalCount;
	}
	public void setHongbaoTotalCount(Long hongbaoTotalCount) {
		this.hongbaoTotalCount = hongbaoTotalCount;
	}
	public Long getHongbaoPrice() {
		return hongbaoPrice;
	}
	public void setHongbaoPrice(Long hongbaoPrice) {
		this.hongbaoPrice = hongbaoPrice;
	}
	public List<FlowAct> getFlowAct() {
		return flowAct;
	}
	public void setFlowAct(List<FlowAct> flowAct) {
		this.flowAct = flowAct;
	}
	public Long getHongbao() {
		return hongbao;
	}
	public void setHongbao(Long hongbao) {
		this.hongbao = hongbao;
	}
	public Long getCouponActivityId() {
		return couponActivityId;
	}
	public void setCouponActivityId(Long couponActivityId) {
		this.couponActivityId = couponActivityId;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public List<String> getHongbaoPeriods() {
		return hongbaoPeriods;
	}
	public void setHongbaoPeriods(List<String> hongbaoPeriods) {
		this.hongbaoPeriods = hongbaoPeriods;
	}
}