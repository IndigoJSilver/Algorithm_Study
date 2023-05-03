/*
 * 반복문(Bottom-up)
 */

import java.util.*;
import java.io.*;

public class q1010_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[30][30];

        for(int i=0; i<30; i++){ // 2번 성질
            arr[i][i] = 1;
            arr[i][0] = 1;
        }

        for(int i=2; i<30; i++) { // 1번 성질
            for(int j=1; j<30; j++) {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(arr[M][N]).append('\n');
        }
        System.out.println(sb);
    }
}