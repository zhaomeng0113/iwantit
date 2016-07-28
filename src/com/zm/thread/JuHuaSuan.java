package com.zm.thread;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sina.sae.mail.SaeMail;
import com.zm.utils.HttpClientUtils;
import com.zm.utils.MemcachedCilentUtil;
import com.zm.utils.StringUtils;

import net.spy.memcached.MemcachedClient;

public class JuHuaSuan extends Thread{

	private static Logger logger=Logger.getLogger(JuHuaSuan.class);

	public void run() {
		MemcachedCilentUtil m=new MemcachedCilentUtil();
		MemcachedClient mc = m.getClient();
		for(int floor=1;floor<=15;floor++){
			for(int subFloor=1;subFloor<=2;subFloor++){
				try {
					//请求json数据
					String currentUrl="https://ju.taobao.com/json/jusp2/ajaxGetTpFloor.json?urlKey=other/qhb&floorIndex=" + floor + "&subFloorIndex="+subFloor;
					String s = HttpClientUtils.sendHttpsGet(currentUrl);
					//转换json对象
					JSONObject json = (JSONObject) JSONObject.parse(s);
					JSONObject floorTitle=(JSONObject) json.get("floorTitle");
					String brandList = null;
					JSONObject object = (JSONObject) json.get("data");
					if (!StringUtils.isEmpty(object.get("itemList"))) {
						brandList = object.get("itemList").toString();
					} else if (!StringUtils.isEmpty(object.get("brandList"))) {
						brandList = object.get("brandList").toString();
					}
					JSONArray list = (JSONArray) JSONObject.parse(brandList);
					if(floorTitle.get("name").toString().equals("热卖爆品")||floorTitle.get("name").toString().equals("热门爆款")||floorTitle.get("name").toString().equals("热门商品")) {
						for (int i = 0; i < list.size(); i++) {
							Integer isImportant=0; 
							String noMoney = "";
							String canGetMoney = "";
							JSONObject currentData = (JSONObject) list.get(i);
							double currentGoodsPrice = Double.parseDouble((String) ((JSONObject) currentData.get("price")).get("actPrice"));
							String currentGoodsName = (String) ((JSONObject) currentData.get("name")).get("title");
							Integer currentHongbaoPrice = (Integer) ((JSONObject) ((JSONArray) (((JSONObject) currentData.get("promotion")).get("flowAct"))).get(0)).get("perUserMoney");
							Integer currentHongbaoPriceTotal = (Integer) ((JSONObject) ((JSONArray) (((JSONObject) currentData.get("promotion")).get("flowAct"))).get(0)).get("totalBudget");
							Double realCurrentHongbaoPriceTotal = Double.parseDouble(currentHongbaoPriceTotal.toString().substring(0, currentHongbaoPriceTotal.toString().length() - 2));
							Integer flowId = (Integer) ((JSONObject) ((JSONArray) (((JSONObject) currentData.get("promotion")).get("flowAct"))).get(0)).get("flowId");
							Boolean hasMoney = (Boolean) ((JSONObject) ((JSONArray) (((JSONObject) currentData.get("promotion")).get("flowAct"))).get(0)).get("empty");
							Double realHongbaoPrice = Double.parseDouble(currentHongbaoPrice.toString().substring(0, currentHongbaoPrice.toString().length() - 2));
							if (realHongbaoPrice >= currentGoodsPrice) {
								logger.info("进入免单判断");
								noMoney = "是";
								if (!hasMoney) {
									logger.info("有钱");
									isImportant=1;
									Object attribute = mc.get(flowId+"");
									logger.info("memcached获取值："+attribute);
									if(StringUtils.isEmpty(attribute)){
										if(!currentGoodsName.equals(attribute)){
											SaeMail mail = new SaeMail();
											mail.setContentType("HTML");
											Boolean flag=mail.quickSend(Getlist.username,Getlist.sendto,currentGoodsName,currentGoodsName+"免单红包开始了快去抢<a href='http://i.5945i.com/flow/index.htm?id="+flowId+"'>快去抢</a>",Getlist.username,Getlist.password);
											logger.info("聚划算邮件发送状态："+flag+"聚划算邮件发送人："+Getlist.username);
											if(flag){
												mc.set(flowId+"",1800,currentGoodsName);//flowId+"", currentGoodsName,1800);
											}
											//											else{
											//												List<String> filepath = new ArrayList<>();
											//												MailUtils.sendMail("934752820@qq.com,cy3306@foxmail.com,carmencao881021@hotmail.com,499014792@qq.com", "抢红包",currentGoodsName+"免单红包开始了快去抢<a href='http://i.5945i.com/flow/index.htm?id="+flowId+"'>快去抢</a>",filepath);
											//												//这个类主要是设置邮件     
											//												MailSenderInfo mailInfo = new MailSenderInfo();
											//												mailInfo.setMailServerHost("smtp.163.com");      
											//												mailInfo.setMailServerPort("25");      
											//												mailInfo.setValidate(true); 
											//												mailInfo.setUserName("zm_zhaomeng");      
											//												mailInfo.setPassword("qq464205083");//您的邮箱密码      
											//												mailInfo.setFromAddress("zm_zhaomeng@163.com");
											//												mailInfo.setToAddress("934752820@qq.com,cy3306@foxmail.com,carmencao881021@hotmail.com,499014792@qq.com");
											//												mailInfo.setSubject("红包");
											//												mailInfo.setContent(currentGoodsName+"免单红包开始了快去抢<a href='http://i.5945i.com/flow/index.htm?id="+flowId+"'>快去抢</a>");
											//												//这个类主要来发送邮件      
											//												SimpleMailSender sms = new SimpleMailSender();     
											//												//sms.sendTextMail(mailInfo);//发送文体格式      
											//												Boolean flag2=sms.sendHtmlMail(mailInfo);//发送html格式     
											//												logger.info("二次邮件发送状态："+flag2);
											//												if(flag2){
											//													mc.set(flowId+"",1800,currentGoodsName);
											//												}
											//											}
											//}
											//}
										}
									}
								}
							}
							if (!hasMoney) {
								canGetMoney = "没抢光，赶快抢~";
							}
						}
					}
				}catch (Exception e){
					System.out.print("第"+floor+"页第"+subFloor+"层出错");
					continue;
				}
			}
		}
	}
}
