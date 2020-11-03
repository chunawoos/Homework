

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hw_algo1103_서울_8반_천창민 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(bf.readLine());
		int [][] store = new int[N][2];
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(bf.readLine());
			store[i][0] = Integer.parseInt(st.nextToken());
			store[i][1] = Integer.parseInt(st.nextToken());
		}
		int [] guard = new int[2];
		st = new StringTokenizer(bf.readLine());
		guard[0] = Integer.parseInt(st.nextToken());
		guard[1] = Integer.parseInt(st.nextToken());
		
		int result = 0;
		switch(guard[0]) {
		case 1:
			for (int i = 0; i < N; i++) {
				switch(store[i][0]) {
				case 1:
					result += Math.abs(guard[1] - store[i][1]);
					break;
				case 2:
					result += row + Math.min(guard[1]+store[i][1],col-guard[1]+col-store[i][1]);
					break;
				case 3:
					result += guard[1] + store[i][1];
					break;
				case 4:
					result += col - guard[1] + store[i][1];
				}
			} break;
		case 2:
			for (int i = 0; i < N; i++) {
				switch(store[i][0]) {
				case 1:
					result += row + Math.min(guard[1]+store[i][1],col-guard[1]+col-store[i][1]);
					break;
				case 2:
					result += Math.abs(guard[1] - store[i][1]);
					break;
				case 3:
					result += guard[1] + row - store[i][1];
					break;
				case 4:
					result += col - guard[1] + row - store[i][1];
				}
			} break;
		case 3:
			for (int i = 0; i < N; i++) {
				switch(store[i][0]) {
				case 1:
					result += guard[1] + store[i][1];
					break;
				case 2:
					result += row- guard[1] + store[i][1];
					break;
				case 3:
					result += Math.abs(guard[1] - store[i][1]);
					break;
				case 4:
					result += col + Math.min(guard[1]+store[i][1],row-guard[1]+row-store[i][1]);
				}
			} break;
		case 4:
			for (int i = 0; i < N; i++) {
				switch(store[i][0]) {
				case 1:
					result += guard[1] + col - store[i][1];
					break;
				case 2:
					result += row - guard[1] + col - store[i][1];
					break;
				case 3:
					result += col + Math.min(guard[1]+store[i][1],row-guard[1]+row-store[i][1]);
					break;
				case 4:
					result += Math.abs(guard[1] - store[i][1]);
				}
			}
		}
		System.out.println(result);
	}
}
