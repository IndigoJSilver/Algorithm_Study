import java.io.*;
import java.util.*;

public class q1158_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            q.add(i);
        }
        System.out.print("<");
        for(int i=0; i<N; i++) {
            for(int j=0; j<K-1; j++) {
                q.add(q.remove());
            }
            System.out.print(q.remove());
            if(i==N-1) {
                System.out.print(">");
            } else {
                System.out.print(", ");
            }
        }
    }
}