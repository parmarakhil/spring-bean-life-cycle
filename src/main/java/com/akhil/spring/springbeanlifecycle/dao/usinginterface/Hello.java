package com.akhil.spring.springbeanlifecycle.dao.usinginterface;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello  implements InitializingBean , DisposableBean{
	
	@Override
	public void afterPropertiesSet() {
		System.out.println(" this is init method using InitializingBean interface");
	}
	
	@Override
	public void destroy() {
		System.out.println(" this is destroy method using disposableBean interface");
	}
	
	
}
