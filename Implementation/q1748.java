import java.io.*;

public class q1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        int start = 1;
        int end;
        int length = 1;
        while(start<=N) { //1<=120
            end = start*10-1;//9 99 999
            if(end>N) {
                end = N; //120
            }
            sum += (end-start+1)*length;//9 180 63
            start *= 10;//10 100 1000
            length++;//2 3 4
        }
        sb.append(sum);//252
        System.out.println(sb);
    }
}
/**
 * 1~9 1
 * 10~99 2
 * 100~999 3
 * 1000~9999 4
 * ...
 */