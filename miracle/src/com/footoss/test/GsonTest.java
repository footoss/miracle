package com.footoss.test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.footoss.basic.common.PageModel;
import com.footoss.basic.common.PageModel2;
import com.footoss.basic.constant.Constants;
import com.footoss.miracle.domain.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonTest {

	public static void main(String[] args) {
		List<User> pageList = new ArrayList<>();
		
		User page1 = new User(1, "zhangsan1", "15");
		User page2 = new User(1, "zhangsan2", "15");
		User page3 = new User(1, "zhangsan3", "15");
		User page4 = new User(1, "zhangsan4", "15");
		User page5 = new User(1, "zhangsan5", "15");
		User page6 = new User(1, "zhangsan6", "15");
		
		pageList.add(page1);
		pageList.add(page2);
		pageList.add(page3);
		pageList.add(page4);
		pageList.add(page5);
		pageList.add(page6);
		
		
		
		PageModel<User> pageModel = new PageModel<User>();
		pageModel.setRows(pageList);
		
//		Gson gson = new Gson();
		Type type = new TypeToken<PageModel<User>>(){}.getType();
		String retData = new GsonBuilder().setDateFormat(Constants.DATE_TIME_FORMAT).create().toJson(pageModel,type);
//		String retData = gson.toJson(pageModel,type);
		System.out.println(retData);
	}
}
