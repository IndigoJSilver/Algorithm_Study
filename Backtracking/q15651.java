/*
 * 15649번에서 같은 수 포함
 */
import java.util.*;
import java.io.*;

public class q15651 {
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(N, M, 0);
        System.out.println(sb);
    }

    public static void dfs(int N, int M, int depth) {
        if(depth == M) {
            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i=1; i<=N; i++) {
            arr[depth] = i;
            dfs(N, M, depth+1);
        }
    }
}