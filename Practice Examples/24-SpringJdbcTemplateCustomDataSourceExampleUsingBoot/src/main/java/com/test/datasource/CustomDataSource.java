package com.test.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomDataSource {

	public enum Type { INTEGER ,BOOLEAN, DEFAULT, MAP_SINGLE_ROW, LIST_MAP }

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public <T>T exequteSql(String sqlQuery, Type type){
		return exequteSql(sqlQuery, type , null);
	}

	public <T>T exequteSql(String sqlQuery, Type type, Object oParam) {
		Object mResult = null;

		if(type == Type.INTEGER) {
			if(oParam instanceof Collection<?>) {
				List<Map<Integer,Object>> lmData = (List<Map<Integer, Object>>) oParam;
				mResult = jdbcTemplate.batchUpdate(sqlQuery, new BatchPreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						Map<Integer,Object> mParam = lmData.get(i);
						for(int j = 1; j <= mParam.size(); j++) {
							ps.setObject(j, mParam.get(j));
						}	
					}

					@Override
					public int getBatchSize() {
						return lmData.size();
					}
				});
			}else if(oParam instanceof Map<?, ?>) {
				Map<Integer,Object> mParam = (Map<Integer, Object>) oParam;
				mResult = jdbcTemplate.execute(sqlQuery, (PreparedStatement ps)->{
					if(mParam != null) {
						for(int i = 1; i <= mParam.size() ; i++) {
							ps.setObject(i, mParam.get(i));
						}
					}
					return ps.executeUpdate();
				});
			}
		}else {
			Map<Integer,Object> mParam = (Map<Integer, Object>) oParam;
			mResult = jdbcTemplate.query(sqlQuery, (PreparedStatement ps) ->{
				if(mParam != null) {
					for(int i = 1 ;i <= mParam.size() ;i++) {
						ps.setObject(i, mParam.get(i));
					}
				}
			}, (ResultSet rs) -> {
				Object oRes = null;
				switch(type) {
				case BOOLEAN:
					oRes = rs.next();
					break;
				case DEFAULT:
					oRes = rs.getObject(1);
					break;
				case MAP_SINGLE_ROW:
					Map<String,Object> mRet = new HashMap<String,Object>();
					ResultSetMetaData meta = rs.getMetaData();
					if(rs.next()) {
						for(int i = 1; i <= meta.getColumnCount();i++) {
							String key = meta.getColumnName(i);
							mRet.put(key, rs.getObject(key));
						}
					}
					oRes = mRet;
					break;
				case LIST_MAP:
					List<Map<String,Object>> lRet = new ArrayList<Map<String,Object>>();
					ResultSetMetaData metaData = rs.getMetaData();
					while(rs.next()) {
						Map<String,Object> mRetData = new HashMap<String,Object>();
						for(int i = 1; i <= metaData.getColumnCount();i++) {
							String key = metaData.getColumnName(i);
							mRetData.put(key, rs.getObject(key));
						}
						lRet.add(mRetData);
					}
					oRes = lRet;
					break;
				default: 
					break;
				}
				return oRes;
			});
		}

		return (T) mResult;
	}
}
