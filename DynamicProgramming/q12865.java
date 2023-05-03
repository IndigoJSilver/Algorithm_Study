/*
 * Top-down
 * 배낭에 넣을 수 있는 물건들의 가치합의 최대값
 * 배낭 문제(knapsack) 알고리즘 사용하기
 * 그니까 Wi > W면 그대로 가져옴
 * 그게 아니면 'i번째 가치 + ({무게 - i무게} 일때 나올 수 있는 최대 가치 Vi)'
 * 그래서 Wi <= W일 경우에,
 * 기존 값과 가치 업데이트 한 값을 비교 ex) (3, 7) = (2, 7) vs (2, 7 - W3) + V3
 * 최대 무게 K = 7이면 무게를 하나씩 쪼갠다 -> 0 1 2 3 ... 7
 * (W, V) = (6, 13), (4, 8), (3, 6), (5, 12)
 * i|W 0 1 2 3 4 5 6 7
 * 1   0 0 0 0 0 0 13 13
 * 2   0 0 0 0 8 8 13 13
 * 3   0 0 0 6 8 8 13 14
 * 4   0 0 0 6 8 12 13 14
 */

import java.util.*;
import java.io.*;

public class q12865 {
    static Integer[][] arr;
    static int[] W;
    static int[] V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
        W = new int[N]; // 각 물건의 무게
        V = new int[N]; // 해당 물건의 가치
        arr = new Integer[N][K+1]; // 0부터 K까지니까 K+1

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(knapsack(N-1, K)); // 0부터 시작 0,1,2,3,4이니 -1해줌
    }
    private static int knapsack(int N, int K) {
        if(N < 0) { // 범위 밖
            return 0;
        }
        /*
         * int : 자료형(기본형) - 데이터의 타입에 따라 값이 저장될 공간의 크기와 저장 형식을 정의
         * 산술 연산 가능, null로 초기화 불가능
         * 
         * Integer : 래퍼 클래스(기본형을 객체로 다루기 위해 사용하는 클래스)
         * 언박싱 안하면 산술 연산 불가능, null값 처리 가능
         */
        // 탐색하지 않은 위치라면
        if(arr[N][K] == null) { // 배열이 int형이면 안됨. null과 비교 불가능. 
            if(W[N] > K) { // 현재 물건 N을 추가로 못 담는 경우
                arr[N][K] = knapsack(N-1, K); // 이전 값 그대로 가져옴
            }
            else { // 물건 담을 수 있는 경우
                arr[N][K] = Math.max(knapsack(N-1, K), knapsack(N-1, K-W[N])+V[N]);
            } // 이전 값 vs N번째 가치 + ({버틸 수 있는 무게(K) - N무게} 일때 나올 수 있는 최대 가치 V[N]
        }
        return arr[N][K];
    }
}