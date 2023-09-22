import java.io.*;
import java.util.*;

public class q18111_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int max = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }
        int ansT = Integer.MAX_VALUE;
        int ansH = -1;
        for(int h=max; h>=0; h--) {
            int time = 0;
            int block = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    int hDiff = h-arr[i][j];
                    if(hDiff<0) {
                        time += -2*hDiff;
                        block += hDiff;
                    } else if(hDiff>0) {
                        time += hDiff;
                        block += hDiff;
                    }
                }
            }
            if(block<=B) {
                if(time<ansT) {
                    ansT = time;
                    ansH = h;
                }
            }
        }
        System.out.println(ansT+" "+ansH);
    }
}