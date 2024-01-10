package practice;
import java.util.Scanner;
public class JavaBasicProblem02 {

	public static void main(String[] args) {
		System.out.println("===========Q1============== ");
	
		        Scanner scan = new Scanner(System.in);
		        
		        System.out.print("국어 점수를 입력하세요: ");
		        int kor = scan.nextInt();
		        
		        System.out.print("영어 점수를 입력하세요: ");
		        int en = scan.nextInt();
		        
		        System.out.print("수학 점수를 입력하세요: ");
		        int math = scan.nextInt();

		        int ave = (kor + en + math) / 3;
		        char grade;
		        
		        if (ave >= 90) {
		            grade = 'A';
		        } else if (ave >= 80) {
		            grade = 'B';
		        } else if (ave >= 70) {
		            grade = 'C';
		        } else {
		            grade = 'D';
		        }

		        System.out.println("평균점수: " + ave);
		        System.out.println("등급: " + grade);
		        
		        System.out.println("===========Q2============== ");
		        //10팩토
		        int fac = 1;
		        for (int i = 1; i <= 10; i++) {
		            fac *= i;
		        }
		        System.out.println("10팩토리얼의 값: " + fac);
		        
		        //15팩토
		        long fact = 1;
		        for (int i = 1; i <= 15; i++) {
		            fact *= i;
		        }
		        System.out.println("15팩토리얼의 값: " + fact);
		        
		        System.out.println("===========Q3============== ");
		        String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";
		        String tg = "월리";
		        int count = 0;
		        int Index = 0;

		        while ((Index = findWally.indexOf(tg, Index)) != -1 ) {
		            count++;
		            Index += tg.length();
		        }

		        System.out.println("결과: " + count);

		        System.out.println("===========Q4============== ");
		        for (int i = 5; i >= 1; i--) {
		            for (int j = 1; j <= i; j++) {
		                System.out.print("*");
		            }
		            System.out.println();
		        }

				


		    
		

		
		        		    }
		}


	


