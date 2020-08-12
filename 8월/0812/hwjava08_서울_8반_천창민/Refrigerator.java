package hwjava08_서울_8반_천창민;


public class Refrigerator extends Product {
	private int volume;
	private int temperature;

	public Refrigerator() { }

	public Refrigerator(String isbn, String name, String company, int price, int stock, int weight, int volume, int temperature) {
		super(isbn,name,company,price,stock,weight);
		this.volume = volume;
		this.temperature = temperature;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Refrigerator [ ");
		builder.append(super.toString());
		builder.append(", volume = ");
		builder.append(volume);
		builder.append(", temperature = ");
		builder.append(temperature);
		builder.append("]");
		return builder.toString();
	}

}
