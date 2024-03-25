package ch16_network;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

	public static void main(String[] args) {
		int port = 5001;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("서버가 포트 "+port+ "에서 실행중..");
			// 클라이언트 접속을 기다림
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트 연결됨.");
			// 파일 수신
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			// 파일 이름과 크기 읽기
			String fileName = dis.readUTF();
			long fileSize = dis.readLong();
			// 파일 저장
			FileOutputStream fos = new FileOutputStream(fileName);
			byte[]buffer = new byte[10000]; // 전송하는 쪽이랑 같아야함
			int read = 0;
			long totalRead =0;
			int remaining = (int) fileSize;
			while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining)))>0) {
														// 최대 or 남은만큼 읽어오기
				totalRead += read;
				remaining -= read;
				System.out.println("파일 수신 중:"+totalRead+"바이트("+(totalRead * 100/fileSize)+ "%)");
				fos.write(buffer,0,read);
			}
			System.out.println("파일 수신 완료: " + fileName);
			fos.close();
			dis.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
