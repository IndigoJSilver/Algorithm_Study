/*
 * backtracking - dfs
 * 1. 집과 치킨집 위치 저장 -> ArrayList, class 구현
 * 2. m개의 뽑은 치킨집은 boolean으로 방문했는지 체크
 * 3. 값 받아올 이중배열 생성
 * 4. dfs 함수 생성
 * 
 */
import java.util.*;
import java.io.*;

public class q15686 {
    static int N, M;
    static List<Node> house, chicken;
    /*
     * static List<int[]> house = new ArrayList<>();
     * for(int[] h: house) 사용하는 방법도 있음
     * Math.abs(h[0]-c[0])
     */
    static int[][] map;
    static boolean[] visited;
    static int Min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    house.add(new Node(i, j));
                }
                else if(map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }
        
        visited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(Min);

   } 

    static void dfs(int start, int depth) {
        if(depth == M) {
            int res = 0; // 치킨 거리
            for(int i=0; i<house.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for(int j=0; j<chicken.size(); j++) {
                    if(visited[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        sum = Math.min(sum, distance);
                    }
                }
                res += sum;
            }
            Min = Math.min(Min, res);
            return;
        }
        
        for(int i=start; i<chicken.size(); i++) { // backtracking
            if(!visited[i]) {
                visited[i] = true;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
   }

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
   }
}