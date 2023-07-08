/*
 * 분할정복(divide-conquer)
 */
import java.io.*;
import java.util.*;

public class q2630 {
    public static int[][] arr;
    public static int white = 0;
    public static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static boolean color(int row, int col, int N) {
        int color = arr[row][col];
        for(int i=row; i<row+N; i++) {
            for(int j=col; j<col+N; j++) {
                if(arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void divide(int row, int col, int N) {
        if(color(row, col, N)) {
            if(arr[row][col] == 0) {
                white++;
            }
            else {
                blue++;
            }
            return;
        }
        int size = N/2;
        divide(row, col, size); // 2사분면
        divide(row, col+size, size); // 1사분면
        divide(row+size, col, size); // 3사분면
        divide(row+size, col+size, size); // 4사분면
    }
}