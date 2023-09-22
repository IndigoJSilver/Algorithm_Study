import java.io.*;
import java.util.*;

public class q18111 {
    static int[][] arr;
    static int[] res = new int[2];
    static int time = Integer.MAX_VALUE;
    static int height;
    static int block;
    static int N, M, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        B = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        int max = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }
        bf(max);
        System.out.println(time + " " + height);
    }
    static void bf(int max) {

        for(int i=0; i<=max; i++) {
            res = dig(i);
            if(time>res[0]) {
                time = res[0];
                height = res[1];
            } else if(time==res[0] && height<res[1]) {
                time = res[0];
                height = res[1];
            }
        }
    }
    static int[] dig(int height) {

        int block = B;
        int time = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                int val = arr[i][j];
                if(val==height) {
                    continue;
                }
                if(val>height) {
                    time += (val-height)*2;
                    block += (val-height);
                } else {
                    time += (height-val);
                    block -= (height-val);
                }
            }
        }
        if(block<0) {
            res[0] = 999999999;
            return res;
        }
        res[0] = time;
        res[1] = height;
        return res;
    }
}