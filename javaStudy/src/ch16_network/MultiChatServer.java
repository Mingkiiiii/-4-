package ch16_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Class Name : MultiChatServer
 * Author :MYEONGGI
 * Created Date : 2024. 2. 21.
 * Version      :  1.0
 * Purpose		: 멀티채팅 서버
 * Desciption	: 소켓서버, 클라이언트 관리
 */
public class MultiChatServer {
	// 접속 클라이언트에게 메세지를 보내기위해 클라이언트 관리 배열
	private ArrayList<Client> clientList = new ArrayList<>();
	public static void main(String[] args) {
		MultiChatServer server = new MultiChatServer();
		server.serverStart(); // 서버시작
	}
	public void serverStart() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(9001);
			System.out.println("9001포트 서버 start!");
			while(true) {
				Socket soc = server.accept(); // 클라이언트 접속 대기
				System.out.println("요청 수락!");
				System.out.println(soc.getRemoteSocketAddress()); // 접속자 ip
				Client client = new Client(soc);
				client.start();
				clientList.add(client); // 접속자 담아놓기
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 접속 클라이언트에게 메세지를 전해주기 위한 class(
	public class Client extends Thread{
		Socket soc;
		PrintWriter writer;
		String name;
		public Client(Socket soc) {
			this.soc = soc;
			try {
				writer = new PrintWriter(soc.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 접속 클라이언트 모두에게 메세지 전송
		public void sendAll(String msg) {
			for(int i=0; i < clientList.size(); i++) {
				clientList.get(i).writer.print(msg);
				clientList.get(i).writer.flush();
			}
		}
		@Override
		public void run() {
			
			// 접속시 다른 사용자들에게 접속알림.
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				name = reader.readLine(); // 입장시 닉네임을 전달받음
				sendAll(name+ "님이 입장하셨습니다.");
				while(true) {
					String msg = reader.readLine();
					if(msg == null || msg.isEmpty()) {
						break;
					}
					sendAll(msg); // 전체에게 전송
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// 종료시 다른 사용자들에게 퇴장 알림.
				sendAll(name + "님이 퇴장하셨습니다.");
				clientList.remove(this);
				if(soc != null) try {soc.close();} catch (IOException e) {}
			}
			
		}
		
	}

}
