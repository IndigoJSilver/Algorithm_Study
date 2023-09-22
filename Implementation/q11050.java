import java.io.*;
import java.util.*;

public class q11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int res = 1;
        for(int i=N; i>K; i--) {
            res *= i;
        }
        for(int i=N-K; i>0; i--) {
            res /= i;
        }
        System.out.println(res);
    }
}