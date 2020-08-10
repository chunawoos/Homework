package hwjava06_서울_8반_천창민;
import java.util.Arrays;

public class ProductMgr {
	
	private Product [] product = new Product[100];
	private int index;
	
	public void add(Product p) {
		product[index] = p;
		index += 1;
	}
	
	public Product [] search() {
		Product[] tmp = Arrays.copyOf(product, index);
		return tmp;
	}
	
	public Product searchIsbn(String isbn) {
		for(Product p : product)
			if(p.getIsbn().equals(isbn))
				return p;
		return null;
	}
	
	public Product [] searchName(String name) {
		int cnt = 0;
		for(int i=0; i<index; i++) {
			if(product[i].getName().contains(name))
				cnt++;
		}
		Product [] tmp = new Product[cnt];
		cnt = 0;
		for(int i=0; i<index; i++) {
			if(product[i].getName().contains(name))
				tmp[cnt++] = product[i];
		}
		return tmp;
	}
	
	public Product [] searchTv() {
		int cnt = 0;
		for(Product p : product) 
			if(p != null && p instanceof Tv)
				cnt++;
		Product [] tmp = new Product[cnt];
		cnt=0;
		for(Product p : product) 
			if(p != null && p instanceof Tv)
				tmp[cnt++] = p;
		
		return tmp;
	}
	
	public Product [] searchRefrigerator() {
		int cnt = 0;
		for(Product p : product) 
			if(p != null && p instanceof Refrigerator)
				cnt++;
		Product [] tmp = new Product[cnt];
		cnt=0;
		for(Product p : product) 
			if(p != null && p instanceof Refrigerator)
				tmp[cnt++] = p;
		
		return tmp;
	}
	
	public void delete(String isbn) {
		for(int i=0; i<index; i++) {
			if(product[i].getIsbn().equals(isbn)) {
				product[i] = product[index-1];
				index -= 1;
			}
		}
	}
	
	public int totalPrice() {
		
		int sum = 0;
		
		for(int i=0; i<index; i++) {
			sum += product[i].getPrice()*product[i].getStock();
		}
		return sum;
	}
}
