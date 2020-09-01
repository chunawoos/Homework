import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ws1algo0901_서울_8반_천창민_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E= Integer.parseInt(st.nextToken());
		int start= Integer.parseInt(bf.readLine());
		
		ArrayList<Node> [] list = new ArrayList[V+1];
		for(int i=1; i<=V; i++)
			list[i] = new ArrayList<Node>();
		int []dis = new int[V+1];
		boolean [] visited = new boolean[V+1];
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(dis, INF);
		dis[start] = 0;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[f].add(new Node(t,w));
		}
		int min = 0, cur = 1;
		for(int i=1; i<= V; i++) {
			min = INF;
			for (int j = 1; j <= V; j++) {
				if(!visited[j] && min > dis[j]) {
					min = dis[j];
					cur = j;
				}
			}
			visited[cur] = true;
			for(int j=0 ; j<list[cur].size(); j++) {
				if(!visited[list[cur].get(j).to] && dis[list[cur].get(j).to] > min + list[cur].get(j).weight) {
					dis[list[cur].get(j).to] = min + list[cur].get(j).weight;
				}
			}
		}
		for(int i=1; i<=V; i++) {
			if(dis[i] != INF)
				System.out.println(dis[i]);
			else
				System.out.println("INF");
		}
	}
	public static class Node {
		int to;
		int weight;
		public Node() {}
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}
