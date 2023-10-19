import java.io.*;
import java.util.*;

public class q1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] state = new int[101];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            state[i] = Integer.parseInt(st.nextToken());
        }
        int student = Integer.parseInt(br.readLine());
        while(student-- !=0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int sn = Integer.parseInt(st.nextToken());
            if(gender==1) { // 남자면 번호 배수 바꿈
                for(int i=sn; i<=N; i+=sn) {
                    state[i] = (state[i]==0)?1:0;
                }
            } else { // 여자면 번호 양옆 최대 구간 바꿈
                state[sn] = (state[sn]==0)?1:0;
                for(int i=sn-1, j=sn+1; ;i--, j++) {
                    if(i<1 || j>N) {
                        break;
                    }
                    if(state[i]==state[j]) {
                        state[i] = state[j] = ((state[i]==0)?1:0);
                    } else {
                        break;
                    }
                }
            }
        }
        for(int i=1; i<=N; i++) {
            sb.append(state[i]+" ");
            if(i%20==0) { // 20개씩 출력
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}