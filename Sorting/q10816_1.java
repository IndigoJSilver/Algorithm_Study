import java.io.*;
import java.util.*;

public class q10816_1{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // int M = Integer.parseInt(br.readLine());
        // st = new StringTokenizer(br.readLine());
        // int[] arr2 = new int[M];
        // for(int i=0; i<M; i++) {
        //     arr2[i] = Integer.parseInt(st.nextToken());
        // }
        // int[] res = new int[M];
        // StringBuilder sb = new StringBuilder();
        // for(int i=0; i<M; i++) {
        //     for(int j=0; j<N; j++) {
        //         if(arr2[i]==arr[j]) {
        //             res[i]++;
        //         }
        //     }
        //     sb.append(res[i]).append(" ");
        // }
        // System.out.println(sb);
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr, key)-lowerBound(arr, key)).append('\n');
        }
        System.out.println(sb);
    }
    private static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        while(lo<hi) {
            int mid = (lo+hi)/2;
            if(key<=arr[mid]) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    } 
    private static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        while(lo<hi) {
            int mid = (lo+hi)/2;
            if(key<arr[mid]) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }
}