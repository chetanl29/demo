package com.test.config;

import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.test.model.Customer;

import org.springframework.orm.hibernate5.HibernateTemplate;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages= {"com.test.dao","com.test.service"})
public class RootConfig {

	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(dataSource);
		
		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		/*props.put("hibernate.use_sql_comments", "true");
		props.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
*/
		lsfb.setHibernateProperties(props);
		//lsfb.setMappingResources(new String[] { "Customer.hbm.xml" });
		lsfb.setAnnotatedClasses(Customer.class);

		return lsfb;
	}
	
	
	@Bean(autowire = Autowire.BY_TYPE)
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate();
	}
	
	
}
