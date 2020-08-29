import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class hwalgo0828_서울_8반_천창민_fail_1 {
	private static int N, d, k, c;
	private static LinkedList<Integer> belt;
//	private static boolean[] type;
//	private static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 접시 수
		d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		belt = new LinkedList<Integer>();
		for(int i=0; i<N; i++) {
			belt.add(Integer.parseInt(bf.readLine()));
		}
		for(int i=0; i<k; i++) {
			belt.add(belt.get(i));
		}
//		max = 0;
//		type = new boolean[d+1];
		int max = 0;
		for(int i=0; i<N; i++) {
			boolean[] type = new boolean[d+1];
			int cnt = 0;
			boolean coupon = true;
			for(int j=i; j<i+k; j++) {
				if(type[belt.get(j)]) cnt--;
				type[belt.get(j)] = true;
				if(belt.get(j) == c) coupon = false;
				cnt ++;
			}
			if(coupon) cnt++;
			if(max < cnt) max = cnt;
			if(max == k+1) break;
		}
//		for(int i=0; i<N; i++) {
//			if(i==0)
//				dfs(N-1,0,0,0,1);
//			else
//				dfs(i-1,0,0,0,1);
//		}
		System.out.println(max);
	}

//	private static void dfs(int start,int last,int depth ,int cnt, int coupon) {
//		if(cnt == k) {
//			if(coupon == 1) {
//				System.out.println(k+1);
//				System.exit(0);
//			}
////			System.out.println(start+" "+last+" "+cnt);
//			max = cnt;
//			return;
//		}
//		
//		if(depth == k)
//			return;
//		for(int i=start+depth; i<N+k; i++) {
//			if(type[belt.get(i)]) {
//				if(coupon == 1) {
////					System.out.print("들어옴? ");
//					cnt +=1;
//				}
////				System.out.println(belt.get(i)+" "+ type[belt.get(i)]);
////				System.out.println("중도하차 "+ start+" "+last+" "+cnt);
//				if(max < cnt) max = cnt;
//				return;
//			}
//			type[belt.get(i)] = true;
//			if(belt.get(i) == c) 
//				dfs(start, i,depth+1 ,cnt+1, 0);
//			else
//				dfs(start, i,depth+1 ,cnt+1, coupon);
//			type[belt.get(i)] = false;			
//		}
//	}
}
