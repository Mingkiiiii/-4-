package ch11_java_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class ApiMath {

    public static void main(String[] args) {
        // Math 클래스는 수학에서 사용되는 여러가지 함수들을 메서드로 제공
        final double PI = 3.141592;
        // 반올림 round
        long roundPI = Math.round(PI);
        System.out.println(roundPI);
        // 소수 넷째 자리에서 반올림
        double fourPI = (Math.round(PI * 1000)) / 1000.0;
        System.out.println(fourPI);
        // 올림 ceil
        double ceilPI = Math.ceil(PI);
        System.out.println(ceilPI);
        // 내림 floor
        double floorPI = Math.floor(PI);
        System.out.println(floorPI);
        // 절대값 abs
        int minus = -10;
        System.out.println(Math.abs(minus));
        // 제곱 pow (3의 4제곱)
        double powVal = Math.pow(3, 4);
        System.out.println(powVal);
        // 제곱근 sqrt
        System.out.println(Math.sqrt(4));
        // 랜덤 숫자(난수) 생성
        for(int i = 0; i < 100; i++) {
            System.out.println(randomCard());
        }
        // 1~45 사이의 랜덤 숫자
        int lotto = (int)(Math.random() * 45) + 1;
        System.out.println(lotto);
        // 10~20 사이의 랜덤 숫자
        int ranNum = (int)(Math.random() * 11) + 10;
        System.out.println(ranNum);

        ArrayList<String> classMateList = new ArrayList<String>(Arrays.asList(
                "강성준", "권보성", "권유빈", "김기찬", "김대영", "김동우",
                "김동현", "김명기", "김영주", "김유정", "김은혜", "김휘건",
                "나항진", "문성민", "박진기", "백현진", "오정연", "유하영",
                "이예진", "이용빈", "정유진"
        ));

        HashMap<String, String> resultHashMap = randomGame(classMateList);
        Set<String> keySet = resultHashMap.keySet();
        for(String key : keySet) {
            System.out.println(key + "님은 " + resultHashMap.get(key));
        }
    }

    public static String randomCard() {
        String result;
        Random random = new Random();
        // 1~100 사이의 정수
        int num = random.nextInt(100) + 1;
        // 10% 확률로 당첨
        if(num <= 10) {
            result = "당첨";
        } else {
            result = "꽝";
        }
        return result;
    }

    public static HashMap<String, String> randomGame(ArrayList<String> arr) {
        HashMap<String, String> resultMap = new HashMap<>();
        for(int i = 0; i < arr.size(); i++) {
            resultMap.put(arr.get(i), randomCard());
        }
        return resultMap;
    }

}
