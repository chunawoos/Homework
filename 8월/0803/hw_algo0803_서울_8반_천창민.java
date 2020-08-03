import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hw_algo0803_서울_8반_천창민 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=testCase; tc++) {
			String [] tmp = bf.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int M = Integer.parseInt(tmp[1]);
			int [] cookie = new int[N];
			tmp = bf.readLine().split(" ");
			for(int i=0; i<N; i++)
				cookie[i] = Integer.parseInt(tmp[i]);
			boolean isExist = false;
			int max= -1;
			for(int i=0;i<N; i++) {
				if(isExist)
					break;
				for(int j=i+1; j<N; j++) {
					int sum = cookie[i] + cookie[j];
					if(sum == M) {
						max = M;
						isExist = true;
						break;
					}
					else if(sum < M) {
						if(max < sum)
							max = sum;
					}
					
				}
			}
			System.out.println("#"+tc+" "+max);
		}
		
	}

}
