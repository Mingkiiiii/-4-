package ch13_thread.issac2;

public class Customer extends Thread{
	private Issac issac = Issac.getInstance();
	private String name;
	private int count;
	
	public Customer(String name, int count) {
		this.name = name;
		this.count = count;
	}
	@Override
	public void run() {
		issac.buyToast(name, count);
	}
	
}
