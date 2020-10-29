

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hw_algo1028_서울_8반_천창민 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int [][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				int [] check = new int[N];
				int line = 0;
				impossible:
				for (int j = 0; j < N-1; j++) {
//					System.out.println(map[i][j]+" "+map[i][j+1]);
					if(map[i][j] != map[i][j+1]) {
						if(Math.abs(map[i][j] - map[i][j+1]) > 1) break;
						if(map[i][j] < map[i][j+1]) {
							for (int k = j; k > j-X; k--) {
								if(k < 0 || map[i][j] != map[i][k] || check[k] != 0) break impossible;
//								System.out.print(map[i][k]);
								check[k] = 1;
							}
//							System.out.println();
						} else {
							for (int k = j+1; k <= j+X; k++) {
								if(k >= N || map[i][j+1] != map[i][k] || check[k] != 0) break impossible;
//								System.out.print(map[i][k]+"-");
								check[k] = 1;
							}
//							System.out.println(" ");
						}
					}
					line++;
				}
				if(line == N-1) {
//					System.out.println(i);
					cnt++;
				}
			}
			for (int i = 0; i < N; i++) {
				int [] check = new int[N];
				int line = 0;
				impossible:
					for (int j = 0; j < N-1; j++) {
						if(map[j][i] != map[j+1][i]) {
							if(Math.abs(map[j][i] - map[j+1][i]) > 1) break;
							if(map[j][i] < map[j+1][i]) {
								for (int k = j; k > j-X; k--) {
									if(k < 0 || map[j][i] != map[k][i] || check[k] != 0) break impossible;
									check[k] = 1;
								}
							} else {
								for (int k = j+1; k <= j+X; k++) {
									if(k >= N || map[j+1][i] != map[k][i] || check[k] != 0) break impossible;
									check[k] = 1;
								}
							}
						}
						line++;
					}
				if(line == N-1) { 
//					System.out.println(i);
					cnt++;
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
