import java.io.*;
import java.util.*;

public class q1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // red
            arr[i][1] = Integer.parseInt(st.nextToken()); // green
            arr[i][2] = Integer.parseInt(st.nextToken()); // blue
        }

        for(int i=1; i<N; i++) {
            arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);
            arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]);
        } 
        System.out.println(Math.min(Math.min(arr[N-1][0], arr[N-1][1]), arr[N-1][2]));
    }
}