import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ws1algo0826_서울_8반_천창민 {
	private static int row, col, spinNum;
	private static int [][] map, mapCopy,spin;
	private static int finMin;
	private static Queue<int[]> q;
	private static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		spinNum = Integer.parseInt(st.nextToken());
		
		map = new int[row][col];
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<col; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		spin = new int [spinNum][3];
		for(int i=0; i<spinNum; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<3; j++)
				spin[i][j] = Integer.parseInt(st.nextToken());
			spin[i][0] -= 1;
			spin[i][1] -= 1;
		}
		
		finMin = 1500000;
		q = new LinkedList<>();
		check = new boolean[spinNum];
		permutation(0, new int[spinNum]);
		while(!q.isEmpty()) {
			mapCopy = new int[row][col];
			for(int i=0 ; i<row; i++)
				mapCopy[i] = Arrays.copyOf(map[i], col);
			spinning(0,1,q.poll());
			
			int min = findA();
			if(min < finMin)
				finMin = min;
		}
		
		System.out.println(finMin);
	}

	private static int findA() {
		int min = 1500000;
		for(int i=0; i<row; i++) {
			int sum = 0;
			for(int j=0; j<col; j++) {
				sum += mapCopy[i][j];
			}
			if(sum < min)
				min = sum;
		}
		return min;
	}

	private static void spinning(int cycle, int spinning,int [] order) {
		if(cycle == spinNum) {
			return;
		}
		int []x = {spin[order[cycle]][0]-spinning, spin[order[cycle]][0]+spinning};
		int []y = {spin[order[cycle]][1]-spinning, spin[order[cycle]][1]+spinning};
		int temp = mapCopy[x[0]][y[0]];
		for(int i=x[0]; i<x[1]; i++) 
			mapCopy[i][y[0]] = mapCopy[i+1][y[0]];
		for(int i=y[0];i<y[1];i++)
			mapCopy[x[1]][i] = mapCopy[x[1]][i+1];
		for(int i=x[1]; i>x[0]; i--) 
			mapCopy[i][y[1]] = mapCopy[i-1][y[1]];
		for(int i=y[1]; i>y[0];i--)
			mapCopy[x[0]][i] = mapCopy[x[0]][i-1];
		mapCopy[x[0]][y[0]+1] = temp;
		
		if(spinning == spin[order[cycle]][2]) {
			spinning = 1;
			cycle++;
		} else
			spinning ++;
		spinning(cycle,spinning, order);
	}
	private static void permutation(int cnt, int [] order) {
		if(cnt == spinNum) {
			int [] newOr = new int[order.length];
			newOr = Arrays.copyOf(order, order.length);
			q.offer(newOr);
			return;
		}
		for(int i=0; i<spinNum; ++i) {
			if(check[i]) continue;
			check[i] = true;
			order[cnt] = i;
			permutation(cnt+1, order);
			check[i] = false;
			
		}
	}
}
