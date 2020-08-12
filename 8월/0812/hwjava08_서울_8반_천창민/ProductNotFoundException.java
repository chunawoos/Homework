package hwjava08_서울_8반_천창민;

public class ProductNotFoundException extends Exception {

	public ProductNotFoundException() {
		super("찾고자 하는 상품이 존재하지 않습니다.");
	}
}
