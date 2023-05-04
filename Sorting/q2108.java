/*
 * 
 */

import java.util.*;
import java.io.*;

public class q2108{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        // 산술평균
        int sum = 0;
        for(int i=0; i<N; i++){
            sum += arr[i];
        }
        System.out.println(sum/N);

        // 중앙값
        Arrays.sort(arr);
        System.out.println(arr[N/2]);

        // 최빈값 -> 계수정렬 써봐
        int count = 0, max = 0;
        boolean check = false;
        int[] plus = new int[4002]; // 0~4000
        int[] minus = new int[4001]; // -1~-4000
        for(int i=0; i<N; i++){
            if(arr[i]<0){
                minus[Math.abs(arr[i])]++;
            }
        }

        // 범위
        System.out.println(arr[N-1] - arr[0]);
    }
}