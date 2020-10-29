import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ws1_algo1028_서울_8반_천창민 {
	private static int R, C;
	private static int[][] map;
	private static int[] group;
	
	static int [] dx = {1,0,-1,0};
	static int [] dy = {0,1,0,-1};
	private static Queue<Point> q;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()); // row, collumn 입력 받아서 파싱
		R = Integer.parseInt(st.nextToken()); // row 길이 입력
		C = Integer.parseInt(st.nextToken()); // collumn 길이 입력
		int result = 0; // 남아있는 치즈의 칸의 갯수
		map = new int[R][C]; // 맵 초기화
		for (int i = 0; i < R; i++) { // 맵 입력 받기
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) result++; // 치즈 칸의 갯수 세기
			}
		}
		group = new int[R*C]; // 구멍을 파악하기 위한 그룹 배열 초기화
		for (int i = 0; i < R; i++) { // 최초 그룹 초기화
			for (int j = 0; j < C; j++) {
				if(i==0 || j == 0) // 가장 외곽 부분은 무조건 치즈가 올라가 있지 않기 때문에 0으로 그룹
					group[i*C+j] = 0; 
				else {
					if(map[i][j] == 0) {
						group[i*C+j] = i*C+j; // 각자의 번호가 루트인 그룹 
					} else {
						group[i*C+j] = -1; // 만약 치즈라면 -1
					}
				}
			}
		}
		
		int cnt = 0; // 시간 체크를 위한 변수
		while(true) { // 치즈가 녹는 작업 반복문
			if(mapChecking()) { // 만약 치즈가 없다면 반복문 종료
				break;
			}
			grouping(); // 구멍이 노출될 경우를 union하기 위한 메소드
			int tmp = melt(); // 치즈를 녹이는 메소드
			result = (tmp == 0) ? result : tmp; // 만약 치즈가 다 녹을 경우 저장하지 않고, 치즈가 남아있을 경우 남아있는 치즈의 칸 저장
			cnt++; // 시간 증가
		}
		System.out.println(cnt); // 치즈가 다 녹을 때까지 걸린 시간 출력
		System.out.println(result); // 치즈가 다 녹기직전 치즈의 칸 출력
	}

	private static int melt() { // 치즈를 녹이는 메소드
		Queue<Point> melting = new LinkedList<>(); // 녹을 치즈의 위치 값 저장을 위한 큐
		int cnt = 0; // 남아 있는 치즈의 칸 갯수 저장
		for (int i = 0; i < R; i++) { // 맵의 모든 부분 체크
			for (int j = 0; j < C; j++) {
				boolean isMelt = false;
				if(map[i][j] == 1) { // 치즈일 경우
					for (int k = 0; k < 4; k++) { // 4방향 탐색
						int r = i+dx[k];
						int c = j+dy[k];
						if(map[r][c] == 0 && group[r*C+c] == 0) { // 4방향 중에 치즈가 공기와 맞닿아 있는 경우
							melting.offer(new Point(i,j)); // 큐에 위치 저장
							isMelt = true; // 치즈가 녹을것이라 표시
							break;
						}
					}
					if(!isMelt) { // 만약 치즈가 안녹는다면
						cnt++; // 남아 있는 치즈의 칸 증가
					}
				}
			}
		}
		while(!melting.isEmpty()) { // 큐에 저장한 치즈의 위치를 모두 꺼내는 반복문
			int r = melting.peek().x;
			int c = melting.peek().y;
			melting.poll();
			map[r][c] = 0; // 치즈가 녹아서 0으로 변경
			group[r*C+c] = 0; // 그룹을 0으로 묶음
		}
		return cnt; // 남아있는 치즈의 칸 리턴
	}

	private static void grouping() {
		q = new LinkedList<>();
		for (int i = 0; i < R; i++) { // 맵의 모든부분 체크
			for (int j = 0; j < C; j++) {
				if(group[i*C+j] == 0) { // 만약 그룹이 0이라면
					q.offer(new Point(i,j)); // 큐에 위치 저장
					while(!q.isEmpty()) {  
						int r = q.peek().x;
						int c = q.peek().y;
						q.poll();
						for (int k = 0; k < 4; k++) { // 4방탐색
							int nr = r + dx[k];
							int nc = c + dy[k];
							if(nr <0 || nc <0 || nr >= R || nc >= C || map[nr][nc] != 0) continue; // 만약 벗어나거나, 치즈일 경우 무시
							if(union(r*C+c, nr*C+nc)) // 다른 그룹끼리 묶을 경우
								q.offer(new Point(nr,nc)); // 새로 들어온 위치 저장
						}
					}					
				}
			}
		}
	}

	private static boolean mapChecking() { // 맵에서 치즈가 남아있는지 체크
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 1) { // 만약 치즈가 있을 경우 false 리턴
					return false;
				}
			}
		}
		return true;
	}

	private static boolean union(int a, int b) { // 그룹 묶는 메소드
		int rootA = find(a); 
		int rootB = find(b);
		if(rootA == rootB) return false; // 같은 그룹이라면 다시 묶을 필요가 없기 때문에 false 리턴
		group[rootB] = rootA; // 같은 그룹으로 묶어주기
		return true;
	}

	private static int find(int a) { // 해당 위치의 그룹이 어떤 그룹인지 찾는 메소드
		if(group[a] == a) return a; // 루트라면 자기자신을 리턴
		return group[a] = find(group[a]); // 루트가 아니라면 루트를 찾아서 리턴
	}
}
