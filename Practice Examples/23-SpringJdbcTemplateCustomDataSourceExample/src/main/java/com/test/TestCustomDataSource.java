package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.datasource.CustomDataSource;
import com.test.datasource.CustomDataSource.Type;


public class TestCustomDataSource {
	
	public static void main(String[] args) {
		List<Map<Integer,Object>> lData = new ArrayList<Map<Integer,Object>>();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomDataSource dataSource = ctx.getBean("customDataSource",CustomDataSource.class);
		
		String sqlQuery = "INSERT INTO MOVIES(MOVIE_NAME,MOVIE_LANGUAGE,MOVIE_RELEASE_DATE) VALUES(?,?,?)";
		int iIndex = 1;
		Map<Integer,Object> mParam = new HashMap<Integer, Object>();
		mParam.put(iIndex++, "AVVANAE SRIMAN NARAYANA");
		mParam.put(iIndex++, "KANNADA");
		Date date = new Date();
		mParam.put(iIndex++, date);
		
		lData.add(mParam);
		
		iIndex = 1;
		mParam = new HashMap<Integer, Object>();
		mParam.put(iIndex++, "AYUSHMANBHAVVA");
		mParam.put(iIndex++, "KANNADA");
		mParam.put(iIndex++, date);
		
		lData.add(mParam);
		
		int[] iResult = dataSource.exequteSql(sqlQuery, Type.INTEGER, lData);
		for(int iRes : iResult) {
			System.out.println("iRes ::= "+iRes);
		}
		
		//System.out.println("iResult ::= "+iResult);
	}

}
