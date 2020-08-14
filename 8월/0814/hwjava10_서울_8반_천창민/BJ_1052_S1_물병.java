package hwjava10_서울_8반_천창민;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1052_S1_물병 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String [] tmp = bf.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);
		if(N <=0 || K <= 0 || N > 10000000 || K > 1000) {
			System.out.println(-1);
			return;
		}
		int cnt = 0;
		while(Integer.bitCount(N) > K) {
			N += 1;
			cnt ++;
		}
		System.out.println(cnt);
	}
}
