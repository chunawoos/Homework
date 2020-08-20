package hwjava14_서울_8반_천창민;

public class Product {
	private String isbn;
	private String name;
	private int price;
	private int stock;

	public Product() {  }

	public Product(String isbn, String name, int price, int stock) {
		this.isbn = isbn;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("상품번호 = ");
		builder.append(isbn);
		builder.append(", 상품명 = ");
		builder.append(name);
		builder.append(", 상품가격 = ");
		builder.append(price);
		builder.append(", 재고수량 = ");
		builder.append(stock);
		return builder.toString();
	}
	
	
}
