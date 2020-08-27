import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hwalgo0827_서울_8반_천창민 {

	private static int R, C,max;
	private static char[][] map;
	private static boolean[] visit;
	
	private static int dx[] = {-1,1,0,0};
	private static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		for(int i=0; i<R; i++)
			map[i] = bf.readLine().toCharArray();
		visit = new boolean['Z'+1];
		
		visit[map[0][0]] = true;
		dfs(0,0,1);
		System.out.println(max);
	}

	private static void dfs(int r, int c, int cnt) {
		if(max == 26) return;
		if(cnt > max) max = cnt;
		
		for(int i=0; i<4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			if(nr <0 || nc <0 || nr >= R || nc >= C) continue;
			
			if(!visit[map[nr][nc]]) {
				visit[map[nr][nc]] = true;
				dfs(nr, nc, cnt+1);
				visit[map[nr][nc]] = false;	
			}
		}
	}

	
}
