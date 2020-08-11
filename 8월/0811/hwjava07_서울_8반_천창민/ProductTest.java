package hwjava07_서울_8반_천창민;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {
   private static final int INPUT=1;
   private static final int SEARCH=2;
   private static final int SEARCH_ISBN=3;
   private static final int SEARCH_NAME=4;
   private static final int SEARCH_TV=5;
   private static final int SEARCH_Refrigerator=6;
   private static final int SEARCH_RefVolume=7;
   private static final int SEARCH_TVSize=8;
   private static final int SEARCH_Change=9;
   private static final int SEARCH_Delete=10;
   private static final int SEARCH_TotalPrice=11;

   /*
   TV "33333","QLED8K84inchinfinityScreen","SamSung",18400000, 3, 20, 84, 8000
   TV "31577","CrystalUHD48inch스탠드형","SamSung",1790000,1,24, 48, 5000
		
   Refrigerator "9965","셰프컬렉션다크크롬프레임","SamSung",8980000, 7,60,900,18 
   Refrigerator "7777","BESPOKE냉장고GlamWhite","SamSung", 3060000, 2,80,300,15
    */
   
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       IProductMgr mgr = new ProductMgrImpl();
       
	   int num;
	   do { //String isbn, String name, String company, int price, int stock, int weight
		 System.out.println("<<Product메뉴>>");
		 System.out.println("1.데이터 입력  2.데이터검색(전체)  3.데이터검색(isbn)  4.데이터검색(name)  5.데이터검색(TV)  6.데이터 검색(Refrigerator)");
	     System.out.println("7.데이터 검색(대용량 냉장고)  8.데이터 검색(대형 TV) 9.상품 가격 변경  10.상품 삭제  11.전체 재고 상품 금액 12. 종료");

		 System.out.print("\n번호선택==> ");
		 num = sc.nextInt();
		 
		 System.out.println();
		 switch(num) {
		   case INPUT://1: 
		   {
			   System.out.println("1.TV  2.Refrigerator");
			   System.out.print("번호선택==> ");
			   int kind= sc.nextInt();
			   System.out.print("isbn: "); String isbn=sc.next();
			   System.out.print("name: "); String name=sc.next();
			   System.out.print("company: "); String company=sc.next();
			   System.out.print("price: "); int price =sc.nextInt();
			   System.out.print("stock: "); int stock =sc.nextInt();
			   System.out.print("weight: "); int weight =sc.nextInt();
			   
			   Product prod=null;
			   if(kind==1) {
				   System.out.print("size: "); int size =sc.nextInt();
				   System.out.print("resolution: "); int resolution =sc.nextInt();
				   prod = new Tv(isbn, name, company, price, stock, weight, size, resolution);
			   }else if(kind==2) {
				   System.out.print("volume: "); int volume =sc.nextInt();
				   System.out.print("temperature: "); int temperature =sc.nextInt();
				   prod = new Refrigerator(isbn, name, company, price, stock, weight, volume, temperature);
			   }
			   if(prod!=null)mgr.add(prod);
		     }
			   break;
		   case SEARCH://2:
			   System.out.println("### 전체검색 ###");
			   print(mgr.search());
			   break;
		   case SEARCH_ISBN://3:
			   System.out.print("isbn: "); String isbn =sc.next();
			   System.out.println("### isbn검색 ###");
			   print(mgr.searchIsbn(isbn));
			   break;
		   case SEARCH_NAME://4:
			   System.out.print("name: "); String name =sc.next();
			   System.out.println("### name검색 ###");
			   print(mgr.searchName(name));
			   break;
		   case SEARCH_TV://5:
			   System.out.println("### TV검색 ###");
			   print(mgr.searchTv());
			   break;
		   case SEARCH_Refrigerator://6:
			   System.out.println("### 냉장고검색 ###");
			   print(mgr.searchRefrigerator());
			   break;
		   case SEARCH_RefVolume://7:
			   System.out.println("### 대용량냉장고검색 ###");
			   print(mgr.searchRefVolume(400));			   
			   break;
		   case SEARCH_TVSize://8:
			   System.out.println("### 대형TV검색 ###");
			   print(mgr.searchTvSize(50));
			   break;
		   case SEARCH_Change://9:
			   System.out.print("isbn: "); String changeIsbn =sc.next();
			   System.out.print("price: "); int price =sc.nextInt();			   
			   mgr.changePrice(changeIsbn, price);
			   print(mgr.searchIsbn(changeIsbn));
			   break;
		   case SEARCH_Delete://10
			   System.out.print("isbn: "); String deleteIsbn =sc.next();
			   mgr.delete(deleteIsbn);
			   print(mgr.search());
			   break;
		   case SEARCH_TotalPrice://11
			   System.out.print("전체 재고 상품 금액 : "+ mgr.totalPrice());
		 }
		 System.out.println();
	   }while(num!=12);
	  sc.close();
  }//main
   
   private static void print(ArrayList<Product> prod) {
	   for(Product p: prod) {
		   System.out.println(p);
	   }
   }
   private static void print(Product prod) {
	   System.out.println(prod);
   }
}
