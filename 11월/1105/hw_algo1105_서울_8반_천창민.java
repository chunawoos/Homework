

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class hw_algo1105_서울_8반_천창민 {
	
	static int [] dx = {0,-1,-1,-1,0,1,1,1};
	static int [] dy = {-1,-1,0,1,1,1,0,-1};
	private static int N;
	private static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine());
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = bf.readLine().toCharArray();
			}
			int click = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] != '.')continue;
					int cnt = 0;
					for (int k = 0; k < 8; k++) {
						int nr = i + dx[k];
						int nc = j + dy[k];
						if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
						if(map[nr][nc] == '*') {
							cnt++;
							break;
						}
					}
					if(cnt == 0) {
						map[i][j] = '0';
						click++;
						open(i,j);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '.') click++;
				}
			}
			sb.append("#").append(tc).append(" ").append(click).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void open(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < 8; i++) {
			int nr = row + dx[i];
			int nc = col + dy[i];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if(map[nr][nc] == '.')
				q.offer(new Point(nr,nc));
		}
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			
			if(map[x][y] != '.') continue;
			int cnt = 0;
			for (int i = 0; i < 8; i++) {
				int nr = x + dx[i];
				int nc = y + dy[i];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(map[nr][nc] == '*') {
					cnt++;
					break;
				}
			}
			if(cnt != 0) map[x][y] = (char) (cnt + '0');
			else {
				map[x][y] = '0';
				open(x,y);
			}
		}
	}
}
