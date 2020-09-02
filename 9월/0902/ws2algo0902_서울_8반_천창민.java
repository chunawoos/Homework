import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ws2algo0902_서울_8반_천창민 {
	private static ArrayList<Integer>[] list;
	private static int[] population;
	private static int N, min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		population = new int[N+1];
		min = Integer.MAX_VALUE;
		int [] team = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			list[i] = new ArrayList<Integer>();
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		list[0] = new ArrayList<Integer>();

		powerSet(team,1);
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	private static void powerSet(int[] team, int cnt) {

		if(cnt == N+1) {
			
			if(isGroup(team,0) && isGroup(team,1)) {
				calculate(team);
			}
			return;
		}
		
		team[cnt] = 0;
		powerSet(team, cnt+1);
		
		team[cnt] = 1;
		powerSet(team, cnt+1);
	}


	private static boolean isGroup(int[] team, int teamNo) {
		boolean[] v = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			if(team[i] == teamNo) {
				q.offer(i);
				v[i] = true;
				break;
			}
		}
		
		if(q.isEmpty()) {
			return false;
		}
		int cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int i = 1; i <= N; i++) {
				if(v[i]) {
					continue;
				}
				if(team[i] != teamNo) {
					continue;
				}
				if(!list[cur].contains(i)) {
					continue;
				}
				q.offer(i);
				v[i] = true;
			}
		}
		for(int i = 1; i <= N; i++) {
			if(team[i] != teamNo) {
				continue;
			}
			if( !v[i] ) {
				return false;
			}
		}
//		boolean [] group = new boolean[N+1];
//		int start = 0;
//		for(int i=1; i<=N; i++)
//			if(team[i] == teamNo) {
//				group[i] = true;
//				start = i;
//				break;
//			}
//		for(int i=start; i<=N; i++) {
//			if(team[i] != teamNo) continue;
//			if(!group[i]) continue;
//			for (int j = start; j <= N; j++) {
//				if(i==j) continue;
//				if(group[j]) continue;
//				if(team[j] != teamNo) continue;
//				if(!list[i].contains(j)) {
//					continue;
//				}
//				group[j] = true;
//			}
//		}
//		for(int i=1; i<=N; i++) {
//			if(team[i] == teamNo && !group[i]) {
//				
//				return false;
//			}
//		}
		return true;
	}
	private static void calculate(int[] team) {
		int sum1 = 0, sum2 = 0;
		for(int i=1; i<=N; i++) {
			if(team[i] == 0) 
				sum1 += population[i];
			else
				sum2 += population[i];
		}
		if(min > Math.abs(sum1 - sum2))
			min = Math.abs(sum1 - sum2);
	}
}
