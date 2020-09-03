import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hwalgo0903_서울_8반_천창민 {

	
	private static int N, min;
	private static int[][] map;
	private static boolean [] visit;

	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine().trim());
		map = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int [] path = new int[N];
		visit = new boolean[N];
		visit[0] = true;
		min = Integer.MAX_VALUE;
		dfs(0,0,0);
		System.out.println(min);
	}

	private static void dfs(int cnt, int sum, int cur) {
		
		if(min < sum) return;
		
		if(cnt == N-1) {
			if(map[cur][0] != 0 && min > sum+map[cur][0]) {
				min = sum+map[cur][0];
			}
			return;
		}
		
		for(int i=1; i<N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			if(map[cur][i] != 0)
				dfs(cnt+1,sum+map[cur][i],i);
			visit[i] = false;
		}
	}

	
}
