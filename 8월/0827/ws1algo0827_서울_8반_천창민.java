import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ws1algo0827_서울_8반_천창민 {
	private static int row, col, cnt;
	private static char[][] map;
	private static boolean [][] v;
	
	private static int [] dx = {-1,0,1};
		
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		map = new char[row][];
		for(int i=0; i<row; i++)
			map[i] = bf.readLine().toCharArray();
		v = new boolean[row][col];
		
//		for(int i=0; i<row; i++)
//			setPipe(i,1);
		setPipe();
//		choose(0);
		System.out.println(cnt);
	}

//	private static void choose(int rowNo) {
//		
//	}

//	private static void setPipe(int sR, int colN) {
	private static void setPipe() {
//		if(colN == col) {
//			c[sR][cnt[sR]] = Arrays.copyOf(pipe, colN);
//			cnt[sR]++;
//			return;
//		}
		
		for(int j = 0; j<row; j++) {
//			pipe[colN] = j;
//			if(checking(sR, colN)) {
//				setPipe(sR,colN+1);
//			}
			v[j][0] = true;
			checking(j,0);
		}
		
	}

	private static boolean checking(int sR, int colN) {
		
		if(colN == col-1) {
			++cnt;
			return true;
		}
//		if(map[pipe[colN]][colN] != '.') {
//			return false;
//		}
//		if(colN == 1) {
//			if(Math.abs(sR-pipe[colN]) <= 1) {
//				return true;
//			}
//		}
//		else {
//			if(Math.abs(pipe[colN-1] - pipe[colN]) <= 1) {
//				return true;				
//			}
//		}
		int r,c= colN+1;
		for(int i=0; i<3; i++) {
			r = sR+dx[i];
			if(r <0 || r>= row || v[r][c] ||map[r][c] == 'x') continue;
			
			v[r][c] = true;
			if(checking(r,c)) return true;
		}
		return false;
	}
}
