

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		int tall, weight, fat=0;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("키와 몸무게를 입력해 주세요 :");
			tall = scan.nextInt();
			weight = scan.nextInt();
		
			fat = weight + 100 - tall;
			System.out.println("비만수치는 " + fat + "입니다.");
			if(fat > 0) {
				System.out.println("당신은 비만이군요");
			} else if(fat == 0) {
				System.out.println("당신은 비만이 아니군요");
				break;
			} else {
				System.out.println("당신은 비만이 아니군요");
			}
		}
	}
}
