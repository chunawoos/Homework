

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ws2_algo0923_서울_8반_천창민 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int [][] house = new int[N][N];
		long [][][] D = new long[N][N][3];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		D[0][1][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if(i+1 < N && house[i+1][j] == 0) {
					D[i+1][j][2] += D[i][j][1]+ D[i][j][2];
				}
				if(j+1 < N &&house[i][j+1] == 0) {
					D[i][j+1][0] += D[i][j][0] + D[i][j][1];
				}
				if(i+1 < N && j+1 < N && house[i+1][j] == 0 && house[i][j+1] == 0 && house[i+1][j+1] ==0)
					D[i+1][j+1][1] += D[i][j][0] + D[i][j][1] + D[i][j][2];
			}
		}

		long sum = D[N-1][N-1][0] + D[N-1][N-1][1] + D[N-1][N-1][2];
		System.out.println(sum);
	}
}
