package com.zm.thread;


import java.net.URLEncoder;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zm.MyInfo;
import com.zm.entity.juhuasuan2.itemList.flowAct.FlowAct;
import com.zm.utils.HttpClientUtils;
import com.zm.utils.JSONUtils;
import com.zm.utils.MemcachedCilentUtil;
import com.zm.utils.StringUtils;

import net.spy.memcached.MemcachedClient;

public class JuHuaSuanThread extends Thread{

	private static Logger logger=Logger.getLogger(JuHuaSuanThread.class);

	public void run() {
		//获取memcached客户端
		String juHuaSuan = null;
		try {
			juHuaSuan = HttpClientUtils.sendHttpsGet("https://ju.taobao.com/json/jusp2/ajaxGetTpFloor.json?urlKey=other/qhb&floorIndex=" + floor + "&subFloorIndex="+subFloor);
		} catch (Exception e) {
			logger.info("请求接口数据出错："+e.getMessage());
		}
		if(juHuaSuan!=null){
			//转换json数据
			JSONObject json = (JSONObject) JSONObject.parse(juHuaSuan);
			//得到层名称对象
			JSONObject floorTitle=(JSONObject) json.get("floorTitle");
			String brandList = null;
			//获取层数据
			//JSONObject floorData = (JSONObject) json.get("data");
			//判断层list属性并赋值list
			if (!StringUtils.isEmpty(json.get("itemList"))) {
				brandList = json.get("itemList").toString();
			} else if (!StringUtils.isEmpty(json.get("brandList"))) {
				brandList = json.get("brandList").toString();
			}else{
				logger.info("没有符合条件的list，请求到的数据为："+juHuaSuan);
			}
			JSONArray list=null;
			try {
				list = (JSONArray) JSONObject.parse(brandList);
			} catch (Exception e) {
				logger.info("转换商品列表时出错");
			}
			if(json.get("floorName").toString().equals("热卖爆品")||json.get("floorName").toString().equals("热门爆款")||json.get("floorName").toString().equals("热门商品")) {
				if(!StringUtils.isEmpty(list)){
					for (Object object : list) {
						//转换当前商品对象为JsonObject
						JSONObject currentData = (JSONObject) object;
						//得到当前活动主要信息
						FlowAct flowAct = JSONUtils.toBean(((JSONArray) ((JSONObject)currentData.get("promotion")).get("flowAct")).get(0),FlowAct.class);
						//获取活动商品价格
						double currentGoodsPrice = Double.parseDouble((String) ((JSONObject) currentData.get("price")).get("actPrice"));
						//获取活动商品名称
						String currentGoodsName = (String) ((JSONObject) currentData.get("name")).get("title");
						//判断是否免单
						if(flowAct.getPerUserMoney()/100>=currentGoodsPrice){
							logger.info("进入免单判断,红包状态为(false为有红包，true代表红包为空)"+flowAct.getEmpty());
							if(!flowAct.getEmpty()){
								Object mcVal = mc.get(flowAct.getFlowId()+"");
								logger.info("memcached获取值："+mcVal);
								if(!currentGoodsName.equals(mcVal)){
									try {
										logger.info("***********************开始邮件发送****************************");
										String sendInfo = MyInfo.sendCloud(currentGoodsName,currentGoodsName+"免单红包开始了快去抢<a href='http://i.5945i.com/flow/index.htm?id="+flowAct.getFlowId()+"'>走你~</a>");
										logger.info("邮件发送返回状态为:"+sendInfo);
										if(sendInfo.equals("success")){
											mc.set(flowAct.getFlowId()+"",1800,currentGoodsName);
										}
									} catch (Exception e) {
										logger.info("！！！！！！！！！！！！！！邮件发送出错，reason："+e.getMessage()+"!!!!!!!!!!!!!!!!!!");
									}
								}
							}
						}
					}
				}
			}else if(json.get("floorName").toString().equals("热卖品牌")||json.get("floorName").toString().equals("热门品牌")){
				if(!StringUtils.isEmpty(list)){
					for (Object object : list) {
						//转换当前商品对象为JsonObject
						JSONObject currentData = (JSONObject) object;
						//得到当前活动主要信息
						FlowAct flowAct = JSONUtils.toBean(((JSONArray) ((JSONObject)currentData.get("promotion")).get("flowAct")).get(0),FlowAct.class);
						//获取活动商品名称
						String currentGoodsName = (String) ((JSONObject) currentData.get("baseInfo")).get("brandName");
						//判断是否免单
						if(currentGoodsName.contains("润微")||currentGoodsName.contains("京润珍珠")||currentGoodsName.contains("碧欧泉")||currentGoodsName.contains("兰芝")||currentGoodsName.contains("小虫米子")||currentGoodsName.contains("百雀羚")||currentGoodsName.contains("迪奥")||currentGoodsName.contains("天喔")||currentGoodsName.contains("欧普")){
							if(!flowAct.getEmpty()){
								Object mcVal = mc.get(flowAct.getFlowId()+"");
								logger.info("memcached获取值："+mcVal);
								if(!currentGoodsName.equals(mcVal)){
									try {
										logger.info("***********************开始邮件发送****************************");
										String sendInfo = MyInfo.sendCloud(currentGoodsName, currentGoodsName+"免单红包开始了快去抢<a href='http://i.5945i.com/flow/index.htm?id="+flowAct.getFlowId()+"'>走你~</a>");
										logger.info("邮件发送返回状态为:"+sendInfo);
										if(sendInfo.equals("success")){
											mc.set(flowAct.getFlowId()+"",1800,currentGoodsName);
										}
									} catch (Exception e) {
										logger.info("！！！！！！！！！！！！！！邮件发送出错，reason："+e.getMessage()+"!!!!!!!!!!!!!!!!!!");
									}
								}
							}
						}
					}
				}
			}else{
				logger.info("未获取到任何数据");
			}
		}
	}


	private Integer floor;
	private Integer subFloor;
	private MemcachedClient mc;

	public JuHuaSuanThread(Integer floor, Integer subFloor, MemcachedClient mc) {
		this.floor = floor;
		this.subFloor = subFloor;
		this.mc = mc;
	}
}
