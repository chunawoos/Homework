

import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		Product p ;
		ProductMgr manage = ProductMgr.getInstance();
		boolean is_exit = true;
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		
		do {
			System.out.println("<<< 상품 관리 프로그램 >>>");
			System.out.println("1, 상품 정보 입력");
			System.out.println("2. 상품 리스트 보기");
			System.out.println("3. 상품 번호로 검색");
			System.out.println("4. 상품 삭제");
			System.out.println("5. 특정 가격 이하 리스트 보기");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호를 입력하세요.  ");
			
			num = sc.nextInt();
			
			System.out.println();
			
			switch(num) {
			case 1:{
				System.out.println("1, 상품 정보 입력");
				
				System.out.print("상품 번호를 입력하세요.  ");
				int pnum = sc.nextInt();
				System.out.print("상품 이름을 입력하세요.  ");
				String name = sc.next();
				System.out.print("상품 가격을 입력하세요.  ");
				int price = sc.nextInt();
				System.out.print("상품 수량을 입력하세요.  ");
				int amount = sc.nextInt();
				
				p = new Product(pnum, name, price, amount);
				manage.add(p);
				break;
				}
			case 2:{
				System.out.println("2. 상품 리스트 보기");
				
				manage.list();
				break;
				}
			case 3:{
				System.out.println("3. 상품 번호로 검색");
				
				System.out.print("상품 번호를 입력하세요.  ");
				int pnum = sc.nextInt();
				manage.list(pnum);
				break;
				}
			case 4:{
				System.out.println("4. 상품 삭제");
				
				System.out.print("상품 번호를 입력하세요.  ");
				int pnum = sc.nextInt();
				manage.delete(pnum);
				break;
				}
			case 5:{
				System.out.println("5. 특정 가격 이하 리스트 보기");

				System.out.print("상품 가격을 입력하세요.  ");
				int price = sc.nextInt();
				manage.priceList(price);
				break;
				}
			case 0:{
				System.out.println("0. 프로그램 종료");

				System.out.println("-- 종료하겠습니다 --");
				is_exit = false;
				break;
				}
			default:
				System.out.println("번호를 잘못 입력하셨습니다. ");
				break;
			}
			
			System.out.println();
		}while(is_exit);
		sc.close();
	}
}
