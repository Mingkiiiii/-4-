package practice.coffee;

import java.util.Scanner;

public class CafeTest {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cafe starbucks = new Cafe("스타벅스");
        starbucks.addCoffee(new Coffee("아메리카노", "Americano", 5000));
        starbucks.addCoffee(new Coffee("카푸치노", "Cappuccino", 6000));
        starbucks.addCoffee(new Coffee("오곡라떼", "Five Grain Latte", 7000));

        Cafe akaCafe = new Cafe("아카 카페");
        akaCafe.addCoffee(new Coffee("아메리카노", "Americano", 2500));
        akaCafe.addCoffee(new Coffee("바닐라라떼", "Vanilla Latte", 3000));
        akaCafe.addCoffee(new Coffee("아이스티", "Iced Tea", 3500));

        boolean running = true;
        while (running) {
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 스타벅스 방문 | 2. 아카 방문 | 3. 사무실 복귀..");
            System.out.print(">>> ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    visitCafe(starbucks);
                    break;
                case 2:
                    visitCafe(akaCafe);
                    break;
                case 3:
                    System.out.println("사무실로 복귀합니다...");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
        scanner.close();
    }

    private static void visitCafe(Cafe cafe) {
        System.out.println("어서오세요, " + cafe.getName() + "입니다.");
        cafe.printMenu();
        System.out.print("메뉴를 선택해주세요: ");
        int menuChoice = scanner.nextInt() - 1;

        try {
            Coffee selectedCoffee = cafe.getCoffees().get(menuChoice);
            System.out.println(selectedCoffee.getNameKR() + "를 " + selectedCoffee.getPrice() + "원에 구매했습니다.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("잘못된 메뉴를 선택하셨습니다. 메뉴를 다시 확인해주세요.");
        }
    }
}