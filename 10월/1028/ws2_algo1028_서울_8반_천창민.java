import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ws2_algo1028_서울_8반_천창민 {
	private static int N, dir;
	private static int[][] game;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine()); // 테스트케이스 입력 받기
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken()); // 가로 세로 사이즈 입력 받기
			String tmp = st.nextToken(); // 방향 입력 받기
			if(tmp.equals("left")) { // 방향에 따라 int 값으로 변경
				dir = 0;
			} else if(tmp.equals("right")) {
				dir = 1;
			} else if(tmp.equals("up")) {
				dir = 2;
			} else if(tmp.equals("down")) {
				dir = 3;
			}
			game = new int[N][N]; // 배열 초기화
			for (int i = 0; i < N; i++) { // 배열 입력 받기
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					game[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			moveTile(); // 타일 합치는 메소드
			sb.append("#").append(tc).append("\n"); // 결과 값 StringBuilder로 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(game[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb); // 모든 결과 값 출력
	}

	private static void moveTile() { // 타일 합치는 메소드
		ArrayList<Integer> list = new ArrayList<>(); 
		switch(dir) { // 방향에 따른 switch
		case 0: // 왼쪽일 경우
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(game[i][j] != 0) // 0이 아닌 값 리스트에 저장
						list.add(game[i][j]);
				}
				for (int j = 0; j < list.size()-1; j++) { // 리스트에 값을 비교
					if(list.get(j).equals(list.get(j+1))) { // 같다면
						list.set(j, list.get(j)*2);  // 앞 부분의 값을 2배로 증가
						list.remove(j+1);	 		 // 뒷 부분은 리스트에서 삭제
					}
				}
				for (int j = 0; j < list.size(); j++) { // 리스트의 값만큼 해당 라인 값 변경
					game[i][j] = list.get(j);
				}
				for (int j = list.size(); j < N; j++) { // 리스트를 제외한 나머지 부분 0으로 채우기
					game[i][j] = 0;
				}
				list.clear(); // 리스트 비우기
			} break;
		case 1: // 오른쪽일 경우
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j >= 0; j--) { // 오른쪽에서부터 0이 아닌 값을 리스트에 저장 
					if(game[i][j] != 0)
						list.add(game[i][j]);
				}
				for (int j = 0; j < list.size()-1; j++) { // 같은 값이 있는지 비교
					if(list.get(j).equals(list.get(j+1))) { // 왼편에 있는 값과 같을 경우
						list.set(j, list.get(j)*2); // 오른쪽으로 합쳐주기
						list.remove(j+1); // 뒤에 있는 값 제거
					}
				}
				for (int j = N-1; j >= N-list.size(); j--) { // 오른쪽에서부터 list사이즈만큼 배열 값 변경
					game[i][j] = list.get((N-1)-j);
				}
				for (int j = N-list.size()-1; j >= 0; j--) { // list사이즈를 제외한 나머지 부분 0으로 채우기
					game[i][j] = 0;
				}
				list.clear(); // 리스트 비우기
			} break;
		case 2: // 위쪽일 경우
			for (int i = 0; i < N; i++) { 
				for (int j = 0; j < N; j++) { 
					if(game[j][i] != 0) { // 위에서부터 0이 아닌 값 리스트에 저장
						list.add(game[j][i]);
					}
				}
				for (int j = 0; j < list.size()-1; j++) { // 같은 값 비교
					if(list.get(j).equals(list.get(j+1))) { // 아래 값과 같을 경우
						list.set(j, list.get(j)*2); // 위쪽으로 합쳐주기
						list.remove(j+1); // 아래 있는 값 제거
					}
				}
				for (int j = 0; j < list.size(); j++) { // 위에서 부터 해당 라인 값 변경
					game[j][i] = list.get(j);
				}
				for (int j = list.size(); j < N; j++) { // list사이즈를 제외한 나머지 부분 0으로 채우기
					game[j][i] = 0;
				}
				list.clear(); // 리스트 비우기
			} break;
		case 3:
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j >= 0; j--) { // 아래쪽부터 0이 아닌 값 리스트에 저장
					if(game[j][i] != 0) {
						list.add(game[j][i]);
					}
				}
				for (int j = 0; j < list.size()-1; j++) { // 같은 값 비교
					if(list.get(j).equals(list.get(j+1))) { // 위 값과 같을 경우
						list.set(j, list.get(j)*2); // 아래쪽으로 합쳐주기
						list.remove(j+1); // 위의 값 제거
					}
				}
				for (int j = N-1; j >= N-list.size(); j--) { // 아래부터 해당 라인 값 변경
					game[j][i] = list.get((N-1)-j);
				}
				for (int j = N-list.size()-1; j >= 0; j--) { // list사이즈를 제외한 나머지 부분 0으로 채우기
					game[j][i] = 0;
				}
				list.clear(); // 리스트 비우기
			} break;			
		}
	}
}
