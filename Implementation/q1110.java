import java.io.*;

public class q1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = N;
        int res = 0;
        do {
            int a = ans/10;
            int b = ans%10;
            int sum = a+b;
            if(sum>=10) {
                sum %=10;
            }
            ans = b*10+sum;
            res++;
        } while(ans!=N);
        System.out.println(res);
    }
}