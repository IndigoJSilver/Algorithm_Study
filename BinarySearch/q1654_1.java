import java.io.*;
import java.util.*;

public class q1654_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        long max = 0;
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        max++; // 범위가 0~max+1 이므로 +1. max++안하면 min(0)+max(1)일 경우 mid=0 됨.
        long min = 0;
        long mid = 0;
        while(min < max) {
            mid = (min+max)/2;
            long count = 0;
            for(int i=0; i<K; i++) {
                count += (arr[i]/mid);
            }
            /**
             * upper bound - 최대 길이 찾기 위해.
             * mid길이로 잘랐을 때 개수가 N보다 작으면,
             * 자를 길이 줄이기 위해 max 줄임
             * 그 외에는 자를 길이 늘려야 하므로 최소 길이 늘림.
             */
            if(count<N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min-1);
    }
}