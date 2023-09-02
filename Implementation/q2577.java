import java.io.*;

public class q2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];
        int ans = 1;
        for(int i=0; i<3; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            ans *= arr[i];
        }
        
        int[] arr2 = new int[10];
        while(ans != 0) {
            arr2[ans%10]++;
            ans /= 10;
        }
        for(int res : arr2) {
            System.out.println(res);
        }
    }
}