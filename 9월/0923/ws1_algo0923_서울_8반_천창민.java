

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ws1_algo0923_서울_8반_천창민 {
	private static int N, M, min;
	private static int[][] D;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			char [][] flag = new char[N][M];
			D = new int[N][3];
			for (int i = 0; i < N; i++) {
				flag[i] = bf.readLine().trim().toCharArray();
			}
			for (int i = 0; i < M; i++) {
				if(flag[0][i] != 'W') {
					D[0][0]++;
				}
				for (int j = 1; j < N-1; j++) {
					if(flag[j][i] != 'W')
						D[j][0]++;
					if(flag[j][i] != 'B')
						D[j][1]++;
					if(flag[j][i] != 'R')
						D[j][2]++;
				}
				if(flag[N-1][i] != 'R') {
					D[N-1][2]++;
				}
			}
			min = Integer.MAX_VALUE;
			chooseColor(1,0,1,0);
			min += D[0][0] + D[N-1][2];
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void chooseColor(int depth, int before,int bit, int sum) {

		if(depth == N-1) {
			if(bit >= (1<<2)-1)
				min = Math.min(min, sum);
			return;
		}
		
		switch(before) {
		case 0:
			chooseColor(depth+1,0,bit| 1,sum+D[depth][0]);
			chooseColor(depth+1,1,bit|1<<1,sum+D[depth][1]);
			break;
		case 1:
			chooseColor(depth+1,1,bit| 1<<1,sum+D[depth][1]);
			chooseColor(depth+1,2,bit|1<<2,sum+D[depth][2]);
			break;			
		case 2:
			chooseColor(depth+1,2,bit|1<<2,sum+D[depth][2]);
			break;			
		}
	}
}
