import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hw_algo1029_서울_8반_천창민 {
	
	private static int N, K, D, dir;
	private static int[][] change, apple, map;
	private static ArrayList<Point> list;
	
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		K = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		apple = new int[K][2];
		StringTokenizer st = null;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			apple[i][0] = Integer.parseInt(st.nextToken())-1;
			apple[i][1] = Integer.parseInt(st.nextToken())-1;
		}
		D = Integer.parseInt(bf.readLine());
		change = new int[D][2];
		for (int i = 0; i < D; i++) {
			st = new StringTokenizer(bf.readLine());
			change[i][0] = Integer.parseInt(st.nextToken());
			if(st.nextToken().equals("D"))
				change[i][1] = 1;
			else 
				change[i][1] = 2;
		}
		int sec = 0;
		map[0][0] = 1;
		list = new ArrayList<>();
		list.add(new Point(0,0));
		while(true) {
			sec++;
			if(!moveSnake()) { 
				break;
			}
			makeDir(sec);
		}
		System.out.println(sec);
	}


	private static boolean moveSnake() {
		int r = list.get(0).x + dx[dir];
		int c = list.get(0).y + dy[dir];
		if(!validCheck(r,c)) {
			return false;
		}
		list.add(0,new Point(r,c));
		map[r][c] = 1;
		if(!appleCheck(r,c)) {
			int tailR = list.get(list.size()-1).x;
			int tailC = list.get(list.size()-1).y;
			map[tailR][tailC] = 0;
			list.remove(list.size()-1);
		}
		
		return true;
	}


	private static boolean validCheck(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= N) return false;
		if(map[r][c] != 0) return false;
		return true;
	}


	private static boolean appleCheck(int r, int c) {
		for (int i = 0; i < K; i++) {
			if(apple[i][0] == r && apple[i][1] == c) {
				apple[i][0] = -100;
				return true;
			}
		}
		return false;
	}


	private static void makeDir(int sec) {
		for (int i = 0; i < D; i++) {
			if(change[i][0] == sec) {
				switch(change[i][1]) {
				case 1:
					dir = (dir+1)%4;
					break;
				case 2:
					dir = (dir == 0)? 3 : dir-1;
				}
				break;
			}
		}
	}
}
