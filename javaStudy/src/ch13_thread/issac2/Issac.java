package ch13_thread.issac2;

import java.util.LinkedList;
import java.util.Queue;

public class Issac {
	private int toast = 0;
	// 주문 순서를 관리하기 위한 큐
	private final Queue<String> orderList = new LinkedList<>();
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
		// 주문 객체 생성 및 큐에 추가
		orderList.add(name);
		// peek 조회
		while(orderList.peek() != name || toast < count) {
			try {
				wait(); //현재 주문이 맨 앞이 아니거나, 토스트가 충분하지 않으면 대기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		toast -= count;
		System.out.println(name + "에게 토스트를 "+count+"개 팔았습니다.");
		orderList.remove(); // 가장 앞에 있는 주문 제거됨.
		notifyAll(); // 대기중인 주문 처리를 위해 스레드 깨우기.
	}
	
}
