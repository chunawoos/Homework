import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class hw_algo0805_서울_8반_천창민 {
	
	static int [] di = {-1,1,0,0};
	static int [] dj = {0,0,-1,1};
	static int [][] map;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		map = new int[N][N];
		
		for(int i=0 ;i<N; i++) {
			String [] tmp = bf.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		int group = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					group++;
					map[i][j] = -group;
					combine( i, j);
				}
			}
		}
		
		int [] size = new int[group+1];
		for(int s=1; s<size.length; s++) {
			for(int i=0; i<N; i++) {
				for(int j=0 ; j<N; j++) {
					if(Math.abs(map[i][j]) == s) {
						size[s] += 1;
					}
				}
			}
		}
		Arrays.sort(size);
		System.out.println(group);
		for(int i=1;i<group+1; i++)
			System.out.println(size[i]);
	}

	private static void combine(int col, int row) {
		int pi= col, pj= row;
		for(int i=0; i<4; i++) {
			if(pi+di[i] < 0 || pi+di[i] >= N || pj+dj[i] < 0 || pj+dj[i] >= N) 
				continue;
			
			if(map[pi+di[i]][pj+dj[i]] == 1) {
				map[pi+di[i]][pj+dj[i]] = map[col][row];
				combine(pi+di[i], pj+dj[i]);
			}
		}
	}
}
