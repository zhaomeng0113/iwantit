package com.zm.entity.juhuasuan2.itemList.merits;

import java.util.List;
public class Merits{	private String text;
	public String getText() {		return this.text;	}
	public void setText(String text) {		this.text = text;	}
	public Merits() {}
	public Merits(String text){
		super();		this.text = text;
	}
	public String toString() {
		return "Merits [text = " + text + "]";	}
}