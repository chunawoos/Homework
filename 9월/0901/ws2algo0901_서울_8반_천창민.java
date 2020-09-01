import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ws2algo0901_서울_8반_천창민 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String T = bf.readLine();
		String P = bf.readLine();
		int [] fail = new int[P.length()];
		
		for(int i=1, j=0; i<P.length(); i++) {
			while(j > 0 && P.charAt(i) != P.charAt(j)) {
				j = fail[j-1];
			}
			if(P.charAt(i) == P.charAt(j)) fail[i] = ++j;
		}

		int cnt = 0;
		ArrayList<Integer> listT = new ArrayList<>();
		
		for(int i=0, j=0; i< T.length(); i++) {
			while(j > 0 && T.charAt(i) != P.charAt(j)) j = fail[j-1];
			if(T.charAt(i) == P.charAt(j)) {
				if(j == P.length()-1) {
					cnt++;
					listT.add(i-j+1);
					j = fail[j];
				}
				else
					j++;
			}
		}
		System.out.println(cnt);
		for(int i=0; i<cnt; i++)
			System.out.print(listT.get(i)+" ");
		System.out.println();
	}
}
