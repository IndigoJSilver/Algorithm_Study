/*
 * bottom-up
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
 * 
 * bottom-up 방식은 배열에 공집합 표현도 해주어야 하니 배열 크기 +1 
 */
import java.io.*;

public class q9251_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int[][] dp = new int[str1.length+1][str2.length+1];

        for(int i=1; i<=str1.length; i++) {
            for(int j=1; j<=str2.length; j++) {
                if(str1[i-1] == str2[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[str1.length][str2.length]);
    }    
}