import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hw_algo0804_서울_8반_천창민 {
	
	static int [] root;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String [] tmp = bf.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]); // 사람 수 
		int M = Integer.parseInt(tmp[1]); // 그룹만드는 수
		root = new int[N+1];
		
		for(int i=0; i<M; i++) {
			tmp = bf.readLine().split(" ");
			int A = Integer.parseInt(tmp[0]);
			int B = Integer.parseInt(tmp[1]);
			
			union(A,B);
		}
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(root[i] == 0)
				cnt++;
		}
		System.out.println(cnt);
	}
	
	private static int find(int a) {
		if(root[a] == 0) 
			return a;
		else
			return root[a] = find(root[a]);
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) 
			return;
		else 
			root[rootB] = rootA;
	}
}
