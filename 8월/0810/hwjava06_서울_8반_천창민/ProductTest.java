package hwjava06_서울_8반_천창민;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgr mgr = new ProductMgr();
		Product p = new Product("33333","QLED 8K 84inch infinity Screen","SamSung",18400000, 3, 20);
		mgr.add(p);
		mgr.add(new Tv("31577","Crystal UHD 64inch 스탠드형","SamSung",1790000,1,24, 80, 1980));
		
		mgr.add(new Refrigerator("9965","셰프컬렉션 900L 다크 크롬 프레임","SamSung",8980000, 7,60,900,19));
		mgr.add(new Refrigerator("7777","BESPOKE 냉장고 4도어 프리스탠딩 871 L Glam White","SamSung", 3060000, 2,80,871, 15));
		
		mgr.add(new Product("3333","동원참치","동원",3290, 100, 1));
		
		System.out.println("=====모두검색===========");
		Product [] p1 =mgr.search();
		for(Product pd : p1)
			System.out.println(pd);
		
		System.out.println("\n=====isbn 검색===========");
		Product p2 = mgr.searchIsbn("3333");
		System.out.println(p2);
		
		System.out.println("\n=====name 검색===========");
		Product[] p3 = mgr.searchName("inch");
		for(Product pd : p3)
			System.out.println(pd);
		
		System.out.println("\n=====Tv만 검색===========");
		Product[] p4 = mgr.searchTv();
		for(Product pd : p4)
			System.out.println(pd);
		
		System.out.println("\n=====Refrigerator만 검색===========");
		Product[] p5 = mgr.searchRefrigerator();
		for(Product pd : p5)
			System.out.println(pd);
		
		System.out.println("\n=====delete===========");
		mgr.delete("3333");
		Product[] p6 =mgr.search();
		for(Product pd : p6)
			System.out.println(pd);
		
		System.out.println("\n=====totalPrice===========");
		System.out.println("합계 : "+mgr.totalPrice());
	}

}
