/*
 * N*M 크기의 직사각형이 있음.
 * 각 꼭짓점에 쓰인 수가 모두 같은 가장 큰 정사각형 크기를 출력
 * 기준 꼭짓점하나를 잡고 나머지 꼭짓점을 찾아 최대 길이로 탐색
 */

import java.io.*;
import java.util.*;

public class q1051{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M;j++){
                arr[i][j] = str.charAt(j) - '0';
                /*
                 * String 타입으로 받은 문자열을 char 타입으로 받아왔다.
                 * 그러나 arr는 int형 배열이므로 int형으로 변환하려면 아스키코드(2진수)로 변환이 된다.
                 * 그래서 '0'을 빼서 10진수로 나타내 준다.
                 * ex. str.charAt(0) == 1 => 2진수 1
                 * str.charAt(0) - '0' = 49 - 48 = 1 => 10진수 1
                 */
            }
        }

        int len = Math.min(N, M); // 정사각형 최대 길이는 N, M 중 최소값으로 정한다
        while(len > 1){
            for(int i=0; i<=N-len; i++){ // 행(N-len) => 그 이상은 배열의 범위를 벗어남
                for(int j=0; j<=M-len;j++){ // 열(M-len) => 이하 동문
                    int num = arr[i][j]; // 기준 꼭짓점
                    if(num==arr[i][j+len-1] && num==arr[i+len-1][j] && num==arr[i+len-1][j+len-1]){
                        /*
                         * 나머지 세 꼭짓점을 비교하고 모든 꼭짓점이 같다면 
                         */
                        System.out.println(len*len); // 정사각형 크기 출력
                        return; // 가능한 가장 긴 길이부터 탐색을 시작 => 최대값 그러므로 종료
                    }
                }
            }
            len--; // 현재 len으로 정사각형이 나오지 않았다면 크기를 줄여 다시 for문 돌리기
        }
        System.out.println(len*len);
    }
}