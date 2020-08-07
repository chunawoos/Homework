import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class hw_algo0807_서울_8반_천창민 {
	
	static int N, K;
	static int[] count, visit;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String [] tmp = bf.readLine().split(" ");
		
		N = Integer.parseInt(tmp[0]);
		K = Integer.parseInt(tmp[1]);
		
		count = new int[100010];
		visit = new int[100010];
		count[N] = 1;
		visit[N] = 1;
		
		find();
		
		System.out.println(count[K]-1);
		
	}

	private static void find() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(N);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			int [] next = new int[3];
			next[0] = cur-1;
			next[1] = cur+1;
			next[2] = cur*2;
			
			for(int i=0; i<3 ;i++) {
				if(next[i] < 0 || next[i] > 100000)
					continue;
				if(visit[next[i]] == 0) {
					count[next[i]] = count[cur]+1;
					visit[next[i]] = 1;
					q.offer(next[i]);
				}
			}
		}
	}
}
