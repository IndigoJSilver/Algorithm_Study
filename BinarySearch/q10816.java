/*
 * 상한 -> 찾고자 하는 특정 값을 "초과"하는 '첫 위치' 반환
 * 하한 -> 찾고자 하는 특정 값 "이상"인 '첫 위치' 반환
 */

import java.util.*;
import java.io.*;

public class q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 이분탐색을 위해 정렬

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' '); // upper와 lower 차이 값
        }
        System.out.println(sb);
    }

    /*
     * 중복 원소에 대한 길이는 upper(상한) - lower(하한)으로 구할 수 았다
     * ex) arr: 1 2 2 2 3 4, key = 2 일때
     * key <= arr[1] lowerbound = 1
     * key < arr[4] upperbound = 4 이다.
     * 
     * 중앙 위치 값 기준으로 key값과 비교를 하여 max를 내릴지, min을 올릴지 결정해야함
     * 중앙 위치 값이 연속으로 같은 값을 갖고 있을 때, key값과 중앙 위치 값이 같다,
     * 이때 하한값을 찾는다면 max를 내려야함 -> max = mid
     * 상한값을 찾는다면 min을 올려야함 -> min = mid + 1
     * 
     */
    private static int lowerBound(int[] arr, int key) {
        int min = 0;
        int max = arr.length;

        while(min < max) {
            int mid = (min + max) / 2;
            if(key <= arr[mid]){
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        return min;
    }

    private static int upperBound(int[] arr, int key) {
        int min = 0;
        int max = arr.length;

        while(min < max) {
            int mid = (min + max) / 2;
            if(key < arr[mid]) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        return min;
    }
}