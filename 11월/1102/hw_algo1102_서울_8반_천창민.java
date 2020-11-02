

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hw_algo1102_서울_8반_천창민 {
	private static int N, col, row, min;

	private static int [] dx = {-1,1,0,0};
	private static int [] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			int [][] map = new int[row][col];
			min = 0;
			for (int i = 0; i < row; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < col; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						min += 1;
					}
				}
			}
			for (int i = 0; i < col; i++) {				
				start(0,i,map);
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void start(int cur, int shoot, int[][] map) {
		if(cur == N) {
			int cnt = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if(map[i][j] != 0)
						cnt += 1;
				}
			}
			min = Math.min(min, cnt);
			return;
		}
		int [][] copy = new int[row][col];
		for (int j = 0; j < row; j++) {
			copy[j] = Arrays.copyOf(map[j], col);
		}
		boolean isBombOne = false;
		find:
		for (int i = 0; i < row; i++) {
			switch(copy[i][shoot]) {
			case 0:
				break;
			case 1:
				copy[i][shoot] = 0;
				isBombOne = true;
				break find;
			default :
				blockBreak(i,shoot,copy);
				break find;
			}
		}
		if(!isBombOne) {
			blockdown(copy);
		}
		for (int i = 0; i < col; i++) {
			start(cur+1,i, copy);
		}
	}

	private static void blockdown(int[][] copy) {
		for (int i = 0; i < col; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = row-1; j >= 0; j--) {
				if(copy[j][i] != 0) {
					list.add(copy[j][i]);
				}
			}
			for (int j = 0; j < list.size(); j++) {
				copy[row-1-j][i] = list.get(j);
			}
			for (int j = row - list.size()-1; j >= 0; j--) {
				copy[j][i] = 0;
			}
		}
	}

	private static void blockBreak(int r, int shoot, int[][] copy) {
		Queue<Block> q = new LinkedList<>();
		q.offer(new Block(r, shoot, copy[r][shoot]));
		while(!q.isEmpty()) {
			Block cur = q.poll();
			int len = cur.bomb-1;
			if(copy[cur.r][cur.c] != 0) copy[cur.r][cur.c] = 0;
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r;
				int nc = cur.c;
				for (int j = 0; j < len; j++) {
					nr += dx[i];
					nc += dy[i];
					if(nr <0 || nc <0 || nr >= row || nc >= col || copy[nr][nc] == 0) continue;
					if(copy[nr][nc] == 1) copy[nr][nc] = 0;
					else {
						q.offer(new Block(nr, nc, copy[nr][nc]));
					}
				}
			}
		}
	}
	
	static class Block{
		int r;
		int c;
		int bomb;
		public Block(int r, int c, int bomb) {
			super();
			this.r = r;
			this.c = c;
			this.bomb = bomb;
		}
	}
	
}
