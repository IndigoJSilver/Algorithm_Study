/*
 * 재귀방식(Top-down)
 * N <= M에서 최대한 많은 다리를 놓아야 한다.
 * N개의 다리가 필요, M개에서 다리 놓을 포인트를 정해야 함.
 * 즉, M개 중 N개를 선택 -> mCn(조합공식)
 * 
 * 조합공식 성질 이용한다
 * 1번 성질
 * n+1Cr+1 = nCr + nCr+1
 * 2번 성질
 * nC0 = nCn = 1
 */

import java.util.*;
import java.io.*;

public class q1010 {
    static int[][] arr = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());    

            sb.append(combi(M, N)).append('\n');
        }
        System.out.println(sb);
    }

    private static int combi(int M, int N) {
        if(arr[M][N]>0) { // 이미 풀린 경우
            return arr[M][N]; // 바로 반환
        }

        if(M==N || N==0) { // 2번 성질
            return arr[M][N] = 1;
        }

        return arr[M][N] = combi(M-1, N-1) + combi(M-1, N); // 1번 성질
    }
}