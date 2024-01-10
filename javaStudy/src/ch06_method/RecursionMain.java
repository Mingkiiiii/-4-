package ch06_method;

public class RecursionMain {

	public static void main(String[] args) {
		Func(5);
		System.out.println(factorial(5));
		System.out.println(factorial(10));
		System.out.println(factorial(15));
		System.out.println(recfactorial(5));
		System.out.println(recfactorial(10));
		System.out.println(recfactorial(15));
		grades("홍길동", 82.5, 76.7, 91.5);
		

	}	
	//재귀함수
	public static void Func(int num) {
		//재귀함수는 멈추는게 중요 (잘못하면 무한루프)
		if(num == 0) {
			return;
		}else {
			System.out.println("hi");
			//자신을 호출
			Func(num -1);
		}
	}
	// factorial
	public static long factorial(int num) {
		long sum =1;
		for(int i=1; i <=num; i++) {
			sum *=i;
		}
		return sum;
	}
	// 재귀함수 활용 factorial
	public static long recfactorial(int num) {
		if(num==1) {
			return 1;
		}
		/*3을 입력받았다면
		 * 3 * recfactorial(2)
		 * 3 * 2* recfactorial(1)
		 */
		return num * recfactorial(num-1);
	}
	
	// 이름, 국어점수, 수학점수, 영어점수를 입력받아
	// 평균과 등급을 출력하는 메소드를 작성하시오
	// input : String, int, int, int
	// output : x없음
	// 평균이 90 이상 A, 80이상 B, 나머지 C
	// a님의 평균은 (소수점2째자리까지 출력)으로 y등급입니다. 출력
	public static void grades(String name, double kr, double math, double english) {
        double average =(kr+ math + english) / 3;
        char grade;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else {
            grade = 'C';
        }

        System.out.println("===============학생카드==================");
        System.out.println("이름: "+name);
        System.out.println("국어: "+kr);
        System.out.println("수학: "+math);
        System.out.println("영어: "+english);
        System.out.printf("%s님의 평균은 %.2f으로 %s등급입니다.\n", name, average, grade);
    }

}
