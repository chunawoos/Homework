

import java.util.Scanner;

public class Compute {

	public static void main(String[] args) {
		int a,b;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("정수를 입력해 주세요 :");
			a = scan.nextInt();
			b = scan.nextInt();
		
			System.out.println("곱 = " + a*b);
			System.out.println("몫 = " + a/b);
		} while(a*b != 0);
	}

}
