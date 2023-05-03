/*
 * 재귀(Top-down)
 * dinamic programming
 * 동적 계획법
 * 2진수이므로 n자리에 올 수 있는 수는 0 또는 1
 * n자리가 0이라면 n-1에 0 또는 1
 * n자리가 1이라면 n-1에 0이 와야한다, 그리고 n-2에 0 또는 1
 * 따라서 점화식: dp[n] = dp[n-1] + dp[n-2]
 * dp[n]은 n자리 이친수
 */
import java.io.*;

public class q2193 {
    private static long arr[]; // N을 계산하면서 int형 범위를 넘어갈 수 있음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        arr = new long[N+1]; // N<=90이므로 N+1을 해줌
        System.out.println(binary(N));
    }

    private static long binary(int N) {
        if(N == 0 || N == 1) {
            return N;
        }
        if(arr[N] > 0) {
            return arr[N];
        }
        arr[N] = binary(N-1) + binary(N-2);
        return arr[N];
    }
}