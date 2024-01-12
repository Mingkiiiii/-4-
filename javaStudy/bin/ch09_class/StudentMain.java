package ch09_class;

import java.util.ArrayList;

public class StudentMain {

	public static void main(String[] args) {
		Student stu = new Student();
		Student pangsu = new Student("팽수"); // new Class 인스턴스화 (객체생성)
		Student nick = new Student("nick");
		System.out.println(pangsu.getName());
		System.out.println(nick.getName());
		nick.check();
		Student judy = new Student("주디", 100, 90, 80);
		Student jack = new Student("잭", 80, 99, 70);
		System.out.println(judy.getKor());
		ArrayList<Student> stuList = new ArrayList<Student>();
		stuList.add(judy);
		stuList.add(jack);
		for(int i=0; i< stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}
		judy.setKor(60);
		System.out.println(judy);
		

	}

}
