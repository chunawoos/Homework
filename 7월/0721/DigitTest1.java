

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		int N = 10000;
		int [] digit = new int[N];
		int count = 0;
		int [] tenth = new int[10];
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			digit[count] = sc.nextInt();
			if(digit[count] > 100)
				continue;
			if(digit[count] == 0) {
				break;
			}
			count++;
		}
		
		for(int i = 0 ; i< count; i++) {
			if(digit[i] == 0)
				continue;
			int tmp = digit[i];
			tmp = tmp/10;
			switch(tmp) {
			case 0:
				tenth[0] +=1;
				break;
			case 1:
				tenth[1] +=1;
				break;
			case 2:
				tenth[2] +=1;
				break;
			case 3:
				tenth[3] +=1;
				break;
			case 4:
				tenth[4] +=1;
				break;
			case 5:
				tenth[5] +=1;
				break;
			case 6:
				tenth[6] +=1;
				break;
			case 7:
				tenth[7] +=1;
				break;
			case 8:
				tenth[8] +=1;
				break;
			case 9:
				tenth[9] +=1;
				break;
			default :
				break;			
			}
		}
		
		for(int i = 0 ; i<10; i++) {
			if(tenth[i] != 0)
				System.out.println(i+ " : "+tenth[i]+"개");
		}

	}

}
