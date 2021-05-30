package kr.or.connect.diex01;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration 
//스프링 설정 Annoytaion 
public class ApplicationConfig {
	@Bean
	public Car car (Engine e) {
		Car car = new Car();
		car.setEngine(e);
		return car;

	}

	@Bean
	public Engine engine() {
		return new Engine();
	}
}
