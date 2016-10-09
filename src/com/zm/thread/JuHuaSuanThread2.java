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

public class JuHuaSuanThread2 extends Thread{

	public void run() {
		Logger logger=Logger.getLogger(JuHuaSuanThread2.class);
		//获取memcached客户端
		String juHuaSuan = null;
		String url="";
		try {
			url="https://ju.taobao.com/json/jusp2/ajaxGetTpFloor.json?urlKey=other/99fb&floorIndex=" + floor + "&subFloorIndex="+subFloor+"&ext="+ext;
			//logger.info(url);
			juHuaSuan = HttpClientUtils.sendHttpsGet(url);
		} catch (Exception e) {
			logger.info("ur地址："+url);
			logger.info("请求接口数据出错："+e.getMessage());
		}
		if(juHuaSuan!=null){
			//转换json数据
			JSONObject json = (JSONObject) JSONObject.parse(juHuaSuan);
			//得到层名称对象
			JSONObject floorTitle=(JSONObject) json.get("floorTitle");
			String brandList = null;
			//获取层数据
			JSONObject floorData = (JSONObject) json.get("data");
			//判断层list属性并赋值list
			if (!StringUtils.isEmpty(floorData.get("itemList"))) {
				brandList = floorData.get("itemList").toString();
			} else if (!StringUtils.isEmpty(floorData.get("brandList"))) {
				brandList = floorData.get("brandList").toString();
			}else{
				//logger.info("没有符合条件的list，请求到的数据为："+juHuaSuan);
			}
			JSONArray list=null;
			try {
				list = (JSONArray) JSONObject.parse(brandList);
			} catch (Exception e) {
				logger.info("转换商品列表时出错");
			}
			if(floorTitle.get("name").toString().equals("热销单品")||floorTitle.get("name").toString().equals("热门爆款")||floorTitle.get("name").toString().equals("热门商品")) {
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
							if((currentGoodsName.contains("净水器")&&flowAct.getPerUserMoney()/100>=300)||currentGoodsName.contains("菲海伦")||flowAct.getPerUserMoney()/100>=currentGoodsPrice||(int)((int)currentGoodsPrice-flowAct.getPerUserMoney()/100)<=10){
								logger.info("聚划算红包：【"+currentGoodsName+"】进入免单判断,红包状态为(false为有红包，true代表红包为空)"+flowAct.getEmpty());
								if(!flowAct.getEmpty()){
									Object mcVal = mc.get(flowAct.getFlowId()+"");
									logger.info("memcached获取值："+mcVal);
									if(!currentGoodsName.equals(mcVal)){
										try {
											if(currentGoodsName.contains("纱布浴巾")||currentGoodsName.contains("凤全")||currentGoodsName.contains("运动鞋")||currentGoodsName.contains("乔丹")){
												logger.info("忽略免单。。");
											}else{
												logger.info("***********************开始短信发送****************************");
												//"反撸"+(currentGoodsPrice-flowAct.getPerUserMoney()/100)
												String sendMsg = MyInfo.sendMsg(currentGoodsName, flowAct.getFlowId()+"");
												logger.info("短信发送状态为："+sendMsg);
												logger.info("***********************开始邮件发送****************************");
												String sendInfo = MyInfo.sendCloud(currentGoodsName, "欢迎使用，您的激活地址为："+flowAct.getClickUrl()+"'>去抢~</a>           http://i.5945i.com/flow/index.htm?id="+flowAct.getFlowId()+"");
												logger.info("邮件发送返回状态为:"+sendInfo);
												//if(sendInfo.equals("success")){
													mc.set(flowAct.getFlowId()+"",1800,currentGoodsName);
												//}
											}
										} catch (Exception e) {
											e.printStackTrace();
											logger.info("！！！！！！！！！！！！！！邮件发送出错，reason："+e.getMessage()+"!!!!!!!!!!!!!!!!!!");
										}

									}
								}
							}
						}
					}
				}
			}else if(floorTitle.get("name").toString().equals("精选品牌")||floorTitle.get("name").toString().equals("热门品牌")){
				if(!StringUtils.isEmpty(list)){
					for (Object object : list) {
						//转换当前商品对象为JsonObject
						JSONObject currentData = (JSONObject) object;
						//得到当前活动主要信息
						FlowAct flowAct = JSONUtils.toBean(((JSONArray) ((JSONObject)currentData.get("promotion")).get("flowAct")).get(0),FlowAct.class);
						//获取活动商品名称
						String currentGoodsName = (String) ((JSONObject) currentData.get("baseInfo")).get("brandName");
						//判断是否免单
						if(currentGoodsName.contains("雷士")||currentGoodsName.contains("苏宁")||currentGoodsName.contains("中粮")||currentGoodsName.contains("宝洁")||currentGoodsName.contains("哈比熊")||currentGoodsName.contains("三枪")||currentGoodsName.contains("润微")||currentGoodsName.contains("罗莱")||currentGoodsName.contains("京润珍珠")||currentGoodsName.contains("碧欧泉")||currentGoodsName.contains("兰芝")||currentGoodsName.contains("小虫米子")||currentGoodsName.contains("天喔")||currentGoodsName.contains("欧普")){
							logger.info("***************进入聚划算品牌团红包判断*********"+currentGoodsName);
							if(!flowAct.getEmpty()){
								Object mcVal = mc.get(flowAct.getFlowId()+"");
								logger.info("memcached获取值："+mcVal);
								if(!currentGoodsName.equals(mcVal)){
									try {
										try {
											String sendMsg = MyInfo.sendMsg(currentGoodsName, flowAct.getFlowId()+"");
											logger.info("短信发送状态为："+sendMsg);
										} catch (Exception e) {
											e.printStackTrace();
											logger.info("短信发送出错,reason："+e.getMessage());
										}
										logger.info("***********************开始邮件发送****************************");
										String sendInfo = MyInfo.sendCloud(currentGoodsName, "欢迎使用，您的激活地址为：<a href='"+flowAct.getClickUrl()+"'>去抢~</a>           http://i.5945i.com/flow/index.htm?id="+flowAct.getFlowId()+"");
										logger.info("邮件发送返回状态为:"+sendInfo);	
										//if(sendInfo.equals("success")){
											mc.set(flowAct.getFlowId()+"",1800,currentGoodsName);
										//}
									} catch (Exception e) {
										logger.info("！！！！！！！！！！！！！！邮件发送出错，reason："+e.getMessage()+"!!!!!!!!!!!!!!!!!!");
									}
								}
							}
						}
					}
				}
			}else{
				logger.info("未获取到任何数据"+juHuaSuan);
			}
		}
	}


	private Integer floor;
	private Integer subFloor;
	private String ext;
	private MemcachedClient mc;
	public JuHuaSuanThread2(Integer floor, Integer subFloor, String ext, MemcachedClient mc) {
		this.floor = floor;
		this.subFloor = subFloor;
		this.ext = ext;
		this.mc = mc;
	}

}
