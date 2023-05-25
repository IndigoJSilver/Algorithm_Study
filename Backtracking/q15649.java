/*
 * backtracking
 * -> 어떤 노드의 유망성 판단. 유망하지 않다면, 부모 노드로 돌아가 다른 자식 노드 찾음
 * vs Brute-Force -> 모든 노드 탐색
 * 백트래킹은 DFS, BFS 등으로 구현 가능
 * 
 * 재귀 활용.
 * depth는 0으로 고정이 핵심 + visited T F활용하여 중복 피하기
 * arr의 인덱스를 depth로 두어 값 바꾸기
 * 
 */
import java.util.*;
import java.io.*;
public class q15649 {

    public static int[] arr; // tmp. 탐색 과정에서 값 담을 배열
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 4
        int M = Integer.parseInt(st.nextToken()); // 2

        arr = new int[M];
        visited = new boolean[N];   
        dfs(N, M, 0);
        System.out.println(sb);     
    }

    public static void dfs(int N, int M, int depth) {
        if(depth == M) {
            for(int i : arr) {
                sb.append(i).append(" "); // 1 2
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++) { // 0 1 2 3 
            if(!visited[i]) {
                visited[i] = true; // 0       1       2       3
                arr[depth] = i+1; // a[0]=1  a[1]=2  a[1]=3  a[1]=4
                dfs(N, M, depth+1); // dfs(4,2,1) dfs(4,2,2)
                visited[i] = false;
            }
        }
    }
}