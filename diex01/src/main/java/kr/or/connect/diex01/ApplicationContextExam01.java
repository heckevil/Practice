package kr.or.connect.diex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {
	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml"); // 공장규격
		// ClassPathXmlApplicationContext = API ()=파라미터는 Xml안에 bean정보 넣어놨으니 규격에 맞게 사용하라
		System.out.println("초기화 완료!!");

		UserBean userBean = (UserBean) ac.getBean("userBean"); // 공장 만들어!

		userBean.setName("Kang");

		System.out.println(userBean.getName());

		UserBean userBean2 = (UserBean) ac.getBean("userBean");

		if (userBean == userBean) {
			System.out.println("같은 인스턴스 입니다.");
			// 싱글톤 패턴이라 객체를 계속 만드는게 아니라 하나 만들어논 Bean을 이용하는 것이다.
			System.out.println("userBean2 name : " + userBean2.getName());
			userBean2.setName("Kim");
			System.out.println("");
			System.out.println("userBean name : " + userBean.getName());
			
			//객체를 계속만들어도 같은 객체이다. 객체복사?

		}
	}
}
