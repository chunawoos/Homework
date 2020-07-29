

public class ProductMgr {
	private Product [] prod = new Product[100];
	private int index;
	
	private static ProductMgr instance;
	
	private ProductMgr() {}
	
	public static ProductMgr getInstance() {
		if(instance == null)
			instance = new ProductMgr();
		return instance;
	}
	
	public void add(Product p) {
		for(int i=0; i<100; i++) {
			if(prod[i] == null) {
				prod[i] = p;
				index ++;
				break;
			}
		}
	}
	
	public void list() {
		for(int i=0; i<index; i++) {
			System.out.println(prod[i]);
		}
	}
	
	public void list(int num) {
		for(int i=0; i<index; i++) {
			if(prod[i].getnum() == num) 
				System.out.println(prod[i]);
			break;
		}
	}
	
	public void delete(int num) {
		for(int i=0; i<index; i++) {
			if(prod[i].getnum() == num) {
				prod[i] = prod[index-1];
				index--;
			}
			break;
		}
	}
	
	public void priceList(int price) {
		for(int i=0; i<index; i++) {
			if(prod[i].getPrice() <= price)
				System.out.println(prod[i]);
		}
	}

}
