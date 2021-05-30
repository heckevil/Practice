package kr.or.connect.diex01;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	public Engine() {
		System.out.println("엔진생성자");
	}

	public void exec() {
		System.out.println("엔진이 작동합니다");
	}
}
