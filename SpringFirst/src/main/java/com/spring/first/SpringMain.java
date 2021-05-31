package com.spring.first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring.xml");
		
		MiTv tv1 = ctx.getBean("mitv",MiTv.class);
		MiTv tv2 = ctx.getBean("mitv",MiTv.class);
		//tx.getBean("mitv",MiTv.class)=("ID",리턴타입) 캐스팅 불필요
		//MiTv tv1 = (MiTv) ctx.getBean("mitv"); 캐스팅 필요
		tv1.volumeUp();
		
	}

}
