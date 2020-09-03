import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class wsalgo0903_서울_8반_천창민 {
	public static class Node implements Comparable<Node>{
		int no;
		long dis;
		
		public Node(int no, long dis) {
			this.no = no;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.dis, o.dis);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= testCase; tc++) {
			int N = Integer.parseInt(bf.readLine()); // 섬의 개수
			int [][] island = new int[N][2];
			
			StringTokenizer st;
			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(bf.readLine());
				for (int i = 0; i < N; i++) {
					island[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			double tax = Double.parseDouble(bf.readLine());
			
			long [][]distance = new long[N][N];
			for(int i=0; i<N-1; i++) {
				for(int j=i; j<N; j++) {
					distance[i][j] = (long)(Math.pow((island[i][0] - island[j][0]),2) + Math.pow((island[i][1] - island[j][1]),2));
					distance[j][i] = distance[i][j];
				}
			}
			
			int start = 0;
			long []path = new long[N];
			Arrays.fill(path, Long.MAX_VALUE);
			path[start] = 0;
			boolean [] v = new boolean[N];
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(start,path[start]));
			 
			Node cur = null;
			long result = 0;
			int cnt = 0;
			while(!pq.isEmpty()) {
				cur = pq.poll();
				
				if(v[cur.no]) continue;
				
				v[cur.no] = true;
				result += cur.dis;
				if(++cnt == N) break; 
				
				for (int i = 1; i < N; i++) {
					if(!v[i] && distance[cur.no][i] >0 && path[i] > distance[cur.no][i]) {
						path[i] = distance[cur.no][i];
						pq.offer(new Node(i, path[i]));
					}
				}
			}
			sb.append('#').append(tc).append(' ').append(Math.round(result*tax)).append('\n');
		}
		System.out.println(sb);
	}
}
