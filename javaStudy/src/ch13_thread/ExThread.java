package ch13_thread;

public class ExThread extends Thread{
	int num;
	
	public ExThread(int num, String name) {
		super(name);
		this.num = num;
	}

	@Override
	public void run() {
		for(int i = num; i<=num + 5; i++) {
			// 현재 실행중인 Thread 이름 출력
			System.out.println(super.getName() + " "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
