package com.zm.entity.juhuasuan2.itemList;

import java.util.List;

import com.zm.entity.juhuasuan2.itemList.tags.Tags;
public class Name{	private String shortName;	private String title;	private List<Object> prefix;	private String longName;	private List<Tags> tags;
	public String getShortName() {		return this.shortName;	}
	public void setShortName(String shortName) {		this.shortName = shortName;	}
	public String getTitle() {		return this.title;	}
	public void setTitle(String title) {		this.title = title;	}
	public List<Object> getPrefix() {		return this.prefix;	}
	public void setPrefix(List<Object> prefix) {		this.prefix = prefix;	}
	public String getLongName() {		return this.longName;	}
	public void setLongName(String longName) {		this.longName = longName;	}
	public List<Tags> getTags() {		return this.tags;	}
	public void setTags(List<Tags> tags) {		this.tags = tags;	}
	public Name() {}
	public Name(String shortName, String title, List<Object> prefix, String longName, List<Tags> tags){
		super();		this.shortName = shortName;		this.title = title;		this.prefix = prefix;		this.longName = longName;		this.tags = tags;
	}
	public String toString() {
		return "Name [shortName = " + shortName + ", title = " + title + ", prefix = " + prefix + ", longName = " + longName + ", tags = " + tags + "]";	}
}