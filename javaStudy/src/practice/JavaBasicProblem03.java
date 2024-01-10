package practice;

import java.util.Scanner;

public class JavaBasicProblem03 {
    public static void main(String[] args) {
    	System.out.println("===============Q1==============");
    	int totalCircle = 5834;
        int circle = 360; 
        int gatcha = cal(totalCircle, circle);
        String prize2 = prize(gatcha); 

        
        System.out.println("룰렛은 총 " + (totalCircle / circle) + "바퀴 돌았고, 멈춘 각도는 " + gatcha + "도로, 경품은 " + prize2 + "입니다.");
        
        System.out.println("===============Q2==============");
        Scanner scan = new Scanner(System.in);

        System.out.print("거꾸로 뒤집을 문자열 입력: ");
        String inputString = scan.nextLine();

        String reversedString = reverseString(inputString); 

        System.out.println("뒤집은 결과: " + reversedString);
        
        scan.close();
        
        System.out.println("===============Q3==============");
        int treeLevels = 5; 
        printTree(0, treeLevels); 
        System.out.println("===============거꾸로==============");
        int treeLevels1 = 5;
        printInvertedTree(treeLevels1 - 1, treeLevels1); 
    }
    public static int cal(int totalCircle, int circle) {
        if (totalCircle < circle) {
            return totalCircle;
        } else {
            return cal(totalCircle - circle, circle);
        }
    }

    //Q1
    public static String prize(int gatcha) {
        if (gatcha >= 0 && gatcha < 60) {
            return "사탕";
        } else if (gatcha >= 60 && gatcha < 120) {
            return "초콜릿";
        } else if (gatcha >= 120 && gatcha < 180) {
            return "쿠키";
        } else if (gatcha >= 180 && gatcha < 240) {
            return "콜라";
        } else if (gatcha >= 240 && gatcha < 300) {
            return "아이스크림";
        } else {
            return "커피"; 
        }
    }
    //Q2
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }
    //Q3
    public static void printTree(int currentLevel, int totalLevels) {
        if (currentLevel < totalLevels) {
            printSpaces(totalLevels - currentLevel - 1);
            printStars(2 * currentLevel + 1);
            System.out.println(); 
            printTree(currentLevel + 1, totalLevels); 
        }
    }
    
    public static void printSpaces(int count) {
        if (count > 0) {
            System.out.print(" ");
            printSpaces(count - 1); 
        }
    }

    public static void printStars(int count) {
        if (count > 0) {
            System.out.print("*");
            printStars(count - 1); 
        }
    }
    //거꾸로
    public static void printInvertedTree(int currentLevel1, int totalLevels1) {
        if (currentLevel1 >= 0) {
            printSpaces1(totalLevels1 - currentLevel1 - 1);
            printStars1(2 * currentLevel1 + 1);
            System.out.println(); 
            printInvertedTree(currentLevel1 - 1, totalLevels1); 
        }
    }

    public static void printSpaces1(int count) {
        if (count > 0) {
            System.out.print(" ");
            printSpaces1(count - 1); 
        }
    }

    public static void printStars1(int count) {
        if (count > 0) {
            System.out.print("*");
            printStars1(count - 1);
        }
    }
}

