

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ct01hw_서울_8반_천창민 {
	
	final static long p = 1234567891;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long result = Combination(n,r);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static long Combination(int n, int r) {
		long [] fac = new long[n+1];
		fac[0] = 1;
		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i-1]*i%p;
		}
		return (fac[n]* power(fac[r])%p * power(fac[n-r])%p)%p;
	}

	private static long power(long x) {
		long y = p-2;
		long pow = 1;
		x = x%p;
		while(y > 0) {
			if(y%2 == 1) {
				pow = (pow*x)%p;
			}
			y = y >> 1;
			x = x*x%p;
		}
		return pow;
	}
}
