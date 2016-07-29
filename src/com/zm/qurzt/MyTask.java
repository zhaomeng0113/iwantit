package com.zm.qurzt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.zm.thread.JuHuaSuanThread;


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
			for(int floor=1;floor<=15;floor++){
				for(int subFloor=1;subFloor<=2;subFloor++){
					JuHuaSuanThread j=new JuHuaSuanThread(floor, subFloor);
					j.start();
				}
			}
			isRunning = false;  
			context.log("指定任务执行结束");  
		} else {  
			context.log("上一次任务执行还未结束");  
		}  
	}


}  