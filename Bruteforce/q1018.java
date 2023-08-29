import java.io.*;
import java.util.*;

public class q1018 {
    public static boolean[][] arr;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                if(str.charAt(j) == 'W') {
                    arr[i][j] = true; // white
                } else {
                    arr[i][j] = false; // black
                }
            }
        }
        int row = N - 7;
        int col = M - 7;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y) {
        int endX = x + 8;
        int endY = y + 8;
        int count = 0;

        boolean first = arr[x][y]; // 첫번째 칸 색상
        for(int i=x; i<endX; i++) {
            for(int j=y; j<endY; j++) {
                if(arr[i][j] != first) {
                    count++;
                }
                first = !first; // 다음칸은 색 바뀜. 
            }
            first = !first;
        }

        count = Math.min(count, 64-count); // 첫번째 칸 기준의 개수 vs 첫번째 색과 반대 색 기준 개수
        min = Math.min(min, count); 
    }
}