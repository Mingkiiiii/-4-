package ch15_inout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Diary {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdf.format(new Date());
		String filePath = "diary.txt";
		File file = new File(filePath);
		try {
			// 바이트 단위로 데이터를 쓸 수 있음
			FileOutputStream fos = new FileOutputStream(file, true);
			// 문자열을 바이트로 변경(getBytes)
			fos.write((currentDate+ "의 일기\n").getBytes());
			while(true) {
				System.out.println("오늘의 일기를 작성하세요. exit를 입력하면 종료.");
				String msg = scan.nextLine();
				if("exit".equalsIgnoreCase(msg)) {
					System.out.println("종료 합니다.");
					break;
				}
				fos.write((msg + "\n").getBytes());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
