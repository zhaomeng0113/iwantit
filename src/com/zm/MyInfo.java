package com.zm;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.zm.thread.JuHuaSuanThread;
import com.zm.utils.HttpClientUtils;
import com.zm.utils.HttpUtil;

public class MyInfo {
	
	private static Logger logger=Logger.getLogger(MyInfo.class);
	
	//邮件接收者（数组）
	public static final String[] SENDTOARRAY={""};
	//邮件接受者（String类型，以";"号分隔）
	public static final String SENDTOSTRING="934752820@qq.com";
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
		//String url="http://www.sendcloud.net/webapi/mail.send.json?api_user="+MyInfo.APIUSER+"&api_key="+MyInfo.APIKEY+"&from="+FORM+"&to="+MyInfo.SENDTOSTRING+"&subject="+subject+"&html="+content+"&resp_email_id=true";
		//url=URLEncoder.encode(url, "UTF-8");
		String sendHttpPost = HttpUtil.sendPost("http://www.sendcloud.net/webapi/mail.send.json", sendMap,"UTF-8");
		JSONObject msg = (JSONObject) JSONObject.parse(sendHttpPost);
		String message = msg.getString("message");
		return message;
	}
}
