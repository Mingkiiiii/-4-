package practice;

import java.util.Scanner;
import java.util.Random;

public class Practice4 {
    public static void main(String[] args) {
        
    	System.out.println("==============Q1===============");
    	Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int answer = random.nextInt(50) + 1;
        int chance = 5;

        System.out.println("1~50 사이의 숫자를 맞춰보세요!");

        while (chance > 0) {
            System.out.print("숫자를 입력해주세요 : ");
            int guess = scan.nextInt();

            if (guess == answer) {
                System.out.println("정답입니다!");
                break;
            } else if (guess < answer) {
                System.out.println("업!! 기회가 " + --chance + "번 남았습니다.");
            } else {
                System.out.println("다운!! 기회가 " + --chance + "번 남았습니다.");
            }

            if (chance == 0) {
                System.out.println("실패하였습니다. 정답은 " + answer + "입니다.");
            }
        }

        scan.close();
        
        
    }
}
