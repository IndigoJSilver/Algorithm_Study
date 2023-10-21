import java.io.*;
import java.util.*;

public class q2578 {
    static int[][] arr = new int[5][5];
    static boolean[][] chk = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = 0;
        boolean f = true;
        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                res++;
                int n = Integer.parseInt(st.nextToken());
                check(n);
                if(bingo()) {
                    sb.append(res);
                    f = false;
                    break;
                }
            }
            if(!f) {
                break;
            }
        }
        System.out.println(sb);
    }
    static boolean bingo() {
        int sum = 0; // 빙고 개수
        boolean f;
        // 가로
        for(int i=0; i<5; i++) {
            f = true;
            for(int j=0; j<5; j++) {
                if(!chk[i][j]) {
                    f = false;
                }
            }
            if(f) {
                sum++;
            }
        }
        // 세로
        for(int i=0; i<5; i++) {
            f = true;
            for(int j=0; j<5; j++) {
                if(!chk[j][i]) {
                    f = false;
                }
            }
            if(f) {
                sum++;
            }
        }
        // 대각선 좌상향 -> 우하향
        f = true;
        for(int i=0; i<5; i++) {
            if(!chk[i][i]) {
                f = false;
            }
        }
        if(f) {
            sum++;
        }
        // 대각선 우상향 -> 좌하향
        f = true;
        for(int i=0,j=4; i<5; i++,j--) {
            if(!chk[i][j]) {
                f = false;
            }
        }
        if(f) {
            sum++;
        }
        return sum>=3;
    }
    static void check(int n) {
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(arr[i][j]==n) {
                    chk[i][j] = true;
                }
            }
        }
    }
}