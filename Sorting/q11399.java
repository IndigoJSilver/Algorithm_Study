/*
 * 누적 합
 */

import java.util.*;
import java.io.*;

public class q11399{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 읽은 문자열 '5'를 정수로 변환
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = 0, res = 0;
        for(int i=0; i<N; i++){ // 3 1 4 3 2 -> 1 2 3 3 4
            sum += arr[i]; // 1 3 6 9 13
            res += sum; // 1 4 10 19 32
        }
        System.out.println(res);
    }
}