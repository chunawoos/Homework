import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hwalgo0826_서울_8반_천창민 {
	
	private static int[][] map;
	private static int [] dx = {0,1,1,1};
	private static int [] dy = {1,-1,0,1};
	private static int winner,leftX, leftY;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new int[19][19];
		for(int i=0; i<19; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0; j<19; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		boolean flag = false;
		battle :
		for(int i=0; i<19; i++) {
			for(int j=0; j<19;j++) {
				if(map[i][j] == 1 || map[i][j] == 2) {
;
					if(search(i,j, (map[i][j] == 1)? 1:2)) {
						flag = true;
						break battle;
					}
				}
			}
		}
		if(flag) 
			System.out.println(winner+"\n"+leftX+" "+leftY);
		else
			System.out.println(0);
	}
	private static boolean search(int x, int y, int col) {
		for(int i=0; i<4; i++) { // 우, 하좌, 하, 하우
			if(x-dx[i] >= 0 && x-dx[i] <19 && y-dy[i] >= 0 && y-dy[i] < 19) {
				if(map[x-dx[i]][y-dy[i]] == col)
					continue;
			}
			int cnt = 1;
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(cx <0 || cy <0 || cx>=19 || cy>=19)
				continue;
			if(map[cx][cy] == col) {
				cnt++;
				int tmpx = cx;
				int tmpy = cy;
				while(true) {
					tmpx += dx[i];
					tmpy += dy[i];
					if(tmpx < 0 || tmpy < 0 || tmpx >= 19 || tmpy >=19)
						break;
					if(map[tmpx][tmpy] != col)
						break;
					cnt++;
				}
				if(cnt == 5) {
					winner = col;
					if(i == 1) {
						leftX = tmpx-dx[i]+1;
						leftY = tmpy-dy[i]+1;
					}else {
						leftX = x+1;
						leftY = y+1;
					}			
					return true;
				}
			}
		}
		return false;
	}	
}
