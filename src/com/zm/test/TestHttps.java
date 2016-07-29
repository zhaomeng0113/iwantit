package com.zm.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zm.entity.juhuasuan.JuHuaSuanBrand;
import com.zm.entity.juhuasuan.brandList.BrandList;
import com.zm.entity.juhuasuan2.JuHuaSuanItem;
import com.zm.entity.juhuasuan2.itemList.ItemList;
import com.zm.thread.JuHuaSuanThread;
import com.zm.utils.HttpClientUtils;
import com.zm.utils.JSONUtils;
import com.zm.utils.JsonMapper;
import com.zm.utils.StringUtils;

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
		String juHuaSuan=null;
		try {
			juHuaSuan = HttpClientUtils.sendHttpsGet("https://ju.taobao.com/json/jusp2/ajaxGetTpFloor.json?urlKey=other/qhb&floorIndex=1&subFloorIndex=2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//转换json数据
		JSONObject json = (JSONObject) JSONObject.parse(juHuaSuan);
		//得到层名称对象
		JSONObject floorTitle=(JSONObject) json.get("floorTitle");
		String brandList = null;
		//获取层数据
		JSONObject object = (JSONObject) json.get("data");
		//判断层list属性并赋值list
		if (!StringUtils.isEmpty(object.get("itemList"))) {
			brandList = object.get("itemList").toString();
		} else if (!StringUtils.isEmpty(object.get("brandList"))) {
			brandList = object.get("brandList").toString();
		}else{
			logger.info("没有符合条件的list");
		}
		JSONArray list = (JSONArray) JSONObject.parse(brandList);
		List arrayList = JSONUtils.toArrayList(list);
		if(floorTitle.get("name").toString().equals("热卖爆品")||floorTitle.get("name").toString().equals("热门爆款")||floorTitle.get("name").toString().equals("热门商品")) {
			for (Object object2 : arrayList) {
				System.out.println(object2);
			}
		}
	}
	public static void main(String[] args) {
		for(int floor=1;floor<=15;floor++){
			for(int subFloor=1;subFloor<=2;subFloor++){
				JuHuaSuanThread j=new JuHuaSuanThread(floor, subFloor);
				j.start();
			}
		}
	}
}
