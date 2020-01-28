package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MovieDataSource {
	
	private String sDefaultDataSource = "jdbc/movie";
	private Connection con = null;
	
	public MovieDataSource() {
		this.con = getConection();
	}

	private Connection getConection() {
		Context initCtx = null, envCtx = null;
		DataSource dataSource = null;
		Connection con = null;
		
		
		try{
			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/movie");
			con = dataSource.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Does connection exists "+(con != null));
		return con;
	}
	
	public <T> T exequteSql(String sqlQuery) {
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		ResultSetMetaData metaData = null;
		Object mResult = null;
		if(con == null) {
			con = getConection();
		}
		
		try {
			pstmt = con.prepareStatement(sqlQuery);
			rs = pstmt.executeQuery();
			metaData = rs.getMetaData();
			
			List<Map<String,Object>> lResult = new ArrayList<Map<String,Object>>();
			while(rs.next()) {
				Map<String,Object> mRes = new HashMap<String,Object>();
				for(int i = 1; i<= metaData.getColumnCount();i++) {
					Object value = rs.getObject(metaData.getColumnName(i));
					mRes.put(metaData.getColumnName(i).toUpperCase(), value);
					lResult.add(mRes);
				}
			}
			
			mResult = lResult;
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return (T) mResult;
	}

}
