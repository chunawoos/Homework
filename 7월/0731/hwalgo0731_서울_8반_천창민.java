import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class hwalgo0731_서울_8반_천창민 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<Integer>();

		for(int tc=1; tc<=10; tc++) {
			int S = Integer.parseInt(bf.readLine());
			int [] cal = new int[S];
			String tmp = bf.readLine();
			int cnt = 0;
			while(cnt < S) {
				char part = tmp.charAt(cnt);
				cal[cnt] = part - '0';
				if(cal[cnt] > 0)  {
					st.push(cal[cnt]);
					cnt++;
				}
				else if(cal[cnt] == -5) {
					cnt++;
					continue;
				}
				else {
					part = tmp.charAt(++cnt);
					cal[cnt] = part-'0';
					cal[cnt] = cal[cnt]*st.pop();
					st.push(cal[cnt]);
					cnt++;
				}
			}
			int sum = 0;
			while(!st.isEmpty()) {
				sum += st.pop();
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}
