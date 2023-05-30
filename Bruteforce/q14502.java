/*
 * 벽 3개 세우기
 * 바이러스는 상하좌우로 퍼짐
 * 최대 안전 지역 찾기 -> 0 개수 찾기
 */
import java.util.*;
import java.io.*;

public class q14502 {
    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static int Max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(Max);
    }

    static void dfs(int wall) { // 벽 3개 만들기
        if(wall == 3) {
            bfs();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0) { // 비어있으면
                    arr[i][j] = 1; // 벽 세우기
                    dfs(wall+1);
                    arr[i][j] = 0; // 다음 탐색을 위해 벽 허물기
                }
            }
        }
    }

    static void bfs() { // 바이러스 퍼뜨리기
        int[][] copyArr = new int[N][M]; // 원본 배열을 바꾸면 안되므로 복사된 배열을 사용해야함.
        LinkedList<virus> queue = new LinkedList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                copyArr[i][j] = arr[i][j]; // 복사하기
                if(copyArr[i][j] == 2) { // 바이러스 있으면
                    queue.add(new virus(i, j)); // 바이러스 퍼뜨리기
                } 
            }
        }

        while(!queue.isEmpty()) { // 큐가 비어있지 않으면
            virus v = queue.remove(); // 
            for(int i=0; i<4; i++) { // 상하좌우
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M) { // 범위 내에 있으면
                    if(copyArr[nx][ny]== 0) { // 비어있으면
                        copyArr[nx][ny] = 2; // 바이러스 퍼뜨리고
                        queue.add(new virus(nx, ny)); // 큐에 넣기
                    }
                }
            }
        }
        safe(copyArr);
    }

    static void safe(int[][] copyArr) {
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(copyArr[i][j] == 0) {
                    count++;
                }
            }
        }
        Max = Math.max(count, Max);
    }

    static class virus {
        int x, y;
        virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}