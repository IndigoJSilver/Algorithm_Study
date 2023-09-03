import java.io.*;
import java.util.*;

public class q1920 {
    public static int[] an;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        an = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            an[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(an);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    public static int binarySearch(int key) {
        int lo = 0;
        int hi = an.length-1;
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            if(key<an[mid]) {
                hi = mid-1;
            }
            else if(key>an[mid]) {
                lo = mid+1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}