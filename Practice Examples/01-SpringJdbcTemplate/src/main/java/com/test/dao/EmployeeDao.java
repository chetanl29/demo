package com.test.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.test.entity.Employee;

@Component
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public EmployeeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int saveEmployee(Employee emp) {
		StringBuilder sSqlQuery = new StringBuilder("INSERT INTO EMPLOYEE VALUES('"+emp.getEmpId());
		sSqlQuery.append("', '"+emp.getEmpName()+"','"+emp.getEmpSalary()+"') ");
		return jdbcTemplate.update(sSqlQuery.toString());
	}
	
	public int updateEmployee(Employee emp) {
		StringBuilder sSqlQuery = new StringBuilder("UPDATE EMPLOYEE SET NAME = '").append(emp.getEmpName());
		sSqlQuery.append("', SALARY = '").append(emp.getEmpSalary()).append("' WHERE ID = '");
		sSqlQuery.append(emp.getEmpId()).append("' ");
		return jdbcTemplate.update(sSqlQuery.toString());
	}
	
	public int deleteEmployee(Employee emp) {
		StringBuilder sSqlQuery = new StringBuilder("DELETE FROM EMPLOYEE WHERE ID = '").append(emp.getEmpId());
		sSqlQuery.append("' ");
		return jdbcTemplate.update(sSqlQuery.toString());
	}
	
	public boolean saveEmployeeByPreparedStatement(Employee emp) {
		StringBuilder sSqlQuery = new StringBuilder("INSERT INTO EMPLOYEE VALUES (?,?,?)");
		
		boolean bResult = jdbcTemplate.execute(sSqlQuery.toString(), (PreparedStatement ps)-> {//Lambda expression for PreparedStatementCallback interface
			ps.setInt(1, emp.getEmpId());
			ps.setString(2, emp.getEmpName());
			ps.setFloat(3, emp.getEmpSalary());
			return ps.executeUpdate() > 0;
		});
		
		System.out.println("bResult :::::::::::::::= "+bResult);
		return bResult;
	}
	
	public <T>T getAllEmployees() {
		Object mResult = null;
		StringBuilder sSqlQuery = new StringBuilder("SELECT * FROM EMPLOYEE ");
		List<Map<String,Object>> resulist = jdbcTemplate.query(sSqlQuery.toString(), (ResultSet rs) -> {// Lambda Expression for ResultSetExtractor
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String,Object>();
				ResultSetMetaData metaData = rs.getMetaData();
				for(int i = 1; i <= metaData.getColumnCount(); i++) {
					Object value = rs.getObject(i);
					map.put(metaData.getColumnName(i), value);	
				}
				list.add(map);
			}
			return list;
		});
		mResult = resulist;
		return (T) mResult;
	}
	
	public <T>T getEmployee(int id) {
		Object mResult = null;
		StringBuilder sSqlQuery = new StringBuilder("SELECT * FROM EMPLOYEE WHERE ID = ? ");
		Map<String,Object> resultMap = jdbcTemplate.query(sSqlQuery.toString(), (PreparedStatement ps) ->{ ps.setObject(1, id); }, (ResultSet rs) -> {
			Map<String,Object> map = new HashMap<String,Object>();
			if(rs.next()) {
				ResultSetMetaData metaData = rs.getMetaData();
				for(int i = 1; i<= metaData.getColumnCount(); i++ ) {
					Object value = rs.getObject(i);
					map.put(metaData.getColumnName(i), value);
				}
			}
			return map;
		});
		//Lambda Expression for PreparedStatementCallback and RowMapper Interface

		/*Map<String,Object> resultMap = jdbcTemplate.query(sSqlQuery.toString(), (ResultSet rs) -> {
			Map<String,Object> map = new HashMap<String,Object>();
			if(rs.next()) {
				ResultSetMetaData metaData = rs.getMetaData();
				for(int i = 1; i<= metaData.getColumnCount(); i++ ) {
					Object value = rs.getObject(i);
					map.put(metaData.getColumnName(i), value);
				}
			}
			return map;
		});*/
		
		mResult = resultMap;
		return (T) mResult;
	}
	
	public List<Map<String,Object>> getAllEmployeesByRowMapper() {  
		StringBuilder sSqlQuery = new StringBuilder("SELECT * FROM EMPLOYEE");
		List<Map<String,Object>> list = jdbcTemplate.query(sSqlQuery.toString(), (ResultSet rs, int rowNum) -> {
			Map<String,Object> map = new HashMap<String,Object>();
			ResultSetMetaData metaData = rs.getMetaData();
			for(int i =1; i<= metaData. getColumnCount();i++) {
				Object value = rs.getObject(i);
				map.put(metaData.getColumnName(i), value);	
			}
			return map;
		});
		
		return list;
	}
	
	
	/*, (ResultSet rs, int rowNumber) -> {
		Map<String,Object> map = new HashMap<String,Object>();
		while(rs.next()) {
			ResultSetMetaData metaData = rs.getMetaData();
			for(int i =1; i<= metaData. getColumnCount();i++) {
				Object value = rs.getObject(i);
				map.put(metaData.getColumnName(i), value);
				return map;
			}
		}
	}*/
	
	
	
}
