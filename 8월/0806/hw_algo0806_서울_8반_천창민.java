import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hw_algo0806_서울_8반_천창민 {

	static int N; // 재료 개수
	static int [][] item; // 재료의 신맛, 쓴맛
	static long min; // 신맛 - 쓴맛 의 최소값
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine()); // 갯수 입력
		item = new int[N][2]; // 재료 초기화
		min = 100000000; // min 값 초기화
		for(int i=0; i<N; i++) {
			String [] tmp = bf.readLine().split(" "); // 재료의 신맛 쓴맛 입력
			item[i][0] = Integer.parseInt(tmp[0]); // 신맛 저장
			item[i][1] = Integer.parseInt(tmp[1]); // 쓴맛 저장
		}
		cook(1,0,0); // 재료 선택 초기 값 입력
		System.out.println(min); // 신맛 쓴맛 차이의 최솟값 출력
	}

	private static void cook(long sSum, long bSum, int cnt) { // 재료 선정

		if(cnt == N) { // 재료 N 가지를 다 골랐다!
			if(sSum == 1 || bSum == 0) // 만약 하나도 안 골랐다면 아웃
				return;
			if(Math.abs(sSum-bSum) < min) // 재료들의 신맛 쓴맛의 차이가 최소라면 min에 저장
				min = Math.abs(sSum-bSum);
			return;
		}
		cook(sSum*item[cnt][0],bSum+item[cnt][1], cnt+1); // item[cnt] 재료를 가져가겠다
		cook(sSum,bSum, cnt+1); // item[cnt] 재료는 필요없다
		
	}

}
