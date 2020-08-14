package hwjava10_서울_8반_천창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Sw_2948_D3_문자열교집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=testCase; tc++) {
			bf.readLine();
			String [] tmp = bf.readLine().split(" ");
			String [] tmp2 = bf.readLine().split(" ");
			Set<String> s = new HashSet<>();
			for(int i=0; i<tmp.length;i++) {
				s.add(tmp[i]);
			}
			for(int i=0; i<tmp2.length;i++) {
				s.add(tmp2[i]);
			}
			
			sb.append("#").append(tc).append(" ").append((tmp.length+tmp2.length-s.size())).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		bf.close();
	}

}
