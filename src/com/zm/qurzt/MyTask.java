package com.zm.qurzt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.zm.thread.JuHuaSuanThread;
import com.zm.thread.TaoQiangGouThread;
import com.zm.utils.MemcachedCilentUtil;

import net.spy.memcached.MemcachedClient;


/** 
 * 继承 定时器任务类 
 *  
 */  
public class MyTask extends TimerTask{  

	public MyTask() {  
		super();  
	}  


	private static boolean isRunning = false;  

	private ServletContext context = null;  

	public MyTask(ServletContext context) {  
		this.context = context;
	}  

	@SuppressWarnings("deprecation")
	public void run() {  
		if (!isRunning) {  
			MemcachedCilentUtil memcachedClient=new MemcachedCilentUtil();
			MemcachedClient mc = memcachedClient.getClient();
			for(int floor=1;floor<=15;floor++){
				TaoQiangGouThread taoQiangGouThread=new TaoQiangGouThread(floor,mc);
				taoQiangGouThread.start();
				for(int subFloor=1;subFloor<=2;subFloor++){
					for(int page=1;page<=2;page++){
						JuHuaSuanThread j=new JuHuaSuanThread(floor, subFloor,"page%3A"+page,mc);
						j.start();
					}
				}
			}
			isRunning = false;  
			context.log("指定任务执行结束");  
		} else {  
			context.log("上一次任务执行还未结束");  
		}  
	}


}  