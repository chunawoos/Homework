

public class Tv {
	private String isbn;
	private String name;
	private int price;
	private int amount;
	private int inch;
	private String type;
	
	public Tv(String isbn,String name, int price, int amount, int inch, String type) {
		this.isbn = isbn;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.inch = inch;
		this.type = type;
	}
	public Tv() {}
	
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
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Tv 정보 : isbn= " + isbn + "\t|" + "name= " + name + "\t|" + "price= " + price + "Won" + "\t|" + "amount= " + amount + "ea" + "\t|" + "inch= " + inch + "\t|"
				+ "type= " + type + "\t|" ;
	}
	
	
}
