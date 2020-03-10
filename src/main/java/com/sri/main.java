package com.sri;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
	public static void main(String[] args) {
		
		
		ApplicationContext context=new AnnotationConfigApplicationContext(Ourconfiguration.class);
		Dao dao=context.getBean(Dao.class);
		
		Person p=dao.getbyid(1);
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}

}
