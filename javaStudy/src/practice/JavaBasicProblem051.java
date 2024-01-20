package practice;

public class JavaBasicProblem051 {
    public static void main(String[] args) {
    	System.out.println("------------Q1------------");
    	printCard("김명기", "010-8751-2894", "audrl3692@naver.com");
    	System.out.println("------------Q2------------");
    	String[] nameList = {
                "강성준","권보성", "권유빈", "김기찬", "김대영", "김동우", "김동현", "김명기",
                "김영주", "김유정", "김은혜", "김휘건", "나항진", "문성민", "박진기", "백현진",
                "오정연", "유하영", "이예진", "이용빈", "정유진"
            };
            
            SearchName("김", nameList);
            System.out.println("------------Q3------------");
            int[] intArr = {23, 456, 213, 32, 464, 1, 2, 4};
            MinMax(intArr);
    }
    
    public static void printCard(String name, String contact, String email) {
    	System.out.println("===================================");
        System.out.println("이름 : " + name);
        System.out.println("연락처 : " + contact);
        System.out.println("이메일 : " + email);
        System.out.println("===================================");
    }
    public static void SearchName(String lastName, String[] nameList) {
        int count = 0;
        StringBuilder namesWithLastName = new StringBuilder();

        for(String name : nameList) {
            if(name.startsWith(lastName)) {
                count++;
                namesWithLastName.append(name).append("씨 ");
            }
        }

        System.out.println("=========================");
        System.out.println(lastName + "씨 성을 가진 동기분이 총 " + count + "명 있습니다.");
        System.out.println(namesWithLastName);
        System.out.println("=========================");
    }
    public static void MinMax(int[] array) {
        int min = array[0];
        int max = array[0];
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        
        System.out.println("최댓값: " + max);
        System.out.println("최솟값: " + min);
    }
}
