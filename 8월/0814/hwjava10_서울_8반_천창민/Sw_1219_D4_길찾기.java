package hwjava10_서울_8반_천창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Sw_1219_D4_길찾기 {
	
	static int [][] edge;
	static int [] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			String [] tmp = bf.readLine().split(" ");
			int N = Integer.parseInt(tmp[1]);
			edge = new int[100][2];
			visit = new int[100];
			boolean isExist = false;
			tmp = bf.readLine().split(" ");
			for(int i=0; i<N*2 ;i+=2) {
				int from = Integer.parseInt(tmp[i]);
				int to = Integer.parseInt(tmp[i+1]);
				if(to == 99) 
					isExist = true;
				if(edge[from][0] != 0)
					edge[from][1] = to;
				else
					edge[from][0] = to;
			}
			if(!isExist) {
				sb.append("#").append(tc).append(" ").append(0).append("\n");
				continue;
			}
			if(explore()) {
				sb.append("#").append(tc).append(" ").append(1).append("\n");				
			} else {
				sb.append("#").append(tc).append(" ").append(0).append("\n");
			}	
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		bf.close();
	}

	private static boolean explore() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(edge[0][0]);
		if(edge[0][1] != 0)
			q.offer(edge[0][1]);
		while(!q.isEmpty()) {
			int from = q.poll();
			visit[from] = 1;
			if(from == 99) {
				return true;
			}
			for(int i=0; i<=1; i++)   {
				if(edge[from][i] != 0 && visit[edge[from][i]] == 0) {
					q.offer(edge[from][i]);
				}
			}
		}
		return false;
	}
}
