import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ws1algo0901_서울_8반_천창민_2_PQ {
	
	static class Vertex implements Comparable<Vertex>{
		int no, totalDistance; // totalDistance : 출발지에서 자신까지 오는 최단거리

		
		public Vertex(int no, int totalDistance) {
			this.no = no;
			this.totalDistance = totalDistance;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.totalDistance - o.totalDistance; // totalDistance가 작은 비용이 우선적으로 처리
		}
		
	}
	
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
		Vertex cur = null;
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start, dis[start]));
		while(!pq.isEmpty()){
			cur = pq.poll();
			visited[cur.no] = true;
			for(int j=0 ; j<list[cur.no].size(); j++) {
				if(!visited[list[cur.no].get(j).to] && dis[list[cur.no].get(j).to] > cur.totalDistance + list[cur.no].get(j).weight) {
					dis[list[cur.no].get(j).to] = cur.totalDistance + list[cur.no].get(j).weight;
					pq.offer(new Vertex(list[cur.no].get(j).to, dis[list[cur.no].get(j).to]));
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
