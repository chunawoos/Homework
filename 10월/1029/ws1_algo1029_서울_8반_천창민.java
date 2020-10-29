import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class ws1_algo1029_서울_8반_천창민 {

	private static int N, min;
	private static int[][] map;
	
	static int [] dx = {1,0,0,-1}; // x축 방향
	static int [] dy = {0,1,-1,0}; // y축 방향
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine()); // 테케 입력 받기
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine()); // 맵 사이즈 입력받기
			map = new int[N][N];
			for (int i = 0; i < N; i++) { // 맵 깊이 입력 받기
				String [] tmp = bf.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			PriorityQueue<Engineer> q = new PriorityQueue<>(); // 작업시간을 기준으로 우선순위 큐 생성
			boolean [][] visit = new boolean[N][N]; // 방문처리( 먼저 방문한 것이 가장 작업시간이 적은 공병대다)
			q.offer(new Engineer(0, 0, 0));
			while(!q.isEmpty()) {
				Engineer cur = q.poll();
				
				if(cur.x == N-1 && cur.y == N-1) { // 도착지점에 도착
					min = cur.work;
					break; // 가장 먼저 온 공병대가 제일 적게 작업 했기때문에 반복문 종료
				}
				
				if(!visit[cur.x][cur.y]) { // 방문처리
					visit[cur.x][cur.y] = true;
				
				} else continue; // 먼저 방문한 공병대가 더 적은 작업량이라서 굳이 해볼 필요가 없기에 패스
				for (int i = 0; i < 4; i++) { // 4방 탐색
					int nr = cur.x + dx[i];
					int nc = cur.y + dy[i];
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					
					q.offer(new Engineer(nr, nc,cur.work + map[nr][nc]));
				}
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static class Engineer implements Comparable<Engineer>{ // 공병대 클래스
		int x; // row
		int y; // col
		int work; // 작업량
		
		public Engineer(int x, int y, int work) {
			super();
			this.x = x;
			this.y = y;
			this.work = work;
		}

		@Override
		public int compareTo(Engineer o) {
			return this.work - o.work;
		}
	}
}
