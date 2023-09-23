import java.io.*;

public class q1003 {
    static int sum0;
    static int sum1;
    static int next1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            fibo(n);
            sb.append(sum0).append(" ").append(sum1).append('\n');
        }
        System.out.println(sb);
    }
    static void fibo(int n) {
        sum0 = 1;
        sum1 = 0;
        next1 = 1;
        for(int i=0; i<n; i++) {
            sum0 = sum1;
            sum1 = next1;
            next1 = sum0+sum1;
        }
    }
}