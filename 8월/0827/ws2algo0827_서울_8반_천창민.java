import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ws2algo0827_서울_8반_천창민 {
	
	static int N; // 고객 수
	static int [][] loc; // 고객의 좌표
	static int minDis; // 최소 거리 경로
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 콘솔에서 입력 받기 위한 클래스
		StringBuilder sb = new StringBuilder();// 각 TestCase의 값을 저장한 String
		
		int testCase = Integer.parseInt(bf.readLine()); // TestCase
		
		for(int tc=1; tc<=testCase; tc++) { // TestCase 만큼 반복
			N =  Integer.parseInt(bf.readLine()); // 고객 수 입력받기
			loc = new int[N+2][2]; // 회사 좌표 + 고객 좌표 + 집 좌표 --> N+2개
			boolean [] visit = new boolean[N+1]; // 내가 방문했는지 표시
			minDis = 10000; // 최소 거리 초기화
			
			String [] tmp = bf.readLine().split(" "); // 모든 좌표 받기
			loc[0][0] = Integer.parseInt(tmp[0]); // 회사의 좌표 분리
			loc[0][1] = Integer.parseInt(tmp[1]);
			loc[N+1][0] = Integer.parseInt(tmp[2]); // 집의 좌표 분리
			loc[N+1][1] = Integer.parseInt(tmp[3]);
			for(int i=2; i<=N*2; i+=2) { // 반복문을 통해 나머지 고객의 주소를 저장
				loc[i/2][0] = Integer.parseInt(tmp[i+2]);
				loc[i/2][1] = Integer.parseInt(tmp[i+3]);
			}// 고객 좌표 저장 반복문
			
			chooseDis(0,0,0,visit); // 순열
			
			sb.append("#"+tc+" "+minDis+"\n"); // TestCase의 답을 저장
		}// Testcase 반복문
		System.out.println(sb);
	}// main

	private static void chooseDis(int cur, int cnt, int depth, boolean[] visit) { 
								//cur == 현재 좌표, cnt == 여태 움직인 거리, depth == 현재 들린 고객 수, visit[] == 내가 들렸던 곳 true로 저장한 배열
		if(cnt > minDis) // 만약 cnt가 이미 minDis를 넘겼다면 중지
			return;
		if(depth == N) { // 마지막까지 다 방문했다면 집으로 돌아간 뒤, 최적 경로라면 minDis에 저장
			cnt += Math.abs(loc[N+1][0]-loc[cur][0])+ Math.abs(loc[N+1][1]-loc[cur][1]); // 집까지의 거리 저장
			if(minDis > cnt) { // 만약 최적 경로라면 minDis에 저장
				minDis = cnt;
			}
			return;
		}// 기저 조건
		
		for(int i=1; i<=N; i++) { // 모든 루트를 탐색
			if(!visit[i]) { // 만약 방문했다면 pass
				visit[i] = true;
				cnt += Math.abs(loc[cur][0]-loc[i][0])+ Math.abs(loc[cur][1]-loc[i][1]);// cnt 저장
				chooseDis(i,cnt,depth+1,visit);// 다음 행선지로 출발
				visit[i] = false; // visit 원상복귀
				cnt -= Math.abs(loc[cur][0]-loc[i][0])+ Math.abs(loc[cur][1]-loc[i][1]); // cnt 돌려놓기
			}
		} // 루트 탐색 반복문
	}// 순열 메소드
} // class
