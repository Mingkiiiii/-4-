package ch16_network;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("채팅방에 입장하시려면 닉네임을 입력하세오: ");
			String nm = scan.nextLine();
			Socket soc = new Socket("192.168.30.1", 9001);
			System.out.println("접속 성공 !!!");
			// 데이터 송수신
			SendThread send = new SendThread(soc, nm);
			ReceiveThread receive = new ReceiveThread(soc);
			send.start();
			receive.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
