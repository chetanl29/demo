package com.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.test.datasource.CustomDataSource;
import com.test.datasource.CustomDataSource.Type;

@SpringBootApplication
public class TestCustomDataSource {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TestCustomDataSource.class, args);
		CustomDataSource dataSource = ctx.getBean("customDataSource", CustomDataSource.class);
		String sqlQuery = "INSERT INTO MOVIES(MOVIE_NAME,MOVIE_LANGUAGE,MOVIE_RELEASE_DATE) VALUES(?,?,?)";
		int iIndex = 1;
		Map<Integer,Object> mParam = new HashMap<Integer, Object>();
		mParam.put(iIndex++, "SAHOO");
		mParam.put(iIndex++, "TELUGU");
		Date date = new Date();
		mParam.put(iIndex++, date);
		
		int iResult = dataSource.exequteSql(sqlQuery, Type.INTEGER, mParam);
		System.out.println("iRes ::= "+iResult);
		
		String[] beanNames = ctx.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println("Bean Name::= "+beanName);
		}
		
		
	}

}
