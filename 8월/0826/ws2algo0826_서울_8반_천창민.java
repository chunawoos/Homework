import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ws2algo0826_서울_8반_천창민 {
	private static char[][] map;
	private static int col, row;
	
	private static int [] dx = {0,0,1,-1};
	private static int [] dy = {1,-1,0,0};
	
	private static boolean [][][] visit;
	public static class Load {
		int x;
		int y;
		int cnt;
		boolean chance;
		public Load() {	}
		public Load(int x, int y, int cnt, boolean chance) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.chance = chance;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		map = new char[row][col];
		for(int i=0; i<row;i++)
			map[i] = bf.readLine().toCharArray();
		visit = new boolean[row][col][2];
		visit[0][0][0] = true;
		visit[0][0][1] = true;
		
		bfs();
	}
	private static void bfs() {
		 Queue<Load> q = new LinkedList<>();
		 q.offer(new Load(0,0,1,true));
		 
		 while(!q.isEmpty()) {
			 Load n = q.poll();
			 if(n.x == row-1 && n.y == col-1) {
				System.out.println(n.cnt);
				return;
			 }

			 for(int i=0; i<4; i++) {  // 우, 좌, 하, 상
				 int nx = n.x +dx[i];
				 int ny = n.y +dy[i];
				 if(nx < 0 || ny <0 || nx >= row || ny >= col) 
					 continue;
				 if(map[nx][ny] == '1') {
					 if(n.chance && !visit[nx][ny][1]) {
						 visit[nx][ny][1] = true;
						 q.offer(new Load(nx,ny,n.cnt+1,false));
					 }
				 } else {
					 if(n.chance && !visit[nx][ny][0]) {
						 visit[nx][ny][0] = true;
						 q.offer(new Load(nx,ny,n.cnt+1,n.chance));
					 } else if(!n.chance && !visit[nx][ny][1]) {
						 visit[nx][ny][1] = true;
						 q.offer(new Load(nx,ny,n.cnt+1,n.chance));						 
					 }
				 }
			 }
		 }
		 System.out.println(-1);
	}
}
