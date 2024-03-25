package ch13_thread.issac;


public class Issac {
	private int toast = 0;
	private Issac() {
	}
	// 싱글톤 적용
	private static Issac instance = new Issac();
	public static Issac getInstance() {
		return instance;
	}
	// 토스트 만들기(chef 클래스가 사용)
	// synchronized 멀티스레딩 환경에서 여러 스레드가 동시에 객체나
	// 메서드나 블록에 접근하는 것을 방지하여 데이터의 일관성과 동기화를 유지하는데 사용
	public synchronized void makeToast() {
		toast +=1;
		System.out.println("토스트를 하나 만들었습니다. 재고:" + toast);
		notifyAll(); // 대기중(wait() )인 모든 스레드를 깨운다.
	}
	// 토스트 구매(customer 클래스가 사용)
	public synchronized void buyToast(String name, int count) {
		while(toast < count) {
			try {
				wait(); // 재고가 충분할 때까지 대기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		toast -= count;
		System.out.println(name + "에게 토스트를 "+count+"개 팔았습니다.");
	}
	
}
