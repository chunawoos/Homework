

public class Refrigerator {
	private String isbn;
	private String name;
	private int price;
	private int amount;
	private int volume;
	
	public Refrigerator(String isbn, String name, int price, int amount, int volume) {
		this.isbn = isbn;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.volume = volume;
	}
	public Refrigerator () {}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Refrigerator 정보 : isbn= " + isbn + "\t|" + "name= " + name + "\t|" + "price= " + price + "Won" + "\t|" + "amount= " + amount +"ea" + "\t|" + "volume= "
				+ volume +"L" + "\t|";
	}
	
	
	
}
