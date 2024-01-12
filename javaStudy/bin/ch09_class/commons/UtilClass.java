package ch09_class.commons;

public class UtilClass {
	/*
	 * 
	 * param: num 반올림 하고자하는 소수
	 * param: 소수 n번째 자리까지 리턴
	 * return: 반올림된 소수를 리턴
	 */
	public static double weRound(double num, int n) {
		// 1
		//0의 n 제곱 구하기
		int ten =1;
		for (int i =0; i<n; i++) {
			ten *=10;
		}
		num *= ten;
		long temp=Math.round(num);
		double result = (double) temp/ten;
		return result;
	}
	public static void main(String[] args) {
		System.out.println(weRound(75.123456789, 3));
	}

}
