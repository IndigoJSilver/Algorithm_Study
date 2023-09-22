import java.io.*;
import java.util.*;

public class q10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<K; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num==0) {
                s.pop();
            } else {
                s.push(num);
            }
        }
        for(int res : s) {
            sum += res;
        }
        System.out.println(sum);
    }
}