package com.akhil.spring.springbeanlifecycle.dao.usingannotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("hi")
public class Hi {
	
	@PostConstruct
	public void init() {
		System.out.println("called init method of Hi class using @PostConstruct annotation");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println(" called destory method of Hi class using @PreDestory annotation");
	}

}
