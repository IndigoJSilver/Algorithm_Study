import java.io.*;
import java.util.*;

public class q1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[1000001];
        for(int i=2; i<arr.length; i++) {
            for(int j=i; j<arr.length; j+=i) {
                arr[j]++;
            }
        }
        for(int i=M; i<=N; i++) {
            if(arr[i]==1) {
                System.out.println(i);
            }
        }
    }
}