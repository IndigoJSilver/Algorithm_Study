import java.io.*;
import java.util.*;

public class q2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int[] arr = new int[6];
        for(int i=0; i<6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        for(int i=0; i<6; i++) {
            if(arr[i]+arr[(i+1)%6]==sum/2) {
                sb.append((arr[i]*arr[(i+1)%6]-arr[(i+3)%6]*arr[(i+4)%6])*K);
            }
        }
        System.out.println(sb);
    }
}