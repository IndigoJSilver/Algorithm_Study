import java.io.*;
import java.util.*;

public class q1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        boolean[] check = new boolean[N];
        for(int i=1; i<=N; i++) {//1 2 3 4
            int k = Integer.parseInt(st.nextToken());//2 1 1 0
            int cnt = 0; // 나보다 왼쪽에 있는 빈자리 개수
            for(int j=0; j<N; j++) {//0123
                if(check[j]) {
                    continue;
                }
                if(cnt==k) {
                    check[j] = true;//2 1 3 0
                    arr[j] = i;//2=1 1=2 3=3 0=4
                    break;
                }
                cnt++;//1
            }
        }
        for(int i=0; i<N; i++) {
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);
    }
}
/**
 * 1 2 3 4
 * 3 
 * 4 3
 * 4 2 1 3
 * 바로 전의 왼쪽과 비교.
 */