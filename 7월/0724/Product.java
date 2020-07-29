

public class Product {
	private int num;
	private String name;
	private int price;
	private int amount;
	
	public Product() { }

	public Product(int num, String name, int price, int amount) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public int getnum() {
		return num;
	}

	public void setnum(int num) {
		this.num = num;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("제품 정보 :num=");
		builder.append(num);
		builder.append("\n\tname=");
		builder.append(name);
		builder.append("\n\tprice=");
		builder.append(price);
		builder.append("원 \n\tamount=");
		builder.append(amount);
		builder.append("개");
		
		return builder.toString();
	}
	
	

}
