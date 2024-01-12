package ch09_class;

import java.util.ArrayList;

public class Dictionary {
	// 전역적으로 사용하는 상수
	public static final int OPTION_STU_NM = 0;
	public static final int OPTION_CODING_WORD = 0;
	public static final int OPTION_RANDOM_ALPH =2;
	
	public static ArrayList<String> makeWordList(int option){
		ArrayList<String> wordList = new ArrayList<String>();
		// option 0 학생목록, 1 java용어, 2.랜덤 알파벳
		if(option == OPTION_STU_NM) {
			wordList.add("Kim MYEONGGI");
		}else if(option ==OPTION_CODING_WORD) {
			wordList.add("Class");
			wordList.add("public");
			wordList.add("for");
			wordList.add("while");
			wordList.add("method");
		}else if(option ==OPTION_RANDOM_ALPH) {
			//랜덤 알파벳
			String [] alphabet = "qwertyuiopasdfghjklzxcvbnm".split("");
			//10개만 담기
			for(int i=0;i<10;i++) {
				String word = "";
				for(int j=0; j<6;j++) {
					int randIdx = (int)(Math.random()*alphabet.length);
					word+=alphabet[randIdx];
				}
				wordList.add(word);
			}
		}
		return wordList;
	}
	

}
