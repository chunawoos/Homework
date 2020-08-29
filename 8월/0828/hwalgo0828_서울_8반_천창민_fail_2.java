import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hwalgo0828_서울_8반_천창민_fail_2 {

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
		int max = 0;
		for(int i=0; i<N; i++) {
			int cnt = eating(d,k,Arrays.copyOfRange(belt, i, i+k),c);
			if(max < cnt) max = cnt;
			if(max == d+1) break;
		}

		System.out.println(max);
	}

	private static int eating(int d, int k, int [] list, int c) {
		
		int sum = k;
		boolean [] check = new boolean[d+1];
		for(int i=0; i<k; i++) {
			if(check[list[i]]) sum --;
			check[list[i]] = true;
		}
		if(!check[c]) sum++;

		return sum;
	}

}
