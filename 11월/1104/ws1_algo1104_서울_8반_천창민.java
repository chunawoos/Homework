import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ws1_algo1104_서울_8반_천창민 {
	private static char[][] map;
	private static boolean isComplete;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		map = new char[9][9];
		for (int i = 0; i < 9; i++) {
			String [] str = bf.readLine().split("");
			for (int j = 0; j < 9; j++) {
				map[i][j] = str[j].charAt(0);
			}
		}
		isComplete = false;
		fillMap(0,0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static void fillMap(int row, int col) {
		if(isComplete) {
			return;
		}
		if(row == 9) {
			if(validateAll()) {
				isComplete = true;
			}
			return;
		}
		int nc = (col+1)%9;
		int nr = (nc == 0) ? row+1 : row;
		if(map[row][col] != '0') {
			fillMap(nr,nc);
		}
		else {
			for (int i = 1; i <= 9; i++) {
				if(validateLine(row,col,i)) { 
					map[row][col] = (char)('0'+i);
					fillMap(nr,nc);
					if(isComplete) return;
					map[row][col] = '0';
				}
			}
		}
	}


	private static boolean validateLine(int row, int col, int num) {
		
		for (int i = 0; i < 9; i++) {
			if(map[row][i] == '0'+num) return false;
			if(map[i][col] == '0'+num) return false;
		}
		int sr = 0, sc = 0;
		if(row<3) sr = 0;
		else if(row<6) sr = 3;
		else sr = 6;
		if(col<3) sc = 0;
		else if(col<6) sc = 3;
		else sc = 6;
		for (int i = sr; i < sr+3; i++) {
			for (int j = sc; j < sc+3; j++) {
				if(map[i][j] == '0'+num) return false;
			}
		}
		return true;
	}

	private static boolean validateAll() {
		for (int i = 0; i < 9; i++) {
			boolean [] rowCheck = new boolean[10];
			boolean [] colCheck = new boolean[10];
			rowCheck[0] = true;
			colCheck[0] = true;
			for (int j = 0; j < 9; j++) {
				int rowNum = map[i][j] -'0';
				int colNum = map[j][i] -'0';
				if(!rowCheck[rowNum]) rowCheck[rowNum] = true;
				else {
					return false;
				}
				if(!colCheck[colNum]) colCheck[colNum] = true;
				else {
					return false;
				}
			}
		}
		for (int i = 0; i < 9; i+=3) {
			for (int j = 0; j < 9; j+=3) {
				boolean [] boxCheck = new boolean[10];
				boxCheck[0] = true;
				for (int k = i; k < i+3; k++) {
					for (int l = j; l < j+3; l++) {
						int boxNum = map[k][l] -'0';
						if(!boxCheck[boxNum]) boxCheck[boxNum] = true;
						else {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
}
