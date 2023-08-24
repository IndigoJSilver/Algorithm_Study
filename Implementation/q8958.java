import java.io.*;
import java.util.*;

public class q8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for(int i=0; i<N; i++) {
            str[i] = br.readLine();
        }

        for(int i=0; i<N; i++) {
            int sum = 0;
            int cnt = 0;
            for(int j=0; j<str[i].length(); j++) {
                if(str[i].charAt(j) == 'O') {
                    cnt++;
                } else {
                    cnt = 0;
                }
                sum += cnt;
            }
            System.out.println(sum);
        }
    }
}