/*
 * 오름차순 정렬
 * Arrays.sort()는 듀얼 피봇 퀵솔트
 * 평균 O(nlog(n)) 최악 O(n^2)
 */

import java.util.*;

public class q2750{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            System.out.println(arr[i]);
        }
        sc.close();
    }
}