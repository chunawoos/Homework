package hwjava07_서울_8반_천창민;
import java.util.ArrayList;
import java.util.Iterator;


public class ProductMgrImpl implements IProductMgr{

	ArrayList<Product> list = new ArrayList<>();

	@Override
	public void add(Product p) {
		list.add(p);
	}

	@Override
	public ArrayList<Product> search() {
		return list;
	}

	@Override
	public Product searchIsbn(String isbn) {
		Iterator<Product> itr = list.iterator();
		while(itr.hasNext()) {
			Product p = itr.next();
			if(p.getIsbn().equals(isbn))
				return p;
		}
		return null;
	}

	@Override
	public ArrayList<Product> searchName(String name) {
		ArrayList<Product> tmp = new ArrayList<>();
		Iterator<Product> itr = list.iterator();
		while(itr.hasNext()) {
			Product p = itr.next();
			if(p.getName().contains(name))
				tmp.add(p);
		}
		return tmp;
	}

	@Override
	public ArrayList<Product> searchTv() {
		ArrayList<Product> tmp = new ArrayList<>();
		Iterator<Product> itr = list.iterator();
		while(itr.hasNext()) {
			Product p = itr.next();
			if(p instanceof Tv)
				tmp.add(p);
		}
		return tmp;
	}

	@Override
	public ArrayList<Product> searchRefrigerator() {
		ArrayList<Product> tmp = new ArrayList<>();
		Iterator<Product> itr = list.iterator();
		while(itr.hasNext()) {
			Product p = itr.next();
			if(p instanceof Refrigerator)
				tmp.add(p);
		}
		return tmp;
	}

	@Override
	public ArrayList<Product> searchRefVolume(int volume) {
		ArrayList<Product> tmp = new ArrayList<>();
		Iterator<Product> itr = list.iterator();
		while(itr.hasNext()) {
			Product p = itr.next();
			if(p instanceof Refrigerator && ((Refrigerator) p).getVolume() >= volume)
				tmp.add(p);
		}
		return tmp;
	}

	@Override
	public ArrayList<Product> searchTvSize(int size) {
		ArrayList<Product> tmp = new ArrayList<>();
		Iterator<Product> itr = list.iterator();
		while(itr.hasNext()) {
			Product p = itr.next();
			if(p instanceof Tv && ((Tv) p).getSize() >= size)
				tmp.add(p);
		}
		return tmp;
	}

	@Override
	public void changePrice(String isbn, int price) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getIsbn().equals(isbn)) {
				list.get(i).setPrice(price);
				break;
			}
		}
	}

	@Override
	public void delete(String isbn) {
		Iterator<Product> itr = list.iterator();
		while(itr.hasNext()) {
			Product p = itr.next();
			if(p.getIsbn().equals(isbn)) {
				itr.remove();
				break;
			}
		}
	}

	@Override
	public int totalPrice() {
		int sum = 0;
		Iterator<Product> itr = list.iterator();
		while(itr.hasNext()) {
			Product p = itr.next();
			sum += p.getPrice()*p.getStock();
		}
		return sum;
	}
	
	
}
