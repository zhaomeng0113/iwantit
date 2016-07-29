package com.zm.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.ConnectionFactoryBuilder.Protocol;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.auth.AuthDescriptor;
import net.spy.memcached.auth.PlainCallbackHandler;

public class MemcachedCilentUtil {
	
	private static Logger logger=Logger.getLogger(MemcachedCilentUtil.class);
	
	public MemcachedClient getClient() {
		//开发模式
//		MemcachedClient mc = null;
//		try {
//			mc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
//			return mc;
//		} catch (IOException e1) {
//			e1.printStackTrace();
//			logger.info("memcached连接错误,reason:"+e1.getMessage());
//			return null;
//		}
		//生产环境
		AuthDescriptor ad = new AuthDescriptor(new String[] {"PLAIN"},
				new PlainCallbackHandler(System.getenv("ACCESSKEY"),System.getenv("SECRETKEY")));
		MemcachedClient mc = null;
		try {
			mc = new MemcachedClient(new ConnectionFactoryBuilder().setProtocol(Protocol.BINARY).setAuthDescriptor(ad).build(),AddrUtil.getAddresses(System.getenv("MEMCACHE_SERVERS")));
			return mc;
		} catch (IOException e1) {
			logger.info("memcached连接错误");
			e1.printStackTrace();
			return null;
		}
	}
}
