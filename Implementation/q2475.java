import java.io.*;
import java.util.*;

public class q2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];
        int ans = 0;
        for(int i=0; i<5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            ans += arr[i]*arr[i];
        }
        System.out.println(ans%10);
    }
}