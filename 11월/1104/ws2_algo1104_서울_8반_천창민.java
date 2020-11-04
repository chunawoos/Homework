import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ws2_algo1104_서울_8반_천창민 {
	private static ArrayList<Integer>[] magnet;
	private static boolean[] connect;
	
	static int dx [] = {-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(bf.readLine());
			magnet = new ArrayList[5];
			for (int i = 1; i < 5; i++) {
				magnet[i] = new ArrayList<>();
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			connect = new boolean[4];
			StringTokenizer st = null;
			for (int i = 0; i < K; i++) {
				makeCon();
//				for (int j = 1; j < 4; j++) {
//					System.out.print(connect[j]+" ");
//				}
//				System.out.println();
//				for (int j = 1; j < 5; j++) {
//					for (int k = 0; k < 8; k++) {
//						System.out.print(magnet[j].get(k)+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
				st = new StringTokenizer(bf.readLine());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				Queue<Integer> q = new LinkedList<>();
				q.offer(num);
				boolean [] visit = new boolean[5];
				visit[num] = true;
				while(!q.isEmpty()) {
					int cur = q.poll();
					int curDir = (num%2 == cur%2) ? dir : -dir;
					switch(curDir) {
					case 1: {
						int m = magnet[cur].remove(7);
						magnet[cur].add(0, m);
					}	break;
					case -1: {
						int m = magnet[cur].remove(0);
						magnet[cur].add(7,m);
					}	break;
					}
					for (int j = 0; j < 2; j++) {
						int n = cur + dx[j];
						if(n < 1 || n > 4) continue;
						if(dx[j] < 0 && !connect[cur-1]) continue;
						if(dx[j] > 0 && !connect[cur]) continue;
						if(!visit[n]) {
							visit[n] = true;
							q.offer(n);
						}
					}
				}
			}
			int res = 0;
			for (int i = 1; i < 5; i++) {
				if(magnet[i].get(0) == 1) {
					res += 1 << (i-1);
				}
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void makeCon() {
		for (int i = 1; i < 4; i++) {
			if(magnet[i].get(2) != magnet[i+1].get(6)) {
				connect[i] = true;
			} else {
				connect[i] = false;
			}
		}
	}
}
