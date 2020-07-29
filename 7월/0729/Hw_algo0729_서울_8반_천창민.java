import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hw_algo0729_서울_8반_천창민 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=testCase; tc++) {
			String size = bf.readLine();
			StringTokenizer st = new StringTokenizer(size);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int [][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				String s =bf.readLine();
				st = new StringTokenizer(s);
				for(int j=0; j<N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			int sum=0, max=0;
			for(int i=0; i<N-M+1; i++)
				for(int j=0; j<N-M+1; j++) {
					sum = 0;
					for(int mi=i; mi<i+M; mi++)
						for(int mj=j; mj<j+M; mj++)
							sum+=map[mi][mj];
					if(max < sum)
						max = sum;
				}
			System.out.println("#"+tc+" "+max);
		}
	}
}
