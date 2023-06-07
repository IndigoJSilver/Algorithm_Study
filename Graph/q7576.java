/*
 * q14502 바이러스 문제와 유사
 * bfs로 구현
 * 토마토 상태를 받아올 맵, 토마토를 넣을 큐 생성
 */
import java.util.*;
import java.io.*;

public class q7576 {
    static int[] dx = {-1, 1, 0, 0}; // 상하
    static int[] dy = {0, 0, -1, 1}; // 좌우
    static int N, M;
    static int[][] map;
    static int Max = Integer.MIN_VALUE;
    static LinkedList<tomato> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        map = new int[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    queue.add(new tomato(i, j));
                }
            }
        }        
        System.out.println(bfs());
    }    

    static int bfs() {
        while(!queue.isEmpty()) {
            tomato t = queue.remove();
            for(int i=0; i<4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M) { // 범위 내에 있을 때
                    if(map[nx][ny]==0) { // 토마토 안익음
                        queue.add(new tomato(nx, ny)); // 익은 토마토 추가
                        map[nx][ny] = map[t.x][t.y]+1; // 익은 날짜 얻기 위해 그 전 값+1
                    }
                }
            }

        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==0) { // 다 익지는 않았으면
                    return -1;
                }
                Max = Math.max(Max, map[i][j]);
            }
        }
        if(Max==1) { // 처음부터 다 익어있으면
            return 0;
        }
        else {
            return Max-1; // 마지막으로 익은 토마토를 추가하고 익은 날짜+1을 하므로 최종 결과는 -1 해줌
        }
    }

    static class tomato {
        int x, y;
        tomato(int x, int y) {
            this.x = x; // 세로
            this.y = y; // 가로
        }
    }
}