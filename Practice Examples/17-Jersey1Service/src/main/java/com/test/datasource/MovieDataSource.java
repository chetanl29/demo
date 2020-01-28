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
import javax.sql.DataSource;

public class MovieDataSource {

	private String sDefaultDataSource = "jdbc/movie";

	private Connection con = null;

	public enum Type {
		INTEGER,
		DEFAULT,
		BOOLEAN,
		MAP_SINGLE_ROW,
		LIS_MAP
	}

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
			dataSource = (DataSource) envCtx.lookup(this.sDefaultDataSource);
			con = dataSource.getConnection();

		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Does connection exists "+(con != null));
		return con;
	}

	public <T> T exequteSql(String sqlQuery, Type type) {
		return exequteSql(sqlQuery, type, null);
	}
	public <T> T exequteSql(String sqlQuery, Type type , Object oParam ) {
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		ResultSetMetaData metaData = null;
		Object mResult = null;
		Map<Integer,Object> mParam 		= null;
		List<Map<Integer,Object>> ldata = null;
		if(con == null) {
			con = getConection();
		}
		if(oParam instanceof Collection<?>) {
			ldata = (List<Map<Integer, Object>>) oParam;
		}else if(oParam instanceof Map<?, ?>) {
			mParam = (Map<Integer, Object>) oParam;
		}
		try {
			pstmt = con.prepareStatement(sqlQuery);
			if(mParam != null) {
				 for(int i = 1; i <= mParam.size(); i++) {
					 Object obj = mParam.get(i);
					 if(obj == null) {
						 System.out.println("Setting null value");
					 }
					 pstmt.setObject(i, obj);
				 }
			}
			
			if(ldata != null) {
				for(Map<Integer,Object> mSqlParam : ldata) {
					if(mSqlParam != null) {
						for(int i = 1; i <= mSqlParam.size(); i++) {
							Object obj = mSqlParam.get(i);
							if(obj == null) {
								System.out.println("Setting null value");
							}
							pstmt.setObject(i, obj);
						}
						pstmt.addBatch();
					}
				}
			}
			
			if(type == Type.INTEGER) {
				if(mParam != null) {
					mResult = pstmt.executeUpdate();
				}else {
					mResult = pstmt.executeBatch();
				}
			}else {
				rs = pstmt.executeQuery();
				metaData = rs.getMetaData();
				switch(type) {
				case LIS_MAP:
					List<Map<String,Object>> lResult = new ArrayList<Map<String,Object>>();
					while(rs.next()) {
						Map<String,Object> mRes = new HashMap<String,Object>();
						for(int i = 1; i <= metaData.getColumnCount(); i++) {
							Object value = rs.getObject(metaData.getColumnName(i));
							mRes.put(metaData.getColumnName(i).toUpperCase(), value);
						}
						lResult.add(mRes);
					}
					mResult = lResult;
					break;
				case MAP_SINGLE_ROW:
					Map<String, Object> mRes = new HashMap<String,Object>();
					if(rs.next()) {
						for(int i = 1; i <= metaData.getColumnCount(); i++) {
							Object value = rs.getObject(metaData.getColumnName(i));
							mRes.put(metaData.getColumnName(i), value);
						}
					}
					mResult = mRes;
					break;
				case DEFAULT:
					Object value = null;
					if(rs.next()) {
						value = rs.getObject(1);
					}
					mResult = value;
					break;
				case BOOLEAN:
					mResult = rs.next();
					break;
				default:
					break;
				}
			}
			if(rs != null) {
				rs.close();
				rs = null;
			}
			
			if(pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			
			if(con != null) {
				con.close();
				con = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return (T) mResult;
	}

}
