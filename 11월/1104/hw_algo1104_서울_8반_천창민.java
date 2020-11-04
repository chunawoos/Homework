

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hw_algo1104_서울_8반_천창민 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			int M = Integer.parseInt(bf.readLine());
			boolean [][] tallSet = new boolean[N+1][N+1];
			boolean [][] smallSet = new boolean[N+1][N+1];
			StringTokenizer st = null;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine());
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				tallSet[left][right] = true;
				smallSet[right][left] = true;
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i==j) continue;
					if(tallSet[i][j]) {
						for (int k = 1; k <= N; k++) {
							if(smallSet[i][k]) {
								smallSet[j][k] = true;
							}
						}
					}
					if(smallSet[i][j]) {
						for (int k = 1; k <= N; k++) {
							if(tallSet[i][k]) {
								tallSet[j][k] = true;
							}
						}
					}
				}
			}
			int res = 0;
			for (int i = 1; i <= N; i++) {
				int cnt = 1;
				for (int j = 1; j <= N; j++) {
					if(tallSet[i][j]) cnt++;
					if(smallSet[i][j]) cnt++;
				}
				if(cnt == N) res++;
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
	}
}
