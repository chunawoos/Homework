

public class ProductTest {

	public static void main(String[] args) {
		Tv tv = new Tv("33333","QLED 8K 84inch infinity Screen",18400000, 3, 84, "QLED");
		Tv tv_n = new Tv();
		tv_n.setIsbn("31577");
		tv_n.setName("Crystal UHD 64inch 스탠드형");
		tv_n.setPrice(1790000);
		tv_n.setAmount(1);
		tv_n.setInch(64);
		tv_n.setType("UHD");
		Refrigerator rf = new Refrigerator("9965","셰프컬렉션 900L 다크 크롬 프레임",8980000, 7,900);
		Refrigerator rf_n = new Refrigerator();
		rf_n.setIsbn("7777");
		rf_n.setName("BESPOKE 냉장고 4도어 프리스탠딩 871 L Glam White");
		rf_n.setPrice(3060000);
		rf_n.setAmount(2);
		rf_n.setVolume(871);
		System.out.println(tv.getIsbn() + " " + tv.getName() + " " + tv.getPrice() + " " + tv.getPrice() + " " + tv.getAmount() + " " + tv.getInch() + " " + tv.getType());
		System.out.println(tv_n.toString());
		System.out.println(rf.getIsbn() + " " + rf.getName() + " " + rf.getPrice() + " " + rf.getAmount() + " " + rf.getVolume());
		System.out.println(rf_n.toString());
		
	}

}
