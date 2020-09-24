import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hw_algo0924_서울_8반_천창민 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(bf.readLine());
		final int INF = 999999; 
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			int [][] point = new int[N+2][2];
			int [][] distance = new int[N+2][N+2];
			for (int i = 0; i < N+2; i++) {
				Arrays.fill(distance[i], INF);
			}
			for (int i = 0; i < point.length; i++) {
				st = new StringTokenizer(bf.readLine());
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					if(i== j) continue;
					distance[i][j] = (Math.abs(point[i][0] - point[j][0]) + Math.abs(point[i][1] - point[j][1]) > 1000)? INF : 1;
				}
			}
			for (int k = 0; k < N+2; k++) {
				for (int i = 0; i < N+2; i++) {
					for (int j = 0; j < N+2; j++) {
						distance[i][j] = Math.min(distance[i][k]+ distance[k][j], distance[i][j]);
					}
				}
			}
			if( distance[0][N+1] < 0 || distance[0][N+1] >= INF) 
				sb.append("sad\n");
			else
				sb.append("happy\n");
		}
		System.out.println(sb);
	}
}
