package ch16_network;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient {

	public static void main(String[] args) {
		System.out.println("fileclient 화면");
		String host = "localhost"; //ip
		int port = 5001;
		String filepath = "c:/dv/filetest/recipe.zip"; // 전송파일 경로
		try {
			Socket socket = new Socket(host,port);
			System.out.println("서버에 연결됨!!");
			// 파일 전송을 위한 출력 스트림
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			FileInputStream fis = new FileInputStream(filepath);
			File file = new File(filepath);
			// 파일이름과 크기를 전송
			dos.writeUTF(file.getName());
			dos.writeLong(file.length());
			byte[]buffer = new byte[10000]; //4KB
			int read;
			while((read = fis.read(buffer)) > 0) {
				dos.write(buffer,0,read);
			}
			System.out.println("파일 전송 완료: " + filepath);
			fis.close();
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
