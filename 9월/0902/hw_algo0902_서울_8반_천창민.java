import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hw_algo0902_서울_8반_천창민 {
	
	private static int[][] possibility, cell, placeOfCore;
	private static int N, core, min;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(bf.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			N =  Integer.parseInt(bf.readLine().trim());
			cell = new int[N][N];
			StringTokenizer st;
			placeOfCore = new int[12][2];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
					if(cell[i][j] == 1) {
						placeOfCore[cnt][0] = i;
						placeOfCore[cnt][1] = j;
						cnt++;
					}
				}
			}
			
			core = 0;
			min = Integer.MAX_VALUE;
			possibility = new int[cnt][4];
			int [] choice = new int[cnt];
			for(int i=0; i<cnt; i++) {
				int r = placeOfCore[i][0];
				int c = placeOfCore[i][1];
				
				for(int j=0; j<4; j++) {
					int nr = r + dx[j];
					int nc = c + dy[j];
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
						Arrays.fill(possibility[i], 0);
						break;
					}
					int wCnt = 0;
					while(true) {
						if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
							possibility[i][j] = wCnt;
							break;
						}
						if(cell[nr][nc] == 1) {
							possibility[i][j] = -1;
							break;
						}
						nr += dx[j];
						nc += dy[j];
						wCnt++;
					}
				}
			}
			findMaxCore(0,0,0,choice);
			System.out.println("#"+tc+" "+min);
		}
	}

	private static void findMaxCore(int coreNo, int sum, int cnt, int[] choice) {
		if(cnt+choice.length-coreNo < core)
			return;
		if(coreNo == choice.length) {
			if(isPossible(choice)) {

				if(core < cnt) {
					core = cnt;
					min = sum;
				} else if(core == cnt) {
					if(min > sum)
						min = sum;
				}
			}
			return;
		}
		
		choice[coreNo] = 0;
		if(possibility[coreNo][0] == -1) {			
			findMaxCore(coreNo+1,sum,cnt,choice);
		} else
			findMaxCore(coreNo+1,sum+possibility[coreNo][0],cnt+1,choice);
		if(possibility[coreNo][0] == 0) {
			return;
		}
		
		choice[coreNo] = 1;
		if(possibility[coreNo][1] == -1) {			
			findMaxCore(coreNo+1,sum,cnt,choice);
		} else
			findMaxCore(coreNo+1,sum+possibility[coreNo][1],cnt+1,choice);
		
		choice[coreNo] = 2;
		if(possibility[coreNo][2] == -1) {			
			findMaxCore(coreNo+1,sum,cnt,choice);
		} else
			findMaxCore(coreNo+1,sum+possibility[coreNo][2],cnt+1,choice);
		
		choice[coreNo] = 3;
		if(possibility[coreNo][3] == -1) {			
			findMaxCore(coreNo+1,sum,cnt,choice);
		} else
			findMaxCore(coreNo+1,sum+possibility[coreNo][3],cnt+1,choice);

	}

	private static boolean isPossible(int[] choice) {
		int [][] cellCopy = new int [N][];
		for(int i=0; i<N; i++) {
			cellCopy[i] = Arrays.copyOf(cell[i], N);
		}
		for(int i=0; i<choice.length; i++) {
			if(possibility[i][choice[i]] == 0 || possibility[i][choice[i]] == -1) 
				continue;
			int r = placeOfCore[i][0];
			int c = placeOfCore[i][1];
			switch(choice[i]) {
			case 0:
				while(r>0) {
					r--;
					if(cellCopy[r][c] != 0) return false;
					cellCopy[r][c] = 2;
				}
				break;
			case 1:
				while(r<N-1) {
					r++;
					if(cellCopy[r][c] != 0) return false;
					cellCopy[r][c] = 2;
				}
				break;
			case 2:
				while(c>0) {
					c--;
					if(cellCopy[r][c] != 0) return false;
					cellCopy[r][c] = 2;
				}
				break;
			case 3:
				while(c<N-1) {
					c++;
					if(cellCopy[r][c] != 0) return false;
					cellCopy[r][c] = 2;
				}
			}
		}
		return true;
	}
}
