/*
 * 15469번과 유사하나 1~N 오름차순만 가능.
 * 현재 위치를 담는 변수를 추가하여 재귀 반복문
 */
import java.util.*;
import java.io.*;

public class q15650 {
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
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i=at; i<=N; i++) {
            arr[depth] = i;
            dfs(N, M, i+1, depth+1); // 오름차순이므로 처음으로 안돌아가도 됨. 단순 i+1
        }
    }
}