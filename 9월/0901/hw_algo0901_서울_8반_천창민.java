import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hw_algo0901_서울_8반_천창민 {
	
	private static int [] team1, team2;
	private static int [][] player;	
	private static int min;
	private static boolean[] group;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		player = new int[N][N];
		min = Integer.MAX_VALUE;
		StringTokenizer st;
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		team1 = new int[N/2];
		team2 = new int[N/2];
		group = new boolean[N];
		combination(N,0,0);
		System.out.println(min);
	}

	private static void combination(int N, int cnt, int start) {
		if(cnt == N/2) {
			int tmp = 0;
			for(int i=0; i<N;i++) {
				if(!group[i]) {
					team2[tmp++] = i;
				} 
			}
			int sum = calc(N);
			if(min > sum)
				min = sum;
			return;
		}
		for(int i=start; i<N; i++) {
			team1[cnt] = i;
			group[i] = true;
			combination(N,cnt+1, i+1);
			group[i] = false;
		}
	}

	private static int calc(int N) {
		int sum1 = 0, sum2 = 0;

		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				if(i==j) continue;
				sum1 += player[team1[i]][team1[j]];
				sum2 += player[team2[i]][team2[j]];
			}
		}
		return Math.abs(sum1-sum2);
	}
}
