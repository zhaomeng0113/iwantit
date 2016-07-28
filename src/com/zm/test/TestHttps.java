package com.zm.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.zm.entity.juhuasuan.JuHuaSuanBrand;
import com.zm.entity.juhuasuan.brandList.BrandList;
import com.zm.entity.juhuasuan2.JuHuaSuanItem;
import com.zm.entity.juhuasuan2.itemList.ItemList;
import com.zm.thread.JuHuaSuanThread;
import com.zm.utils.HttpClientUtils;
import com.zm.utils.JsonMapper;

public class TestHttps {
	
	private static Logger logger=Logger.getLogger(TestHttps.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		long starTime=System.currentTimeMillis();
		for(int floor=1;floor<=15;floor++){
			for(int subFloor=1;subFloor<=2;subFloor++){
				String juHuaSuan =null;
				try {
					juHuaSuan = HttpClientUtils.sendHttpsGet("https://ju.taobao.com/json/jusp2/ajaxGetTpFloor.json?urlKey=other/qhb&floorIndex=" + floor + "&subFloorIndex="+subFloor);
				} catch (Exception e) {
					continue;
				}
				if(juHuaSuan!=null){
					try {
						JuHuaSuanBrand juHuaSuanBrand = JsonMapper.buildNonDefaultMapper().fromJson(juHuaSuan, JuHuaSuanBrand.class);
						List<BrandList> brandList = juHuaSuanBrand.getData().getBrandList();
						System.out.println(brandList);
					} catch (Exception e) {
						System.out.println("==========================品牌报错=======================");
					}
					try {
						JuHuaSuanItem juHuaSuanItem = JsonMapper.buildNonDefaultMapper().fromJson(juHuaSuan, JuHuaSuanItem.class);
						List<ItemList> itemList = juHuaSuanItem.getData().getItemList();
						System.out.println(itemList);
					} catch (Exception e) {
						System.out.println("==========================商品报错======================="+floor+"-------"+subFloor);
						e.printStackTrace();
					}
				}
			}
		}
		long endTime=System.currentTimeMillis();
		System.out.println("spend time:"+(starTime-endTime)+"");
	}
	
	@Test
	public void test2() {
		JuHuaSuanThread j=new JuHuaSuanThread(1,1);
		j.start();
	}
}
