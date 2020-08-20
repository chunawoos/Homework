package hwjava14_서울_8반_천창민;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import hwjava14_서울_8반_천창민.Product;
import hwjava14_서울_8반_천창민.ProductDAO;

public class ProductTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean flag=true;
        ProductDAO dao = new ProductDAO();
        
		while(flag) {
		  System.out.println("<<<<<Abc 디지털 대리점 메뉴>>>>>");
		  System.out.println("1.입력 2.전체목록 3.상품검색(이름) 4.상품검색(price)");
		  System.out.println("5.상품검색(isbn) 6.삭제 7.상품가격 수정 8.종료");
		  System.out.print("==>번호: ");
		  int no= Integer.parseInt(in.readLine());
		  System.out.println();
		  
		  switch(no) {
		  case 1: {
			  System.out.print("isbn : "); String isbn = in.readLine();
			  System.out.print("name : "); String name = in.readLine();
			  System.out.print("price : "); int price = Integer.parseInt(in.readLine());
			  System.out.print("stock : "); int stock = Integer.parseInt(in.readLine());
			  
			  Product product = new Product(isbn, name, price, stock);
			  dao.insertProduct(product);
		  	  }break;
		  	  
		  case 2: printAllProducts(dao.findProd());
		  		  break;
		  case 3: {
			  	 System.out.print("검색할 이름 : "); String name = in.readLine();
	    	     printAllProducts(dao.findProdName(name));
	            }break;

		  case 4: {
			  System.out.print("검색할 가격 : "); int price = Integer.parseInt(in.readLine());
	    	  printAllProducts(dao.listProdPrice(price));
		      } break;
		  case 5: {
			  System.out.print("검색할 isbn: "); String isbn = in.readLine();
	          System.out.println(dao.findProdISBN(isbn));
	            }break;
	
		  case 6: {
			  System.out.print("삭제할 isbn: "); String isbn = in.readLine();
	    	     dao.delete(isbn);
	            }break;
		  case 7: {
			  System.out.print("검색할 isbn: "); String isbn = in.readLine();
			  System.out.print("변경할 가격 : "); int price = Integer.parseInt(in.readLine());
	    	  dao.updatePrice(isbn, price);
		      } break;
		  case 8: flag = false;
		  }
		  System.out.println();
		}
	}
	
	private static void printAllProducts(List<Product> list) {
		System.out.println("▣ 상품 목록 ▣");
		for(Product prod:list) {
			System.out.println(prod);
		}
	}
}
