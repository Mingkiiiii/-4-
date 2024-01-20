package practice.coffee;

public class Coffee {

	private String nameKR;
	private String nameEN;
	private int price;

	public Coffee(String nameKR, String nameEN, int price) {

		this.nameKR = nameKR;
		this.nameEN = nameEN;
		this.price = price;
	}

	public String toString() {
		return nameKR + " (" + nameEN + ") - " + price + "원";
	}

	public String getNameKR() {
		return nameKR;
	}

	public String getNameEN() {
		return nameEN;
	}

	public int getPrice() {
		return price;
	}
}
