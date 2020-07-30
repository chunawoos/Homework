import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class hwalgo0730_서울_8반_천창민 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		String [] tmp = bf.readLine().split(" ");
		Stack<int[]> st = new Stack<int[]>();
		int tow[][] = new int[num][2];
		int pop[] = new int[2];
		int fin[] = new int[num];
		
		for(int i=0; i<num; i++) {
			tow[i][0] = i+1;
			tow[i][1] = Integer.parseInt(tmp[i]);
			if(st.isEmpty()) {
				st.push(tow[i]);
				continue;
			}
			while(!st.isEmpty()) {
				pop = st.peek();
				if(pop[1] <= tow[i][1]) {
					st.pop();
					continue;
				}
				else {
					fin[i] = pop[0];
					st.push(tow[i]);
					break;
				}
			}
			if(st.isEmpty()) {
				fin[i] = 0;
				st.push(tow[i]);
			}
		}
		for(int i=0; i<num; i++)
			System.out.print(fin[i]+" ");
		System.out.println();
	}
}