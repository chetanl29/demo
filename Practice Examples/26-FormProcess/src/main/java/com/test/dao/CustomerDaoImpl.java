package com.test.dao;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private JdbcTemplate template;

	/* (non-Javadoc)
	 * @see com.test.CustomerDao#save(com.test.model.Customer)
	 */
	@Override
	public void save(Customer customer) {
		String sql = "INSERT INTO CUSTOMER(NAME,AGE) VALUES (?,?)";
		Object[] values = new Object[] {customer.getsCustomerName(), customer.getCustomerAge()};
		int[] types = new int[] {Types.VARCHAR, Types.INTEGER};
		int iRes = template.update(sql,values,types);
		System.out.println("iRes = "+iRes);
	}
	
}
