package com.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.EmployeeDao;
import com.test.dao.StudentDao;
import com.test.entity.Employee;
import com.test.entity.Student;

public class TestJdbcTemplate {

	public static void main(String[] args) {
		int iResult = 0;
		boolean bResult = false;
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDao empDao = context.getBean("employeeDao",EmployeeDao.class);
		StudentDao stuDao  = context.getBean("studentDao",StudentDao.class);
		
		/*Data Insertion using update()*/
		iResult = empDao.saveEmployee(new Employee(2,"TEST",1));
		System.out.println("iResult ::= "+iResult);
		
		/*Data Updation using update()*/
		/*iResult = empDao.updateEmployee(new Employee(2,"TEST",25000));
		System.out.println("iResult ::= "+iResult);*/
		
		/*Data Deletion using update()*/
		/*iResult = empDao.deleteEmployee(new Employee(2, "TEST", 25000));
		System.out.println("iResult ::= "+iResult);*/
		
		/*Data Insertion using executeUpdate() by PreparedStatement*/
		/*bResult = empDao.saveEmployeeByPreparedStatement(new Employee(2, "TEST", 10000));
		System.out.println("bResult ::= "+bResult);*/
		
		/*To get all employees using query() and ResultSetExtractor*/
		List<Map<String,Object>> list = empDao.getAllEmployees();
		for(Map<String,Object> map : list) {
			System.out.println("Map Contents ::= "+map);
		}
		
		/*To get specific employee using query(), PreparedStatementSetter and  ResultSetExtractor*/
		Map<String,Object> map = empDao.getEmployee(1);
		System.out.println("map ::= "+map);
		for(Map.Entry<String, Object> test : map.entrySet()) {
			System.out.println("Key ::= "+test.getKey());
			System.out.println("Value ::= "+test.getValue());
		}
		
		/*To get all employees using query() and RowMapper*/
		List<Map<String,Object>> listRow = empDao.getAllEmployeesByRowMapper();
		for(Map<String,Object> tempRow : listRow) {
			System.out.println("Temp Row ::= "+tempRow);
		}
		
		bResult = stuDao.saveStudent(new Student(1, "CHETAN", 2000));
		System.out.println("bResult ::= "+bResult);
	}

}
