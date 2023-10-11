import java.io.*;
import java.util.*;

public class q11723_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int x;
        int s = 0; // 0000 0000 0000 0000 0000 20bits로 1~20까지의 집합 상태 표현
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String q = st.nextToken();
            if(q.equals("add")) {
                x = Integer.parseInt(st.nextToken());
                s |= (1<<x); // or
                /**
                 * << left shift
                 * >> right shift
                 * 0000
                 * 0100 or
                 * 0100 => add 3
                 */
            } else if(q.equals("remove")) {
                x = Integer.parseInt(st.nextToken());
                s &= ~(1<<x); // and
                /**
                 * 0100 ~ => 1011
                 * 0100
                 * 1011 and
                 * 0000
                 */
            } else if(q.equals("check")) {
                x = Integer.parseInt(st.nextToken());
                if((s & (1<<x)) == (1<<x)) {
                    sb.append("1\n");
                    /**
                     * s:       0100
                     * 1<<x:    0100 and
                     *          0100
                     */
                } else {
                    sb.append("0\n");
                }
            } else if(q.equals("toggle")) { // 0->1 or 1->0
                x = Integer.parseInt(st.nextToken());
                s ^= (1<<x);
                /**
                 * s:       0000
                 * 1<<x:    0100 xor
                 *          0100
                 */
            } else if(q.equals("all")) {
                s = (1<<21)-1;
                /**
                 * 10000000000000000000 -> 01111111111111111111 s={1,2,3...,20}
                 */
            } else { // empty
                s = 0;
            }
        }
        System.out.println(sb);
    }
}