import java.io.*;
import java.util.*;

public class q10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] sum = new int[T];
        int X, Y;
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            
            if(N % H == 0) {
                Y = H * 100;
                X = N / H;
            } else {
                Y = (N % H) * 100;
                X = N / H + 1;
            }
            sum[i] = X+Y; 
        }

        for(int res : sum) {
            System.out.println(res);
        }
    }
}