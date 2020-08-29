import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ws1algo0828_서울_8반_천창민 {
	
	private static int fullCnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= testCase; tc++) {
			int N = Integer.parseInt(bf.readLine());
			int [] W = new int [N];
			fullCnt = 0;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int i=0; i<N; i++) {
				W[i] = Integer.parseInt(st.nextToken());
			}
			boolean[] V = new boolean[1000];
			dfs(V,W,0,0,0);
			sb.append('#').append(tc).append(' ').append(fullCnt).append('\n');
		}
		System.out.println(sb);
	}

	private static void dfs(boolean[] V, int[] W, int cnt, int lsum, int rsum) {
		
		
		if(cnt == W.length) {
			fullCnt++;
			return;
		}
		
		for(int i=0; i<W.length; i++) {
			if(V[W[i]]) continue;
			V[W[i]] = true;
			
			dfs(V,W,cnt+1,lsum+W[i], rsum);
			if(lsum >= rsum+W[i]) 
				dfs(V,W,cnt+1,lsum, rsum+W[i]);
			V[W[i]] = false;
		}
		
	}
}
