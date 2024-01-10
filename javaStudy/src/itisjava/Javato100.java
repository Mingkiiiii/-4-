package itisjava;

import java.util.Scanner;

public class Javato100 {
    private static int elevatorA = 10;
    private static int elevatorB = 4;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("============== 엘리베이터 ==============");
            System.out.println("승강기 A의 현재 위치: " + elevatorA);
            System.out.println("승강기 B의 현재 위치: " + elevatorB);
            System.out.print("몇 층에 계시나요? [종료는 q 또는 exit]: ");
            String input = scan.nextLine();

            
            if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

           
            try {
                int userFloor = Integer.parseInt(input);
                moveElevator(userFloor);
            } catch (NumberFormatException e) {
                System.out.println("유효한 층수를 입력해주세요.");
            }
        }

        scan.close();
    }

    private static void moveElevator(int userFloor) {
        int distanceA = Math.abs(elevatorA - userFloor);
        int distanceB = Math.abs(elevatorB - userFloor);

        if (distanceA < distanceB || (distanceA == distanceB && elevatorA > elevatorB)) {
            System.out.println("엘리베이터 A가 " + userFloor + "층으로 이동하였습니다.");
            elevatorA = userFloor;
        } else {
            System.out.println("엘리베이터 B가 " + userFloor + "층으로 이동하였습니다.");
            elevatorB = userFloor;
        }
    }
}
