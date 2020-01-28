package com.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomDataSource {
	
	public enum Type {
		INTEGER,
		DEFAULT,
		MAP_SINGLE_ROW,
		LIST_MAP,
		BOOLEAN
	}
	
	private JdbcTemplate jdbcTemplate;
	
	public CustomDataSource(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public <T>T exequteSql(String sSqlQuery, Type type, Map<Integer,Object> mParam) {
		Object mResult = null;
		if(type == Type.INTEGER) {
			mResult = jdbcTemplate.execute(sSqlQuery, (PreparedStatement ps) -> {
				if(mParam != null) {
					for(int i = 1; i<= mParam.size(); i++) {
						ps.setObject(i, mParam.get(i));
					}
				}
				return ps.executeUpdate() > 0;
			});
		}else {
			mResult = jdbcTemplate.query(sSqlQuery, 
			(PreparedStatement ps) -> {
				if(mParam != null) {
					for(int i =1; i<= mParam.size(); i++) {
						ps.setObject(i, mParam.get(i));
					}
				}
			},  (ResultSet rs) -> {
				Object result = null;
				if(type == Type.MAP_SINGLE_ROW) {
					Map<String,Object> map = new HashMap<String,Object>();
					if(rs.next()) {
						ResultSetMetaData metaData = rs.getMetaData();
						for(int i = 1; i <= metaData.getColumnCount(); i++) {
							Object value = rs.getObject(i);
							map.put(metaData.getColumnName(i), value);
						}
					}
					result = map;
				}else if(type == Type.LIST_MAP) {
					List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
					while(rs.next()) {
						ResultSetMetaData metaData = rs.getMetaData();
						Map<String,Object> map = new HashMap<String,Object>();
						for(int i = 1; i <= metaData.getColumnCount(); i++) {
							Object value = rs.getObject(i);
							map.put(metaData.getColumnName(i), value);
						}
						list.add(map);
					}
					result = list;
				}else if(type == Type.DEFAULT) {
					Object value = "";
					if(rs.next()) {
						ResultSetMetaData metaData = rs.getMetaData();
						value =  rs.getObject(metaData.getColumnName(1));
					}
					result = value;
				}else if(type == Type.BOOLEAN) {
					boolean bValue = rs.next();
					result = bValue;
				}
				return result;
			});
		}
		return (T) mResult;
	}

}
