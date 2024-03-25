package ch13_thread.issac2;

public class Chef extends Thread{
	private Issac issac = Issac.getInstance();
	private int count;
	public EndCook endCook;
	public Chef(int count) {
		this.count = count;
	}
	@Override
	public void run() {
		// Issac 클래스의 makeToast
		for(int i=0; i<count; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			issac.makeToast(); // 1초에 1개씩 토스트 생산
		}
		endCook.endOfCook(); // 쉐프 인스턴스마다 다른 endCook메서드를 오버라이딩하여 사용
	}
	
}
