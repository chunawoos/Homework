package hwjava10_서울_8반_천창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Sw_7532_D3_세영이의SEM력연도 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
         
        int testCase = Integer.parseInt(bf.readLine());
         
        for(int tc=1; tc <= testCase; tc++) {
            String [] tmp = bf.readLine().split(" ");
            int S = Integer.parseInt(tmp[0]); 
            int E = Integer.parseInt(tmp[1]); 
            int M = Integer.parseInt(tmp[2]);
            boolean isFin = false;
            int cnt = 0;
            int result = 0;
            while(!isFin) {
                int x = 365*cnt+S;
                if((x-E)%24 == 0 && (x-M)%29 == 0) {
                    result = x;
                    break;
                }
                cnt ++;
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        bf.close();
    }
}