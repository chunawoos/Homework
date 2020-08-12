package hwjava08_서울_8반_천창민;

public class CodeNotFoundException extends Exception {

	public CodeNotFoundException() {
		super("검색하신 상품 번호가 존재하지 않습니다.");
	}
}
