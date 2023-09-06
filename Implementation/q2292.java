import java.io.*;

public class q2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 1; // 최소 방문 횟수
        int range = 2; // 최소 범위
        if(N==1) {
            System.out.println("1");
        }
        else {
            while(range<=N) {
                range = range+(6*count);
                count++;
            }
            System.out.println(count);
        }
    }
}