package com.sri;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan("com.sri")
public class Ourconfiguration {
	
	@Bean
	public BasicDataSource bds() {
		
		BasicDataSource bds= new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/abc");
		bds.setUsername("root");
		bds.setPassword("root");
		return bds;
		
	}
	@Bean
	public LocalSessionFactoryBean lsf() {
		
		LocalSessionFactoryBean lsf =new LocalSessionFactoryBean();
		lsf.setDataSource(bds());
		lsf.setAnnotatedClasses(Person.class);
		Properties p=new Properties();
		p.setProperty("show_sql", "true");
		p.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
		lsf.setHibernateProperties(p);
		return lsf;
		
		
	}
	
	@Bean
	public HibernateTemplate ht() {
		
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(lsf().getObject());
		return ht;
}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
