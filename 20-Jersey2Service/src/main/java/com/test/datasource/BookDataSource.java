package com.test.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDataSource {

	private String sDefaultDataSource  = "jdbc/book";

	private Connection con = null;

	public enum Type {INTEGER, MAP_SINGLE_ROW, LIST_MAP, DEFAULT, BOOLEAN}

	public BookDataSource() {
		this.sDefaultDataSource = "jdbc/book";
		this.con = getConnection();
	}

	private Connection getConnection() {
		Context initCtx = null, envCtx = null;
		DataSource dataSource = null;
		Connection con = null;
		try {
			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup(this.sDefaultDataSource);
			con = dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public <T> T exequteSql(String sqlQuery, Type type) {
		return exequteSql(sqlQuery, type, null);
	}

	@SuppressWarnings("unchecked")
	public <T> T exequteSql(String sqlQuery, Type type, Object oParam)  {
		Object oResult = null;
		Map<Integer,Object> mParam 		= null;
		List<Map<Integer,Object>> ldata = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData metaData = null;

		if(oParam instanceof Collection<?>) {
			ldata = (List<Map<Integer, Object>>) oParam;
		}else if(oParam instanceof Map<?, ?>) {
			mParam = (Map<Integer, Object>) oParam;
		}
		try {
			ps = con.prepareStatement(sqlQuery);

			if(mParam != null) {
				for(int i = 1;i <= mParam.size();i++) {
					Object obj = mParam.get(i);
					if(obj == null) {
						System.out.println("Setting null value.");
					}
					ps.setObject(i, obj);
				}
			}else if(ldata != null) {
				for(Map<Integer,Object> mSqlParam : ldata) {
					if(mSqlParam != null) {
						for(int i = 1; i <= mSqlParam.size(); i++) {
							Object obj = mSqlParam.get(i);
							if(obj == null) {
								System.out.println("Setting null value.");
							}
							ps.setObject(i, obj);
						}
						ps.addBatch();
					}
				}
			}

			if(type == Type.INTEGER) {
				if(mParam != null) {
					oResult = ps.executeUpdate();
				}else {
					oResult = ps.executeBatch();
				}
			}else {
				rs = ps.executeQuery();
				metaData = rs.getMetaData();
				switch(type) {
					case DEFAULT:
						Object val = null;
						if(rs.next()) {
							val = rs.getObject(1);
						}
						oResult = val;
						break;
					case BOOLEAN:
						oResult = rs.next();
						break;
					case MAP_SINGLE_ROW:
						Map<String,Object> mRetData  = new HashMap<String, Object>();
						if(rs.next()) {
							for(int i = 1; i <= metaData.getColumnCount(); i++) {
								Object value = rs.getObject(metaData.getColumnName(i));
								mRetData.put(metaData.getColumnName(i), value);
							}
						}
						oResult = mRetData;
						break;
					case LIST_MAP:
						List<Map<String,Object>> lret = new ArrayList<Map<String,Object>>();
						while(rs.next()) {
							Map<String,Object> mTempData = new HashMap<String,Object>();
							for(int i = 1; i <= metaData.getColumnCount(); i++ ) {
								Object oVal = rs.getObject(metaData.getColumnName(i));
								mTempData.put(metaData.getColumnName(i), oVal);
							}
							lret.add(mTempData);
						}
						oResult = lret;
						break;
					default: 
						break;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(rs != null) {
					rs.close();
					rs = null;
				}

				if(ps != null) {
					ps.close();
					ps = null;
				}
				
				if(con != null) {
					con.close();
					con = null;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return (T) oResult;

	}

}
