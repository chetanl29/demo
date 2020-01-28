package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.CustomDataSource.Type;

public class TestCustomDataSource {

	public static void main(String[] args) {
		boolean bResult = false;
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomDataSource dataSource = context.getBean("customDataSource",CustomDataSource.class);
		Map<Integer,Object> mParam = new HashMap<Integer,Object>();
		mParam.put(1, 2);
		mParam.put(2, "TEST TEST");
		mParam.put(3, 10.0F);
	    //bResult = dataSource.exequteSql("INSERT INTO EMPLOYEE VALUES (?,?,?)", Type.INTEGER, mParam);
		
		/*bResult = dataSource.exequteSql("INSERT INTO EMPLOYEE(ID,NAME,SALARY) VALUES ('3','test test','40.5')", Type.INTEGER, null);
		System.out.println("bResult ::= "+bResult);*/
		
		
		List<Map<String,Object>> list = dataSource.exequteSql("SELECT * FROM EMPLOYEE ", Type.LIST_MAP, null);
		for(Map<String,Object> map : list) {
			System.out.println("Map::= "+map);
		}
		
		mParam.clear();
		mParam.put(1, 1);
		Map<String,Object> map = dataSource.exequteSql("SELECT * FROM EMPLOYEE WHERE ID = ?", Type.MAP_SINGLE_ROW, mParam);
		System.out.println("Map Contents ::= "+map);
		
		bResult = dataSource.exequteSql("SELECT * FROM EMPLOYEE", Type.BOOLEAN, null);
		System.out.println("bResult ::= "+bResult);
		
		String sName = dataSource.exequteSql("SELECT NAME FROM EMPLOYEE ", Type.DEFAULT, null);
		System.out.println("sName ::= "+sName);
	}

}
