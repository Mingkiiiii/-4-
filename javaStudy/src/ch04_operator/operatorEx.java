package ch04_operator;


import java.util.Scanner;

public class operatorEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이메일 주소를 입력해주세요: ");
        String email = scanner.nextLine();

        if (email.indexOf("@") != -1) {
            System.out.println("(사용가능)");
        } else {
            System.out.println("(이메일형식이 아님)");
        }
    }
}
