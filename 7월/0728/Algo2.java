

import java.util.Scanner;

public class Algo2 {


	private static int N;  	  // 사이즈
	private static int[][] map;  // 숫자를 저장할 2차원 배열
	private static int num = 1;
	
	public static void main(String[] args) {
		int testCase; // 테스트 케이스
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		
		for(int tc=1; tc<=testCase; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			num = 1;
			if(N == 1) {
				map[0][0] = 1;
				System.out.println("#"+tc);
				System.out.println(map[0][0]);
				continue;
			}
			filling(3,0,0);
			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(map[i][j]+ " ");
				}
				System.out.println();
			}
		}
	}
	
	private static void filling(int dir,int pi, int pj) { // 우 : 3, 하 : 2, 좌 : 1, 상 : 0
		if(map[pi][pj] != 0)
			return;
		switch(dir) {
		case 0: 
			for(int i=0; i<N; i++) {
				map[pi][pj] = num;
				num++;
				if((pi-1)<0 || map[pi-1][pj]!=0)
					break;
				pi--;
			}
			filling(3,pi,pj+1);
			break;
		case 1: 
			for(int i=0; i<N; i++) {
				map[pi][pj] = num;
				num++;
				if((pj-1)<0 || map[pi][pj-1]!=0)
					break;
				pj--;
			}
			filling(0,pi-1,pj);
			break;
		case 2:
			for(int i=0; i<N; i++) {
				map[pi][pj] = num;
				num++;
				if((pi+1) >= N || map[pi+1][pj] !=0)
					break;
				pi++;
			}
			filling(1,pi,pj-1);
			break;
		case 3: 
			for(int i=0; i<N; i++) {
				map[pi][pj] = num;
				num++;
				if((pj+1) >= N || map[pi][pj+1] != 0)
					break;
				pj++;
			}
			filling(2,pi+1,pj);
			break;
		}
		return;
	}
}
