import java.io.*;
import java.util.*;

public class q1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] c = new int[10];
        double dc = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<N.length(); i++) {
            int num = Character.getNumericValue(N.charAt(i));
            q.add(num);
            if(num==6 || num==9) {
                dc++;
            }
            else {
                c[num]++;
            }
        }
        int max = 0;
        for(int i=0; i<10; i++) {
            max = Math.max(max, c[i]);
        }
        System.out.println(Math.max(max, (int)(Math.ceil(dc/2))));
    }
}
/**
 * 같은 수 나오면 +1
 * 9나 6이 2이상 나오면 /2+올림
 */