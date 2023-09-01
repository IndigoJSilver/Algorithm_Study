import java.io.*;
import java.util.*;

public class q1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] arr = new double[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        double M = arr[N-1];
        // System.out.println(M);
        // for(double re : arr) {
        //     System.out.println(re);
        // }
        double res = 0;
        for(int i=0; i<N; i++) {
            res += (arr[i]/M*100);
        }
        System.out.println(res/N);
    }
}