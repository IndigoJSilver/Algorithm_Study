/*
 * Bottom-up
 * 최대보수의 합 구하기
 * 지금까지 계산한 값 vs 지금 해야 할 계산 중 큰 값을 dp에 넣는다
 * @@ dp는 끝에서부터 시작하는 게 좋다
 * dp[i]는 날짜 i부터 상담했을 때 벌 수 있는 돈의 최대값
 * 현재 날짜i에서 소요시간T[i] + 금액P[i]하여 dp에 저장, 중복될 때 최대값도 저장
 * 점화식 : dp[t[i]+i] = Math.max(dp[t[i]+i], p[i]+dp[i])
 *        dp[T[i]+i] = Math.max(i날에 해당하는 보수 계산, i날에 버는 보수P[i]+ i이전까지 최대 수입dp[i])
 *  Ti Pi i     0 1 2 3  4  5  6  7 
 * (3,10) 1     0 0 0 0 10 10 10 10 // 실제 수익이 생기는건 Ti + i
 * (5,20) 2     0 0 0 0 10 10 10 20
 * (1,10) 3     0 0 0 0 10 10 10 20 
 * (1,20) 4     0 0 0 0 10 30 30 30 // i=4, i가 3일때 일한거를 더하여 보수 계산
 * (2,15) 5     0 0 0 0 10 30 30 45
 * (4,40) 6     0 0 0 0 10 30 30 45
 * (2,200) 7    0 0 0 0 10 30 30 45
 */

import java.util.*;
import java.io.*;

public class q14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[N+1];
        for(int i=0; i<N; i++) {
            if(i+T[i] <= N) { // 현재날짜+소요날짜가 퇴사일을 넘지 않는다면
                arr[i+T[i]] = Math.max(arr[i+T[i]], arr[i]+P[i]);
            }
            arr[i+1] = Math.max(arr[i+1], arr[i]); // 현재 dp가 0일 수 있기 때문에 이전 최대값을 넣어줌
            // 즉-> 해당 날짜에 일할 수 없다면, 이전까지 일한 최대값을 넣어줘야 함. 그래야 dp에 0 안나옴.
        }
        System.out.println(arr[N]);
    }
}