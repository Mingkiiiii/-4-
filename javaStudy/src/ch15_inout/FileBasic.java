package ch15_inout;

import java.io.File;
import java.util.ArrayList;

public class FileBasic {
	public static void main(String[] args) {
		//현재 디렉토리 경로 가져오기
		String path = System.getProperty("user.dir");
		System.out.println(path);
		// 특정 경로 파일 리스트 출력
		File currentFile = new File(path + "/src");
		File [] files = currentFile.listFiles();
		for(int i=0; i<files.length; i++) {
			//경로가 포함되어 있는 파일명
			System.out.println(files[i]);
			// 파일명만 출력
			System.out.println(files[i].getName());
			System.out.println(files[i].isDirectory()); //폴더면 true
			System.out.println(files[i].isFile()); //파일이면 true
		}
		// mkdir 폴더만들기
		File test = new File("c:/dv/test");
		test.mkdir();
		ArrayList<String> stu = new ArrayList<String>();
		stu.add("팽수");
		stu.add("동수");
		stu.add("길수");
		for(int i=0; i<stu.size(); i++) {
			File f = new File("c:/dv/test2"+ stu.get(i));
//			f.mkdir(); // 폴더생성
			test.delete();
		}
	}
}
