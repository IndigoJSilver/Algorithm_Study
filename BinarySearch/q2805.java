/*
 * 이분탐색
 * 나무 개수 N, 가져갈 나무 길이 M
 * 자르는 기준점을 mid = (min + max) / 2 로 둔다
 */

import java.util.*;
import java.io.*;

public class q2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];
        int min = 0, max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());

            if(max < tree[i]){
                max = tree[i];
            }
        }

        while(min < max) {
            int mid = (min + max) / 2;
            long sum = 0; // 잘려진 나무 길이의 합은 int범위를 초과할 수 있으므로 long으로 선언

            for(int i=0; i<N; i++) {
                if(tree[i] > mid) { // 나무 길이가 자르는 위치(mid)보다 크면 잘린 길이가 생김
                    sum += tree[i] - mid;
                }
            }
            if(sum < M) { // 잘린 길이의 합(sum)이 M보다 작으면 자르는 위치(mid)가 높다는 의미. -> 높이 낮춰야 함. -> max를 낮춤.
                max = mid;
            }
            else { // sum이 M보다 크면 mid가 낮다는 의미. -> 높이 올려. -> 근데 같을 경우 최대한 적게 잘라야 하므로 min 높임.
                min = mid + 1; // sum과 M이 같아졌을 때, +1을 하여 이분탐색 종료.
            }
        }
        System.out.println(min - 1); // upperbound 방식 사용했으므로 -1하여 답 출력.
    }
}
