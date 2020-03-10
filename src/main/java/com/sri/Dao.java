package com.sri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class Dao {
	
	@Autowired
	private HibernateTemplate ht;
	
	public Person getbyid(Integer id) {
		
		Person p=this.ht.get(Person.class, id);
		return p;
		
	}

}
