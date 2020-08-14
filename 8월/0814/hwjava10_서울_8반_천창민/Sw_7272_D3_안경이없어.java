package hwjava10_서울_8반_천창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Sw_7272_D3_안경이없어 {
     
    static char[]oneHole = {'A','D','O','P','Q','R'};
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
         
        int testCase = Integer.parseInt(bf.readLine());
         
        for(int tc=1; tc<=testCase; tc++) {
            String [] tmp = bf.readLine().split(" ");
            if(check(tmp[0],tmp[1])) 
                sb.append("#").append(tc).append(" ").append("SAME").append("\n");
            else
                sb.append("#").append(tc).append(" ").append("DIFF").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        bf.close();
    }
 
    private static boolean check(String bf, String af) {
        if(bf.length() != af.length())
            return false;
        for(int i=0; i<bf.length(); i++) {
            switch(bf.charAt(i)) {
            case 'A':
            case 'D':
            case 'P':
            case 'O':
            case 'Q':
            case 'R':
                boolean isSame = false;
                for(int j=0; j<6; j++) {
                    if(af.charAt(i) == oneHole[j])  {
                        isSame = true;
                        break;
                    }
                }
                if(!isSame) 
                    return false;
                break;
                 
            case 'B':
                if(af.charAt(i) != 'B') 
                    return false;
                break;
            default:
                boolean isDiff = false;
                for(int j=0; j<6; j++) {
                    if(af.charAt(i) == oneHole[j])  {
                        isDiff = true;
                        break;
                    }
                }
                if(isDiff)
                    return false;
                else if(af.charAt(i) == 'B')
                    return false;
            }
        }
        return true;
    }
}