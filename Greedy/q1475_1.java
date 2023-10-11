import java.io.*;

public class q1475_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        int[] cnt = new int[10];
        for(int i=0; i<n; i++) {
            int k = str.charAt(i)-'0';
            if(k==6 || k==9) {
                if(cnt[6]<cnt[9]) { // 약간의 greedy. 현재 상황에서 최선의 선택이 전체 상황에서의 최선의 해와 동일
                    cnt[6]++;
                } else {
                    cnt[9]++;
                }
            } else {
                cnt[k]++;
            }
        }
        int max = cnt[0];
        for(int i=1; i<10; i++) {
            if(max<cnt[i]) {
                max = cnt[i];
            }
        }
        System.out.println(max);
    }
}