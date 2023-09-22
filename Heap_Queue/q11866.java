import java.io.*;
import java.util.*;

public class q11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        while(q.size()>1) {
            for(int i=0; i<K-1; i++) {
               int val =  q.remove();
               q.add(val);
            }
            sb.append(q.remove()).append(", ");
        }
        sb.append(q.remove()).append('>');
        System.out.println(sb);
    }
}