package hwjava10_서울_8반_천창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class SW_7510_D3_상원이의연속합 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
         
        int testCase = Integer.parseInt(bf.readLine());
         
        for(int tc=1; tc <= testCase; tc++) {
            int N =  Integer.parseInt(bf.readLine());
            int cnt = 1;
            for(int i=1; i<=(N/2)+1; i++) {
                int sum = i;
                for(int j= i+1; j<=(N/2)+1; j++) {
                    sum += j;
                    if(sum == N ) {
                        cnt++;
                        break;
                    } else if(sum > N)
                        break;
                }
            }
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        bf.close();
    }
 
}