import java.io.*;
import java.util.*;

public class q1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> ans = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            q.add(i);
        }
        while(!q.isEmpty()) {
            for(int i=0; i<K-1; i++) {
                q.add(q.remove());
            }
            ans.add(q.remove());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!ans.isEmpty()) {
            sb.append(ans.remove());
            if(!ans.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
/**
 * 1 2 3 4 5 6 7
 * 3, 4 5 6 7 1 2
 * 3 6, 7 1 2 4 5
 * 3 6 2, 4 5 7 1
 * 3 6 2 7, 1 4 5
 * 3 6 2 7 5, 1 4
 * 3 6 2 7 5 1, 4
 * 3 6 2 7 5 1 4,
 */