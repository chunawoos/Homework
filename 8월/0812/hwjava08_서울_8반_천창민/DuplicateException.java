package hwjava08_서울_8반_천창민;

public class DuplicateException extends Exception {

	public DuplicateException() {
		super("입력하신 상품은 이미 존재하는 상품입니다.");
	}
}
