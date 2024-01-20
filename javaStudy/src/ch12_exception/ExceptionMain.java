package ch12_exception;

import java.text.ParseException;

public class ExceptionMain {

	public static void main(String[] args) {
		System.out.println("메인 시작!");
		int [] arr = {1, 2, 3};
		String aString = null;
		try {
//			System.out.println(arr[3]);
			aString.length();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스문제군!!!!");
		} catch (Exception e) {
			System.out.println("문제다!!!");
			e.printStackTrace();
		}
		System.out.println("메인 종료!");
		
		try {
			ExMethod.printName("길");
		} catch (BizException e) {
			System.out.println(e.getErrCode());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println(ExMethod.dataMillSec2("2024/01/18"));
		try {
			System.out.println(ExMethod.dataMillSec("20240118"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		System.out.println("종료");

	}

}
