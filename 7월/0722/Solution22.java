

import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) {
		int test_case; // 테스트케이스
		int N; // 연못사이즈
		int [][] pawn; // 연못
		int stn; // 소금쟁이 수
		int [][] strider; // 소금쟁이 시작 위치
		int []dir; // 소금쟁이 방향
		int []alive; // 생존 여부
		Scanner sc = new Scanner(System.in);
		
		test_case = sc.nextInt();
		
		for(int tc = 1; tc <= test_case; tc++) {
			N = sc.nextInt();
			pawn = new int[N][N];
			stn = sc.nextInt();
			strider = new int[stn][2];
			dir = new int[stn];
			alive = new int[stn];
			int sum = 0;
			for(int i =0 ; i< stn; i++) {
				for(int j=0; j<2 ;j++)
					strider[i][j] = sc.nextInt();
				dir[i] = sc.nextInt();
				alive[i] = 1;
			}
			for(int i=0 ;i <stn; i++) {
				int pi = strider[i][0]; // 시작지점 저장
				int pj = strider[i][1]; // 시작지점 저장2
				
				for(int j=3; j > 0 ; j--) { // 뜀박질
					if(alive[i] == 0) // 죽었는지 확인
						break;
					if(pawn[pi][pj] != 0) // 이미 누가 밟았는지 확인
						alive[i] = 0;
					else
						pawn[pi][pj] = 1;
					
					switch(dir[i]) { // 방향을 확인하고 뜀박질 위치 조정
					case 1: // 상
						pi -= j;
						if(pi < 0) 
							alive[i] = 0;
						break;
					case 2: // 하
						pi += j;
						if(pi >= N)
							alive[i] = 0;
						break;
					case 3: // 좌
						pj -= j;
						if(pj < 0) 
							alive[i] = 0;
						break;
					case 4: // 우
						pj += j;
						if(pj >= N) 
							alive[i] = 0;
						break;
					default:
						break;
					}
				}
			}
			for(int i=0; i<stn; i++) 
				sum += alive[i];
			System.out.println("#"+tc+" "+sum);
		}
		sc.close();
	}

}
