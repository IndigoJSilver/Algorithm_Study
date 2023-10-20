import java.io.*;
import java.util.*;

public class q2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[100][3];
        int res = 0;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=123; i<=987; i++) { // bruteforce
            int[] a = new int[] {i/100, (i/10)%10, i%10};
            if(a[0]==a[1] || a[1]==a[2] || a[2]==a[0] || a[1]==0 || a[2]==0) {
                continue; // 서로 다른 세 수, 1~9까지이므로 위 케이스는 제외
            }
            boolean flag = true;
            for(int j=0; j<N; j++) {
                int strike = 0;
                int ball = 0;
                int[] b = new int[] {arr[j][0]/100, (arr[j][0]/10)%10, arr[j][0]%10};
                boolean[] check = new boolean[] {false, false, false}; // 각 자리수 체크했는지 여부
                for(int k=0; k<3; k++) {
                    if(a[k]==b[k]) {
                        strike++;
                        check[k] = true;
                    } else {
                        for(int l=0; l<3; l++) {
                            if(!check[l] && a[k]==b[l]) {
                                ball++;
                                check[l] = true;
                            }
                        }
                    }
                }
                if(strike!=arr[j][1] || ball!=arr[j][2]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                res++;
            }
        }
        System.out.println(res);
    }
}