

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ws2_algo1030_서울_8반_천창민 {
	
	private static int [] dx = {-1,1,0,0};
	private static int [] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char [][] maze = new char[row][col];
		Min start = null;
		for (int i = 0; i < row; i++) {
			String [] str = bf.readLine().split("");
			for (int j = 0; j < col; j++) {
				maze[i][j] = str[j].charAt(0);
				if(maze[i][j] == '0') {
					start = new Min(i, j, 0, 0);
				}
			}
		}
		PriorityQueue<Min> q = new PriorityQueue<>();
//		Queue<Min> q = new LinkedList<>();
		int min = Integer.MAX_VALUE;
		q.offer(start);
		boolean [][][] visit = new boolean[row][col][64];
		visit[start.r][start.c][start.key] = true;
		roam: while(!q.isEmpty()) {
			Min cur = q.poll();
			
			switch(maze[cur.r][cur.c]) {
			case '1':
				min = cur.move;
				break roam;
			case 'a': case 'b': case 'c': case 'd':	case 'e': case 'f':
				if((cur.key & 1 << (maze[cur.r][cur.c]-'a')) == 0) {
					cur.key += 1 << (maze[cur.r][cur.c]-'a');
				}
				break;
			case 'A': case 'B': case 'C': case 'D':	case 'E': case 'F':
				if((cur.key & 1<< (maze[cur.r][cur.c]-'A')) == 0) continue;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dx[i];
				int nc = cur.c + dy[i];
				if(nr < 0 || nc < 0 || nr >= row || nc >= col || maze[nr][nc] == '#') continue;
				if(visit[nr][nc][cur.key]) continue;
				visit[nr][nc][cur.key] = true;
				q.offer(new Min(nr, nc, cur.move+1, cur.key));
			}
		}
		min = min== Integer.MAX_VALUE ? -1 : min;
		System.out.println(min);
		
	}
	
	private static class Min implements Comparable<Min>{
		int r;
		int c;
		int move;
		int key;
		public Min(int r, int c, int move, int key) {
			super();
			this.r = r;
			this.c = c;
			this.move = move;
			this.key = key;
		}
		@Override
		public int compareTo(Min o) {
			return this.move - o.move;
		}
	}
}
