package com.zm.thread;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zm.MyInfo;
import com.zm.entity.juhuasuan2.itemList.flowAct.FlowAct;
import com.zm.utils.HttpClientUtils;
import com.zm.utils.JSONUtils;
import com.zm.utils.StringUtils;

import net.spy.memcached.MemcachedClient;

public class TaoQiangGouThread extends Thread{
	public void run() {
		Logger logger=Logger.getLogger(TaoQiangGouThread.class);
		//获取memcached客户端
		String taoqianggou = null;
		try {
			String url="https://ju.taobao.com/json/jusp2/ajaxGetTpFloor.json?urlKey=nv/qianghongbao&floorIndex="+floor;
			//logger.info(url);
			taoqianggou = HttpClientUtils.sendHttpsGet(url);
		} catch (Exception e) {
			logger.info("请求接口数据出错："+e.getMessage());
		}
		if(taoqianggou!=null){
			//转换json数据
			JSONObject json = (JSONObject) JSONObject.parse(taoqianggou);
			//得到层名称对象
			String brandList = null;
			//判断层list属性并赋值list
			if (!StringUtils.isEmpty(json.get("itemList"))) {
				brandList = json.get("itemList").toString();
			} else if (!StringUtils.isEmpty(json.get("brandList"))) {
				brandList = json.get("brandList").toString();
			}else{
				//logger.info("没有符合条件的list，请求到的数据为："+taoqianggou);
			}
			JSONArray list=null;
			try {
				list = (JSONArray) JSONObject.parse(brandList);
			} catch (Exception e) {
				logger.info("转换商品列表时出错"+e.getMessage());
			}
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
					if(currentGoodsPrice>=5){
						if(flowAct.getPerUserMoney()/100>=currentGoodsPrice||(currentGoodsPrice-flowAct.getPerUserMoney()/100)<=8){
							logger.info("淘抢购红包：【"+currentGoodsName+"】进入免单判断,红包状态为(false为有红包，true代表红包为空)"+flowAct.getEmpty());
							if(!flowAct.getEmpty()){
								Object mcVal = mc.get(flowAct.getFlowId()+"");
								logger.info("memcached获取值："+mcVal);
								if(!currentGoodsName.equals(mcVal)){
									try {
										logger.info("***********************开始邮件发送****************************");
										String sendInfo = MyInfo.sendCloud(currentGoodsName,currentGoodsName+"免单红包开始了快去抢<a href=http://i.5945i.com/flow/index.htm?id="+flowAct.getFlowId()+">走你~</a>");
										logger.info("邮件发送返回状态为:"+sendInfo);
										if(sendInfo.equals("success")){
											mc.set(flowAct.getFlowId()+"",1800,currentGoodsName);
										}
									} catch (Exception e) {
										logger.info("！！！！！！！！！！！！！！淘抢购邮件发送出错，reason："+e.getMessage()+"!!!!!!!!!!!!!!!!!!");
									}

								}
							}
						}
					}
				}
			}
		}
	}
	
	public TaoQiangGouThread(Integer floor, MemcachedClient mc) {
		this.floor = floor;
		this.mc = mc;
	}

	private Integer floor;
	private MemcachedClient mc;
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public MemcachedClient getMc() {
		return mc;
	}
	public void setMc(MemcachedClient mc) {
		this.mc = mc;
	}
}
