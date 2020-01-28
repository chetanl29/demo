package com.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.JdbcConfig;
import com.test.datasource.CustomDataSource;
import com.test.datasource.CustomDataSource.Type;

public class TestCustomDataSourceUsingJavaConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(JdbcConfig.class);
		CustomDataSource dataSource = context.getBean("customDataSource", CustomDataSource.class);

		String sqlQuery = "INSERT INTO MOVIES(MOVIE_NAME,MOVIE_LANGUAGE,MOVIE_RELEASE_DATE) VALUES(?,?,?)";
		int iIndex = 1;
		Map<Integer,Object> mParam = new HashMap<Integer, Object>();
		mParam.put(iIndex++, "SYE RAA");
		mParam.put(iIndex++, "TELUGU");
		Date date = new Date();
		mParam.put(iIndex++, date);
		
		int iResult = dataSource.exequteSql(sqlQuery, Type.INTEGER, mParam);
		System.out.println("iRes ::= "+iResult);
		
		context.close();
	}

}
