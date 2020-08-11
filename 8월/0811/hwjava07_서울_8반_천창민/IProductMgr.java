package hwjava07_서울_8반_천창민;
import java.util.ArrayList;
import java.util.Arrays;

public interface IProductMgr {
	
	public void add(Product p);
	public ArrayList<Product> search() ;
	public Product searchIsbn(String isbn);
	public ArrayList<Product> searchName(String name) ;
	public ArrayList<Product> searchTv();
	public ArrayList<Product> searchRefrigerator();
	public ArrayList<Product> searchRefVolume(int volume) ;
	public ArrayList<Product> searchTvSize(int size) ;
	public void changePrice(String isbn, int price);
	public void delete(String isbn) ;
	public int totalPrice() ;

}
