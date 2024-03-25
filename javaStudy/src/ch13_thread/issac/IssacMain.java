package ch13_thread.issac;

public class IssacMain {

	public static void main(String[] args) {
		// 오픈전
		System.out.println("오픈 전 주문 받기");
		Customer cust1 = new Customer("팽수", 5);
		Customer cust2 = new Customer("동길", 2);
		Customer cust3 = new Customer("길수", 5);
		cust1.start();
		cust2.start();
		cust3.start();
		System.out.println("오픈 !!");
		
		Chef chef = new Chef(10);
		chef.endCook = new EndCook() {
			@Override
			public void endOfCook() {
				System.out.println("토스트완성!!!");
			}
		};
		chef.start();
		Chef chef2 = new Chef(4);
		chef2.endCook = new EndCook() {
			
			@Override
			public void endOfCook() {
				System.out.println("너무 쉽군 !! 토스트 완성");
				
			}
		};
		chef2.start();
	}

}
