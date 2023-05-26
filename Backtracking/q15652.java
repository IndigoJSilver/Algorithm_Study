/*
 * 15649번과 유사
 * 중복수 가능 + 비내림차순
 */
import java.util.*;
import java.io.*;

public class q15652 {
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(N, M, 1, 0);
        System.out.println(sb);
    }   
    
    public static void dfs(int N, int M, int at, int depth) {
        if(depth == M) {
            for(int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=at; i<=N; i++) {
            arr[depth] = i;
            dfs(N, M, i, depth+1);
        }
    }
}