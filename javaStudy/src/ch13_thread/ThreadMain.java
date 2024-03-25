package ch13_thread;

import oracle.net.aso.i;

public class ThreadMain {

	public static void main(String[] args) {
		// 기본적으로 스레드를 나눠주지 않으면
		// 메인 스레드 하나만 일을 해서 위에서 부터 차례대로 코드가 진행됨
		print(20);
		System.out.println("==========================");
		print(50);
		System.out.println("Thread====================");
		// Thread 상속 받은 클래스 사용
		ExThread ex1 = new ExThread(20, "팽수");
		ex1.start();
		ExThread ex2 = new ExThread(100, "길동");
		ex2.start();
		System.out.println("메인 스레드 끝");
		// Runnable 인터페이스 구현 클래스 사용
		ExRunnable exRun = new ExRunnable(300, "동수");
		Thread dongsu = new Thread(exRun);
		dongsu.start();
		
		Thread jack = new Thread(new ExRunnable(400, "잭"));
		jack.start();
		
		// 3. 람다식 사용
		Thread judy = new Thread(()->{
			int num = 600;
			for(int i = num; i<=num+5; i++) {
				System.out.println("주디" + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		judy.start();
	}
	public static void print(int num) {
			for(int i = num; i<=num + 5; i++) {
				// 현재 실행중인 Thread 이름 출력
				System.out.println(i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	
}


