/*
 * 공통된 부분 수열 중 가장 긴것 찾기(dp)
 * Top-down
 * ACAYKP
 * CAPCAK
 *      0 A C A Y K P
 * 0    0 0 0 0 0 0 0
 * C    0 0 1 1 1 1 1
 * A    0 1 1 2 2 2 2
 * P    0 1 1 2 2 2 3
 * C    0 1 2 2 2 2 3
 * A    0 1 2 3 3 3 3
 * K    0 1 2 3 3 4 4
 * 규칙 : i번째 원소와 j번째 원소가 같으면 (i-1, j-1번째 길이)+1
 * => Xi == Yj -> (Xi-1, Yj-1) +1
 * => Xi != Yj -> (Xi-1, Yj), (Xi, Yj-1) 비교하여 max
 */
import java.io.*;

public class q9251 {
    static Integer[][] dp; // dp 배열을 operator와 비교해야하므로 배열 타입을 Integer로 줬다.
    static char[] str1, str2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();
        dp = new Integer[str1.length][str2.length]; 

        System.out.println(lcs(str1.length-1, str2.length-1));
    }    

    static int lcs(int x, int y) {
        if(x==-1 || y==-1) { // 범위 밖
            return 0;
        }

        if(dp[x][y] == null) { // 탐색하지 않은 인덱스라면
            dp[x][y] = 0;
            if(str1[x]==str2[y]) {
                dp[x][y] = lcs(x-1, y-1) + 1;
            }
            else {
                dp[x][y] = Math.max(lcs(x-1, y), lcs(x, y-1));
            }
        }
        return dp[x][y];
    }
}