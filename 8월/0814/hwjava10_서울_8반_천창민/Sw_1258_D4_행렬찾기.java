package hwjava10_서울_8반_천창민;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sw_1258_D4_행렬찾기 {
	
	static int [][] map;
	static int [][] visit;
	static int [] root;
	static int N;
	static PriorityQueue<Matrix> pq; 
	
	static int [] dx = {1,0};
	static int [] dy = {0,1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=testCase; tc++) {
			N = Integer.parseInt(bf.readLine());
			map = new int[N][N];
			visit = new int[N][N];
			root = new int[N*N];
			pq = new PriorityQueue<>();
			for(int i=0; i<N; i++) {
				String [] tmp = bf.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
					if(map[i][j] == 0) {
						root[i*N+j] = -1;
						visit[i][j] = -1;
					}
					else
						make(i*N+j);
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(root[i*N+j] == i*N+j && visit[i][j] == 0) {
						matrixSearch(i,j);
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(pq.size());
			while(!pq.isEmpty()) {
				Matrix m = pq.poll();
				sb.append(" ").append(m.col).append(" ").append(m.row);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		bf.close();
	}


	private static void matrixSearch(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x,y));
		while(!q.isEmpty()) {
			int px = q.peek().x;
			int py = q.peek().y;
			q.poll();
			visit[px][py] = 1;
			for(int i=0; i<2; i++) {
				int sx = px+dx[i];
				int sy = py+dy[i];
				if(sx >= N || sy >= N)
					continue;
				if(map[sx][sy] != 0)
					if(union(sx*N+sy,px*N+py))
						q.offer(new Point(sx,sy));
			}
			
			if(q.isEmpty()) {
				pq.offer(new Matrix(px-x+1,py-y+1));
			}
		}
	}
	private static void make(int a) {
		if(root[a] == -1) return;
		root[a] = a;
	}
	
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		root[rootB] = rootA;
		return true;
	}

	private static int find(int a) {
		if(root[a] == a) return a;
		return root[a] = find(root[a]);
	}

	public static class Matrix implements Comparable<Matrix>{
		int col;
		int row;
		int mul;
		
		public Matrix(int col, int row) {
			this.col = col;
			this.row = row;
			this.mul = col*row;
		}
		
		@Override
		public int compareTo(Matrix n) {
			int size = this.mul - n.mul;
			if(size > 0 )
				return 1;
			else if(size < 0)
				return -1;
			else {
				if(this.col < n.col) 
					return -1;
				else
					return 1;
			}
		}
	}
}
