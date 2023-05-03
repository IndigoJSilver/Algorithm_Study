/*
 * upperbound 사용
 * upperbound - 1 해서 구한다
 */

import java.util.*;
import java.io.*;

public class q1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];

        long min = 0, max = 0; // int로 하면 입력범위가 int형의 최대범위까지 주어지기때문에 에러.
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]){
                max = arr[i];
            }
        }

        max++; // min < max 수행위해-> 이분탐색 수행. 입력받는 랜선 최대길이++로 잡는다.
        while(min < max) {
            long mid = (min + max) / 2;
            long sum = 0;

            for(int i=0; i<K; i++) {
                    sum += arr[i] / mid; // mid로 나눠 랜선 몇 개 만들어지는지 확인
            }
            if(sum < N) { // 랜선 개수가 만들고자 하는 개수보다 작으면 나눌 길이 줄이기 위해 max 줄인다
                max = mid; 
            }
            else { // 랜선 개수가 만들고자 하는 개수보다 크거나 같으면 나눌 길이 늘리기 위해 min 늘린다
                min = mid + 1;
            }
        }
        System.out.println(min-1);
        // bw.write(Long.toString(min-1)); // 이렇게 하니까 200% 나옴
        // bw.write(Long.toString(min-1)+'\n'); // 개행믄자 붙이면 사라짐. 이유가 뭐지..? 모르겠음
        // bw.flush();
        // bw.close();
    }
}