

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hw_algo1030_서울_8반_천창민 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int [] price = new int[4];
			int [] plan = new int[13];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine());
			for (int i = 1; i < 13; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			int [] D = new int[13];
			for (int i = 1; i < 13; i++) {
				D[i] = D[i-1] + Math.min(plan[i]*price[0], price[1]);
				if(i > 2) {
					D[i] = Math.min(D[i], D[i-3]+price[2]);
				}
				if(i == 12) {
					D[i] = Math.min(D[i], price[3]);
				}
			}
			sb.append("#").append(tc).append(" ").append(D[12]).append("\n");
		}
		System.out.println(sb);
	}
}
