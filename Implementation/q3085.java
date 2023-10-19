import java.io.*;

public class q3085 {
    static int N;
    static char[][] map = new char[55][55];
    static int[] dx = {0, 0, -1, 1}; // 행 기준으로 좌우상하
    static int[] dy = {-1, 1, 0, 0}; // 열
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<4; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(nx<0 || nx>=N || ny<0 || ny>=N) { // 범위 벗어난 것
                        continue;
                    }
                    swap(i, j, nx, ny);
                    solve();
                    swap(i, j, nx, ny);
                }
            }
        }
        System.out.println(ans);
    }

    static void swap(int a, int b, int c, int d) { // map좌표, 현재좌표
        char t = map[a][b];
        map[a][b] = map[c][d];
        map[c][d] = t;
    }
    static void solve() {
        for(int i=0; i<N; i++) { //가로
            int k = 1; // 연속한 사탕 수
            for(int j=1; j<N; j++) {
                if(map[i][j]==map[i][j-1]) { // 사탕 연속 시
                    k++;
                } else { // 다른 색 사탕 만날 시
                    ans = Math.max(ans, k);
                    k = 1;
                }
            }
            ans = Math.max(ans, k);
        }
        for(int i=0; i<N; i++) { //세로
            int k = 1;
            for(int j=1; j<N; j++) {
                if(map[j][i]==map[j-1][i]) {
                    k++;
                } else {
                    ans = Math.max(ans, k);
                    k = 1;
                }
            }
            ans = Math.max(ans, k);
        }
    }
}