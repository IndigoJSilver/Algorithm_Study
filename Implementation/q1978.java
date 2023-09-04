import java.io.*;
import java.util.*;

public class q1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        while(st.hasMoreTokens()) {
            boolean isPrime = true; // 2일 경우 대비
            int num = Integer.parseInt(st.nextToken());
            for(int j=2; j<num; j++) {
                if(num%j==0) {
                    isPrime = false;
                }
            }
            if(isPrime && num!=1) {
                count++;
            }
        }
        System.out.println(count);
    }
}