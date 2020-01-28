package com.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.config.JdbcConfig;
import com.test.datasource.CustomDataSource;
import com.test.datasource.CustomDataSource.Type;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={JdbcConfig.class})
public class TestCustomDataSourceUsingJunit {
	
	@Autowired
	ApplicationContext context;
	
	@Test
	public void jdbcConfig() {
		CustomDataSource dataSource = context.getBean("customDataSource", CustomDataSource.class);
		String sqlQuery = "INSERT INTO MOVIES(MOVIE_NAME,MOVIE_LANGUAGE,MOVIE_RELEASE_DATE) VALUES(?,?,?)";
		int iIndex = 1;
		Map<Integer,Object> mParam = new HashMap<Integer, Object>();
		mParam.put(iIndex++, "saahoo");
		mParam.put(iIndex++, "TELUGU");
		Date date = new Date();
		mParam.put(iIndex++, date);
		
		int iResult = dataSource.exequteSql(sqlQuery, Type.INTEGER, mParam);
		System.out.println("iRes ::= "+iResult);
	}

}
