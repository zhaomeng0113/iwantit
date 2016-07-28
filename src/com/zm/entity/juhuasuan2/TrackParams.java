package com.zm.entity.juhuasuan2;

import java.util.List;
public class TrackParams{	private String stype;	private String _detailExpose;	private String _click;	private String itemIds;	private String impid;	private String is_jusp;	private String pageno;	private String bucket;	private String is_load;	private String from;	private String floorIndex;	private String fcatids;	private String _expose;
	public String getStype() {		return this.stype;	}
	public void setStype(String stype) {		this.stype = stype;	}
	public String get_detailExpose() {		return this._detailExpose;	}
	public void set_detailExpose(String _detailExpose) {		this._detailExpose = _detailExpose;	}
	public String get_click() {		return this._click;	}
	public void set_click(String _click) {		this._click = _click;	}
	public String getItemIds() {		return this.itemIds;	}
	public void setItemIds(String itemIds) {		this.itemIds = itemIds;	}
	public String getImpid() {		return this.impid;	}
	public void setImpid(String impid) {		this.impid = impid;	}
	public String getIs_jusp() {		return this.is_jusp;	}
	public void setIs_jusp(String is_jusp) {		this.is_jusp = is_jusp;	}
	public String getPageno() {		return this.pageno;	}
	public void setPageno(String pageno) {		this.pageno = pageno;	}
	public String getBucket() {		return this.bucket;	}
	public void setBucket(String bucket) {		this.bucket = bucket;	}
	public String getIs_load() {		return this.is_load;	}
	public void setIs_load(String is_load) {		this.is_load = is_load;	}
	public String getFrom() {		return this.from;	}
	public void setFrom(String from) {		this.from = from;	}
	public String getFloorIndex() {		return this.floorIndex;	}
	public void setFloorIndex(String floorIndex) {		this.floorIndex = floorIndex;	}
	public String getFcatids() {		return this.fcatids;	}
	public void setFcatids(String fcatids) {		this.fcatids = fcatids;	}
	public String get_expose() {		return this._expose;	}
	public void set_expose(String _expose) {		this._expose = _expose;	}
	public TrackParams() {}
	public TrackParams(String stype, String _detailExpose, String _click, String itemIds, String impid, String is_jusp, String pageno, String bucket, String is_load, String from, String floorIndex, String fcatids, String _expose){
		super();		this.stype = stype;		this._detailExpose = _detailExpose;		this._click = _click;		this.itemIds = itemIds;		this.impid = impid;		this.is_jusp = is_jusp;		this.pageno = pageno;		this.bucket = bucket;		this.is_load = is_load;		this.from = from;		this.floorIndex = floorIndex;		this.fcatids = fcatids;		this._expose = _expose;
	}
	public String toString() {
		return "TrackParams [stype = " + stype + ", _detailExpose = " + _detailExpose + ", _click = " + _click + ", itemIds = " + itemIds + ", impid = " + impid + ", is_jusp = " + is_jusp + ", pageno = " + pageno + ", bucket = " + bucket + ", is_load = " + is_load + ", from = " + from + ", floorIndex = " + floorIndex + ", fcatids = " + fcatids + ", _expose = " + _expose + "]";	}
}