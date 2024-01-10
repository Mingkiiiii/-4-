package ch06_method;

public class Grade {
	

    public static int calculateFinalDegree(int totalCircle, int circle) {
        if (totalCircle < circle) {
            return totalCircle;
        } else {
            return calculateFinalDegree(totalCircle - circle, circle);
        }
    }

    
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

    public static void main(String[] args) {
        int totalCircle = 5834;
        int circle = 360; 
        int gatcha = calculateFinalDegree(totalCircle, circle);
        String prize2 = prize(gatcha); 

        
        System.out.println("룰렛은 총 " + (totalCircle / circle) + "바퀴 돌았고, 멈춘 각도는 " + gatcha + "도로, 경품은 " + prize2 + "입니다.");
    }
}
