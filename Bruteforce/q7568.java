import java.io.*;
import java.util.*;

public class q7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N];
        int[] y = new int[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++) {
            int sum = 1;
            for(int j=0; j<N; j++) {
                if(x[i]<x[j] && y[i]<y[j]) {
                    sum++;
                }
            }
            System.out.print(sum + " ");
        }
    }
}