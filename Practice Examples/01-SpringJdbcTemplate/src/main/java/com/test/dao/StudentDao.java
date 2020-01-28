package com.test.dao;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.test.entity.Student;

@Component
public class StudentDao {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public StudentDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public boolean saveStudent(Student stu) {
		boolean bResult = false;
		StringBuilder sSqlQuery = new StringBuilder("INSERT INTO STUDENT VALUES(:sId,:sName,:sFees)");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sId", stu.getStuId());
		map.put("sName", stu.getStuName());
		map.put("sFees", stu.getStuFees());
		
		bResult = namedParameterJdbcTemplate.execute(sSqlQuery.toString(), map ,(PreparedStatement ps) -> {
			return ps.executeUpdate() >= 1;
		});
		return bResult;
	}

}
