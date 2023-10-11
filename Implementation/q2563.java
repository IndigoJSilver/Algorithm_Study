import java.io.*;
import java.util.*;

public class q2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[100][100];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            for(int j=w; j<w+10; j++) {
                for(int k=h; k<h+10; k++) {
                    arr[j][k] = 1;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(arr[i][j]==1) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    } 
}