

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class ws1_algo1030_서울_8반_천창민 {
	
	private static int row, col, result;
	private static char[][] map;
	private static HashSet<String> set;
	
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static boolean[][][][] check;
	final static int UP = 0;
	final static int DOWN = 1;
	final static int LEFT = 2;
	final static int RIGHT = 3;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			map = new char[row][col];

			for (int i = 0; i < row; i++) {
				map[i] = bf.readLine().trim().toCharArray();
			}
			boolean hasExit = false;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if(map[i][j] == '@') {
						hasExit = true;
						break;
					}
				}
			}
			if(!hasExit) {
				sb.append("#").append(tc).append(" NO\n");
				continue;
			}
			check = new boolean[row][col][16][4];
			set = new HashSet<>(); // "row+col+mem+dir"
			result = 0;
			bfs();
			if(result == 1) {
				sb.append("#").append(tc).append(" YES\n");
			} else 
				sb.append("#").append(tc).append(" NO\n");
		}
		System.out.println(sb);
	}
	private static void bfs() {
		Queue<Assembler> q = new LinkedList<>();
		q.offer(new Assembler(0, 0, 0, RIGHT, 0));
		
		while(!q.isEmpty()) {
			Assembler cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			int dir = cur.dir;
			int mem = cur.mem;
			boolean isQ = false;
			switch(map[r][c]) {
			case '<':
				dir = LEFT;
				break;
			case '>':
				dir = RIGHT;
				break;
			case '^':
				dir = UP;
				break;
			case 'v':
				dir = DOWN;
				break;
			case '_':
				dir = (mem == 0) ? RIGHT : LEFT;
				break;
			case '|':
				dir = (mem == 0) ? DOWN : UP;
				break;
			case '?':
				{
					for (int i = 0; i < 4; i++) {
						dir = i;
						int nr = (r+dx[dir] < 0) ? row-1 : (r+dx[dir] >= row) ? 0 : r+dx[dir];
						int nc = (c+dy[dir] < 0) ? col-1 : (c+dy[dir] >= col) ? 0 : c+dy[dir];
						if(check[nr][nc][mem][dir]) {
							continue;
						} else {
							check[nr][nc][mem][dir] = true;
						}
//						String buf = "";
//						buf += nr;
//						buf += nc;
//						buf += mem;
//						buf += dir;
//						if(!set.add(buf)) {
//							continue;
//						}
						q.offer(new Assembler(nr, nc, cur.depth+1, dir, mem));
					}
					isQ = true;
				} break;
			case '.':
				break;
			case '@':
				result = 1;
				return;
			case '+':
				mem = (mem == 15) ? 0 : mem+1;
				break;
			case '-':
				mem = (mem == 0) ? 15 : mem-1;
				break;
			default:
				mem = map[r][c] - '0';
				break;
			}
			if(isQ) continue;
			int nr = (r+dx[dir] < 0) ? row-1 : (r+dx[dir] >= row) ? 0 : r+dx[dir];
			int nc = (c+dy[dir] < 0) ? col-1 : (c+dy[dir] >= col) ? 0 : c+dy[dir];
			if(check[nr][nc][mem][dir]) {
				continue;
			} else {
				check[nr][nc][mem][dir] = true;
			}
//			String buf = "";
//			buf += nr;
//			buf += nc;
//			buf += mem;
//			buf += dir;
//			if(!set.add(buf)) {
//				continue;
//			}
			q.offer(new Assembler(nr, nc, cur.depth+1, dir, mem));
		}
	}

	private static class Assembler implements Comparable<Assembler>{
		int r;
		int c;
		int depth;
		int dir;
		int mem;
		public Assembler(int r, int c, int depth, int dir, int mem) {
			super();
			this.r = r;
			this.c = c;
			this.depth = depth;
			this.dir = dir;
			this.mem = mem;
		}
		@Override
		public int compareTo(Assembler o) {
			 return this.depth - o.depth;
		}
	}
}
