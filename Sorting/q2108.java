import java.io.*;
import java.util.Arrays;

public class q2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        int count = 0;
        int max = -1;
        int mode = arr[0];
        boolean check = false;
        for(int i=0; i<N-1; i++) {
            if(arr[i]==arr[i+1]) {
                count++;
            } else {
                count = 0;
            }
            if(max<count) {
                max = count;
                mode = arr[i];
                check = true;
            } else if(max==count && check==true) { // 최빈값 여러개일 경우 두번째
                mode = arr[i];
                check = false;
            }
        }
        System.out.println((int)Math.round((double)sum/N));
        System.out.println(arr[(N-1)/2]);
        System.out.println(mode);
        System.out.println(arr[N-1]-arr[0]);
    }
}