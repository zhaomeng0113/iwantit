package com.zm;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.zm.utils.HttpUtil;

public class MyInfo {
	
	private static Logger logger=Logger.getLogger(MyInfo.class);
	
	//邮件接收者（数组）
	public static final String[] SENDTOARRAY={""};
	//邮件接受者（String类型，以";"号分隔）
	public static final String SENDTOSTRING="934752820@qq.com;543680244@qq.com;499014792@qq.com;cy3306@foxmail.com;527260578@qq.com;495887905@qq.com";
	public static final String MYMAILFORJUHUASUAN="";
	public static final String MYMAILFORJUHUASUANPWD="";
	public static final String MYMAILFORTAOQIANGGOU="";
	public static final String MYMAILFORTAOQIANGGOUPWD="";
	public static final String MYMAILFORPINPAITUAN="";
	public static final String MYMAILFORPINPAITUANPWD="";

	//sendCloud配置
	public static final String APIUSER="zm_zhaomeng_test_ob9Tav";
	public static final String APIKEY="4MrKGlFFbtwtnofs";
	public static final String FORM="leifeng@leifeng.com";
	public static final String FORMNAME="雷锋";

	public static String sendCloud(String subject,String content) throws Exception{
		Map<String,String> sendMap=new HashMap<String,String>();
		sendMap.put("api_user", MyInfo.APIUSER);
		sendMap.put("api_key", MyInfo.APIKEY);
		sendMap.put("to", MyInfo.SENDTOSTRING);
		sendMap.put("subject", subject);
		sendMap.put("html", content);
		sendMap.put("from", FORM);
		sendMap.put("resp_email_id", "true");
		logger.info("邮件内容："+content);
		//String url="http://www.sendcloud.net/webapi/mail.send.json?api_user="+MyInfo.APIUSER+"&api_key="+MyInfo.APIKEY+"&from="+FORM+"&to="+MyInfo.SENDTOSTRING+"&subject="+subject+"&html="+content+"&resp_email_id=true";
		//url=URLEncoder.encode(url, "UTF-8");
		String sendHttpPost = HttpUtil.sendPost("http://www.sendcloud.net/webapi/mail.send.json", sendMap,"UTF-8");
		JSONObject msg = (JSONObject) JSONObject.parse(sendHttpPost);
		logger.info(sendHttpPost);
		String message = msg.getString("message");
		Integer sendCount=1;
//		if(message.equals("error")){
//			sendCloud(subject, content);
//			sendCount++;
//		}
		return message;
	}
	public static String sendMsg(String name,String url){
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest","23343887","98fa7734d20797605e7bf9d311c74282");
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setSmsType("normal");
		req.setSmsFreeSignName("ZM提醒");
		req.setSmsParamString("{name:'免单',url:'"+url+"'}");
		req.setRecNum("13261033656,15919550085,18662658756");
		req.setSmsTemplateCode("SMS_12981741");
		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			logger.info("短信发送返回状态："+rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
			logger.info("短信发送出错"+e.getErrMsg());
		}
		return null;
	}
}
