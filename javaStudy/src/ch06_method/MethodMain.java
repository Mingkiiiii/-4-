package ch06_method;

import java.security.PublicKey;

/**
 * Class Name : MethodMain
 * Author :MYEONGGI
 * Created Date : 2024. 1. 8.
 * Version      :  1.0
 * Purpose		: Method
 * Desciption	:
 */
public class MethodMain {

	public static void main(String[] args) {
		//method(메소드) 클래스나 객체에 종속된 함수
		//java는 모두 class에 작성되기 때문에 메소드라 부름
		//1~100까지 더하면 결과는?
		//1~50까지 더하면 결과는?
		//30~60까지 더하면 결과는?
		int sum=0;
		for(int i =30; i<=60; i++) {
			sum+=i;
		}
		System.out.println(sum);
		//메소드 실행
		printSum(1, 100);
		printSum(1, 50);
		printSum(30, 60);
		int res = returnSum(1, 30);
		System.out.println("리턴 받은 값: " + res);
//		printSum("30", "60"); //오류 타입이 맞지 않음
		//메소드 생성
		//[접근제어자 static] 리턴타입 메소드명(파라미터) { }
		print("hi");
		print(13);
		System.out.println(abs(-10));
		System.out.println(abs(10));
		System.out.println(abs2(20));
		System.out.println(abs2(-20));
	}
	public static void printSum(int from, int to) {
		int sum = 0;
		for(int i =from; i<=to; i++) {
			sum+=i;
		}
		System.out.printf("from : %d 부터 to : %d까지 합은:%d \n", from, to , sum);
	}
	public static int returnSum(int from, int to) {
		int sum = 0;
		for(int i =from; i<=to; i++) {
			sum+=i;
		}
		return sum;
	}
	public static void print(String msg) {
		System.out.println(msg);
	}
	//메소드 오버로딩 동일한 이름의 메소드를 다른 입력과, 리턴으로 정의할 수 있음.
	public static void print(int msg) {
		System.out.println(msg);
	}
	
	// 정수를 입력받아 절대값을 정수형으로 리턴하는 메소드를 작성하시오 ! (1번째 방법)
	
	public static int abs(int num) {
		return (num < 0) ? -num : num;
	    }
	// 정수를 입력받아 절대값을 정수형으로 리턴하는 메소드를 작성하시오 ! (2번째 방법)
	public static int abs2(int num2) {
		if(num2 < 0) {
			num2 *=-1;
		}
		return num2;
	}
}



