import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ws_algo0924_서울_8반_천창민 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			int [] list = new int[N];
			int [] LIS = new int[N];
			Arrays.fill(LIS, 1);
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int max = 0;
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
				for (int j = 0; j < i; j++) {
					if(list[i] > list[j]) {
						LIS[i] = Math.max(LIS[i], LIS[j]+1);
					}
				}
				max = Math.max(max, LIS[i]);
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
