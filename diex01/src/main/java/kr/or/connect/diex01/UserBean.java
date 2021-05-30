package kr.or.connect.diex01;

public class UserBean {

	/*
	 * 1) 기본생성자를 가지고있다.
	 * 2) 필드는 private하게 선언한다.
	 * 3) getter,setter 매소드를 가진다. getName(), setName() 매소드를 name 프로퍼티라고 한다.
	 */
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	private int age;
	private boolean male;
	
	
}
