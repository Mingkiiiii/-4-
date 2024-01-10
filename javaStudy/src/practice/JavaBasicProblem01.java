package practice;

public class JavaBasicProblem01 {

	public static void main(String[] args) {
		System.out.println("=============Q1============ ");
		
		        String name = "김명기";
		        int age = 26;
		        double height = 168.5;
		        String phone = "010-8751-2894";
		        String email = "audrl3692@naver.com";

		        System.out.println("이름: " + name);
		        System.out.println("나이: " + age + "세");
		        System.out.println("키: " + height + "cm");
		        System.out.println("연락처: " + phone);
		        System.out.println("이메일: " + email);
		        
		        System.out.println("=============Q2============ ");
		        String words = "너오구늘리뭐너먹구지리";

		        // "너" 제거
		        String del1 = words.replace("너", "");

		        // "구" 제거
		        String del2 = del1.replace("구", "");

		        // "리" 제거
		        String del3 = del2.replace("리", "");

		        System.out.println("1차 암호 해독[너 제거]: " + del1);
		        System.out.println("2차 암호 해독[구 제거]: " + del2);
		        System.out.println("3차 암호 해독[리 제거]: " + del3);
		        System.out.println("해독완료!! ->" + del3);
		        System.out.println("=============Q3============ ");
		        int example = 278;
		        int sum = 0;

		        
		        if (example > 0) {
		            int digit1 = example / 100; // 백의 자리
		            int digit2 = (example / 10) % 10; // 십의 자리
		            int digit3 = example % 10; // 일의 자리
		            
		            sum = digit1 + digit2 + digit3;
		        }

		        System.out.println("결과는: " + sum);
		    }
		}


	


