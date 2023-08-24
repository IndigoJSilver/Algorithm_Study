import java.io.*;
import java.util.*;

public class q10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int[] arr2 = new int[T];
        int[] arr3 = new int[T];
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
            arr3[i] = arr[i] + arr2[i];
        }
        for(int res : arr3) {
            System.out.println(res);
        }
    }
}