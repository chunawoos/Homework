

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ws1_algo1103_서울_8반_천창민 {
	
	final static int ONE = 15;
	final static int TWO = 3;
	final static int THREE = 12;
	final static int FOUR = 9;
	final static int FIVE = 10;
	final static int SIX = 6;
	final static int SEVEN = 5;
	
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int holeX = Integer.parseInt(st.nextToken());
			int holeY = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int [][] map = new int[row][col];
			for (int i = 0; i < row; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < col; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<Point> q = new LinkedList<>();
			q.offer(new Point(holeX, holeY, 0));
			while(!q.isEmpty()) {
				Point cur = q.poll();
				if(cur.count == time) continue;
				int pNum = map[cur.r][cur.c];
				int pipe = 0;
				switch (pNum) {
				case 1:
					pipe = ONE;
					break;
				case 2:
					pipe = TWO;
					break;
				case 3:
					pipe = THREE;
					break;
				case 4:
					pipe = FOUR;
					break;
				case 5:
					pipe = FIVE;
					break;
				case 6:
					pipe = SIX;
					break;
				case 7:
					pipe = SEVEN;
					break;
				}
				map[cur.r][cur.c] = -1; 
				for (int i = 0; i < 4; i++) {
					if((pipe & (1 << i)) == 0) continue;
					int nr = cur.r + dx[i];
					int nc = cur.c + dy[i];
					if(nr < 0 || nc < 0 || nr >= row || nc >= col || map[nr][nc] < 1) continue;
					if(isConnect(i, map[nr][nc])) {
						q.offer(new Point(nr, nc, cur.count+1));
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if(map[i][j] == -1)
						cnt++;
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static boolean isConnect(int dir, int next) {
		switch(dir) {
		case 0: // 상
			if(next == 1 || next == 2 || next == 5 || next == 6)
				return true;
			break;
		case 1: // 하
			if(next == 1 || next == 2 || next == 4 || next == 7)
				return true;
			break;
		case 2: // 좌
			if(next == 1 || next == 3 || next == 4 || next == 5)
				return true;
			break;
		case 3: // 우
			if(next == 1 || next == 3 || next == 6 || next == 7)
				return true;
			break;
		}
		return false;
	}
	private static class Point{
		int r;
		int c;
		int count;
		public Point(int r, int c, int count) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}
}
