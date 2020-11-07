import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hw_algo1106_서울_8반_천창민 {
	
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,-1,0,1};
	
	static int dr[] = {0,1,1};
	static int dc[] = {1,0,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int [][] map = new int[101][101];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			int d = Integer.parseInt(st.nextToken());
			ArrayList<Integer> dir = new ArrayList<>();
			ArrayList<Integer> move = new ArrayList<>();
			dir.add(d);
			move.add(d);
			int g = Integer.parseInt(st.nextToken());
			for (int j = 0; j <= g; j++) {
				int size = move.size();
				for (int k = 0; k < size; k++) {
					d = move.remove(0);
					x = x + dx[d];
					y = y + dy[d];
					map[x][y] = 1;
				}
				for (int k = dir.size()-1; k >= 0; k--) {
					d = ((dir.get(k) + 1) > 3)? 0 : dir.get(k) + 1;
					move.add(d);
				}
				dir.addAll(move);
			}
		}
		int res = 0;
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				int cnt = 0;
				if(map[j][k] == 0) continue;
				for (int i = 0; i < 3; i++) {
					int nr = j + dr[i];
					int nc = k + dc[i];
					if(map[nr][nc] != 0) cnt++;
				}
				if(cnt == 3) res++;
			}
		}
		System.out.println(res);
	}
}
