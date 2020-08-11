package hwjava07_서울_8반_천창민;

public class Tv extends Product{
	private int size;
	private int resolution;
	
	public Tv() { }

	public Tv(String isbn, String name, String company, int price, int stock, int weight, int size, int resolution) {
		super(isbn,name,company,price,stock,weight);
		this.size = size;
		this.resolution = resolution;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TV : [ ");
		builder.append(super.toString());
		builder.append(", size = ");
		builder.append(size);
		builder.append(", resolution = ");
		builder.append(resolution);
		builder.append(" ]");
		return builder.toString();
	}
	
	
	
}
