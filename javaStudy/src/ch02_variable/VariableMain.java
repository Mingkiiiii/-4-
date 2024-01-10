package ch02_variable;

public class VariableMain {

	public static void main(String[] args) {
		//상수 (Constant) 변경 불가
	//	final double MATH_PI - 3.14;
		//MATH_PI = 4.23; //오류남(상수는 변경이 안되기 때문)
		double mathPi2 =3.11;
		mathPi2 = 3.14; //변수는 변경가능
		
		//문자열 String 타입은 클래스로 관리되어짐.(다양한 메소드(함수)를 내장하고 있음)
		String fruits = "Apple, Banana, Cherry";
		//.length() 문자열의 길이를 리턴
		System.out.println(fruits);
		System.out.println("길이 :"+fruits.length());
		//.charAt(인덱스)
		System.out.println("3인덱스:" + fruits.charAt(3));
		//.index0f(문자열)
		// 해당 String에서 '문자열'을 찾아서 첫번째 인덱스를 반환 존재하지 않으면 -1반환
		System.out.println("Banana 시작인덱스:" +  fruits.indexOf("Banana"));
		//.substring(시작 인덱스) 해당 문자열의 시작 인덱스 부터 끝까지 자른다.
		//.substring(시작, 종료인덱스) 해당 문자열의 시작 인덱스부터 끝 인덱스 전까지 자른다.
		System.out.println(fruits.substring(15));
		System.out.println(fruits.substring(7, 13));
		// .replace(바뀔 문자열, 바꿀 문자열)
		System.out.println(fruits.replace("Cherry","Chamwui"));
		// ,를 찾아서 |로 변경하시오
		System.out.println(fruits.replace(",","|"));
		//다음 문자열에서 @를 기준으로 앞과 뒤를 각각 출력하시오
		//leeapgil
		//gmail.com
		String email = "leeapgil@gmail.com";
		System.out.println(email);
		System.out.println(fruits.substring(3));
		
	}

	public static void main(String[] args) {
		//상수 (Constant) 변경 불가
	//	final double MATH_PI - 3.14;
		//MATH_PI = 4.23; //오류남(상수는 변경이 안되기 때문)
		double mathPi2 =3.11;
		mathPi2 = 3.14; //변수는 변경가능
		
		//문자열 String 타입은 클래스로 관리되어짐.(다양한 메소드(함수)를 내장하고 있음)
		String fruits = "Apple, Banana, Cherry";
		//.length() 문자열의 길이를 리턴
		System.out.println(fruits);
		System.out.println("길이 :"+fruits.length());
		//.charAt(인덱스)
		System.out.println("3인덱스:" + fruits.charAt(3));
		//.index0f(문자열)
		// 해당 String에서 '문자열'을 찾아서 첫번째 인덱스를 반환 존재하지 않으면 -1반환
		System.out.println("Banana 시작인덱스:" +  fruits.indexOf("Banana"));
		//.substring(시작 인덱스) 해당 문자열의 시작 인덱스 부터 끝까지 자른다.
		//.substring(시작, 종료인덱스) 해당 문자열의 시작 인덱스부터 끝 인덱스 전까지 자른다.
		System.out.println(fruits.substring(15));
		System.out.println(fruits.substring(7, 13));
		// .replace(바뀔 문자열, 바꿀 문자열)
		System.out.println(fruits.replace("Cherry","Chamwui"));
		// ,를 찾아서 |로 변경하시오
		System.out.println(fruits.replace(",","|"));
		//다음 문자열에서 @를 기준으로 앞과 뒤를 각각 출력하시오
		//leeapgil
		//gmail.com
		String email = "leeapgil@gmail.com";
		System.out.println(email);
		System.out.println(email.substring(0, 7));
		System.out.println(email.substring(9, 18));
	}

}
