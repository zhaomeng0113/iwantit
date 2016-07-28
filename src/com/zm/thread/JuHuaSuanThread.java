package com.zm.thread;

import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zm.utils.HttpClientUtils;
import com.zm.utils.JSONUtils;
import com.zm.utils.MemcachedCilentUtil;
import com.zm.utils.StringUtils;

import net.spy.memcached.MemcachedClient;

public class JuHuaSuanThread extends Thread{

	private static Logger logger=Logger.getLogger(JuHuaSuanThread.class);
	
	public void run() {
//		MemcachedCilentUtil m=new MemcachedCilentUtil();
//		MemcachedClient mc = m.getClient();
		String juHuaSuan = null;
		try {
			juHuaSuan = HttpClientUtils.sendHttpsGet("https://ju.taobao.com/json/jusp2/ajaxGetTpFloor.json?urlKey=other/qhb&floorIndex=" + floor + "&subFloorIndex="+subFloor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(juHuaSuan!=null){
			//转换json数据
			JSONObject json = (JSONObject) JSONObject.parse(juHuaSuan);
			//得到层名称对象
			JSONObject floorTitle=(JSONObject) json.get("floorTitle");
			String brandList = null;
			//获取层数据
			JSONObject object = (JSONObject) json.get("data");
			//判断层list属性并赋值list
			if (!StringUtils.isEmpty(object.get("itemList"))) {
				brandList = object.get("itemList").toString();
			} else if (!StringUtils.isEmpty(object.get("brandList"))) {
				brandList = object.get("brandList").toString();
			}else{
				logger.info("没有符合条件的list");
			}
			JSONArray list = (JSONArray) JSONObject.parse(brandList);
			if(floorTitle.get("name").toString().equals("热卖爆品")||floorTitle.get("name").toString().equals("热门爆款")||floorTitle.get("name").toString().equals("热门商品")) {
				List arrayList = JSONUtils.toArrayList(list);
			}
		}
	}
	
	
	private Integer floor;
	private Integer subFloor;

	public JuHuaSuanThread(Integer floor, Integer subFloor) {
		this.floor = floor;
		this.subFloor = subFloor;
	}
	
}
