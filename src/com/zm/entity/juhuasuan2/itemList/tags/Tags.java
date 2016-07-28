package com.zm.entity.juhuasuan2.itemList.tags;

import java.util.List;
public class Tags{	private String text;	private String tag;
	public String getText() {		return this.text;	}
	public void setText(String text) {		this.text = text;	}
	public String getTag() {		return this.tag;	}
	public void setTag(String tag) {		this.tag = tag;	}
	public Tags() {}
	public Tags(String text, String tag){
		super();		this.text = text;		this.tag = tag;
	}
	public String toString() {
		return "Tags [text = " + text + ", tag = " + tag + "]";	}
}