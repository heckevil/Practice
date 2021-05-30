package kr.or.connect.diex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam02 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		Car car = (Car) ac.getBean("c");
		//Car 만드는데 bean넣었던 놈을 get해서 가져온다
		//이걸 사용하기 위헤 컨테이너인 ApplicationContext 사용
		car.run();
		//엔진 시동할때 엔진 필요없음.
	}
	
}
