package hwjava08_서울_8반_천창민;
import java.util.ArrayList;
import java.util.Arrays;

public interface IProductMgr {
	
	public void add(Product p) throws DuplicateException;
	public ArrayList<Product> search() ;
	public Product searchIsbn(String isbn) throws CodeNotFoundException;
	public ArrayList<Product> searchName(String name) ;
	public ArrayList<Product> searchTv();
	public ArrayList<Product> searchRefrigerator();
	public ArrayList<Product> searchRefVolume(int volume) throws ProductNotFoundException ;
	public ArrayList<Product> searchTvSize(int size) throws ProductNotFoundException;
	public void changePrice(String isbn, int price) throws CodeNotFoundException; 
	public void delete(String isbn) throws CodeNotFoundException ;
	public int totalPrice() ;

}
