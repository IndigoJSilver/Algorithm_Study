import java.io.*;

public class q2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 분해합
        int res = 0;
        for(int i=0; i<N; i++) {
            int num = i;
            int sum = 0; // 자릿수 합
            while(num!=0) {
                sum += num%10;
                num /= 10;
            }
            if(sum+i == N) { // 자릿수 합 + 생성자
                res = i;
                break; // 생성자 여러개일 수도 있음
            }
        }

        System.out.println(res);
    }
}