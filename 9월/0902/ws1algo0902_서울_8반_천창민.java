import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ws1algo0902_서울_8반_천창민 {
	private static Queue<Point> q;
	private static int[][] room, airCleaner, expection;
	private static int row, col;
	
	private static int [] dx = {-1,1,0,0};
	private static int [] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		
		room = new int[row][col];
		expection = new int[row][col];
		airCleaner = new int[2][2];
		q = new LinkedList<>();
		int ashCnt = 0;
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < col; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j] >= 5) {
					q.offer(new Point(i,j));
				} else if(room[i][j] <0) {
					airCleaner[1][0] = i;
					airCleaner[1][1] = j;
					continue;
				}
				ashCnt += room[i][j];
			}
		}
		airCleaner[0][0] = airCleaner[1][0] -1;
		airCleaner[0][1] = airCleaner[1][1];
		for(int i=0; i<time; i++) {
			diffusion();
			ashCnt -= activateCleaner();
			if(i == time-1)
				continue;
			
			for(int k=0; k<row; k++) {
				for(int j=0; j<col; j++) {
					if(room[k][j] >= 5) {
						q.offer(new Point(k,j));
					}
				}
			}
		}
		
		System.out.println(ashCnt);
	}

	private static int activateCleaner() {

		int cnt = 0;
		for(int i= airCleaner[0][0]-1; i >=0; i--) {
			if(room[i+1][0] == -1) {
				cnt += room[i][0];
				continue;
			}
			room[i+1][0] = room[i][0];
		}
		for(int i=1; i<col; i++) {
			room[0][i-1] = room[0][i];
		}
		for(int i=1; i<= airCleaner[0][0]; i++) {
			room[i-1][col-1] = room[i][col-1];
		}
		for(int i= col-1; i>1; i--) {
			room[airCleaner[0][0]][i] = room[airCleaner[0][0]][i-1];
		}
		room[airCleaner[0][0]][1] = 0;
		
		
		for(int i= airCleaner[1][0]+1; i < row ; i++) {
			if(room[i-1][0] == -1) {
				cnt += room[i][0];
				continue;
			}
			room[i-1][0] = room[i][0];
		}
		for(int i=1; i< col; i++) {
			room[row-1][i-1] = room[row-1][i];
		}
		for(int i=row-2; i>=airCleaner[1][0]; i--) {
			room[i+1][col-1] = room[i][col-1];
		}
		for(int i= col-2;i > 0; i--) {
			room[airCleaner[1][0]][i+1] = room[airCleaner[1][0]][i];
		}
		room[airCleaner[1][0]][1] = 0;
		return cnt;
	}

	private static void diffusion() {
		for(int i=0; i<row; i++)
			Arrays.fill(expection[i], 0);
		int r, c, nr, nc, div;
		while(!q.isEmpty()) {
			r = q.peek().x;
			c = q.peek().y;
			q.poll();
			div = room[r][c]/5;
			for(int i=0; i<4; i++) {
				nr = r+ dx[i];
				nc = c+ dy[i];
				if(nr < 0 || nc <0 || nr >= row || nc >= col || room[nr][nc] == -1) continue;
				expection[r][c]-= div;
				expection[nr][nc] += div;
			}
		}
		for(int i=0; i<row; i++)
			for(int j=0; j<col; j++)
				room[i][j] += expection[i][j];
	}
}
