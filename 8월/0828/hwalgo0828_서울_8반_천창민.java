
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hwalgo0828_서울_8반_천창민 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 접시 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		int [] belt = new int[N+k];
		for(int i=0; i<N; i++) {
			belt[i] = Integer.parseInt(bf.readLine());
		}
		for(int i=0; i<k; i++) {
			belt[N+i] = belt[i];
		}
		int [] check = new int[d+1];
		int sum = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<k;i++) {
			q.offer(belt[i]);
			if(check[belt[i]]++ == 0)
				sum ++;
		}
		int max;
		if(check[c] != 0) 
			max = sum;
		else
			max = sum+1;
		
		for(int i=k; i<N+k; i++) {
			
			if((--check[q.poll()]) == 0) {
				sum--;
			}
			q.offer(belt[i]);
			if(check[belt[i]]++ == 0)
				sum++;
			
			if(check[c] != 0) 
				max = (max < sum) ? sum :max;
			else
				max = (max < sum+1) ? sum+1 : max;
		}

		System.out.println(max);
	}

}
