import java.io.*;
import java.util.*;

public class q1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            LinkedList<Integer> q = new LinkedList<>();
            LinkedList<Integer> index = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                q.offer(Integer.parseInt(st.nextToken()));
                index.offer(j);
            }
            int count = 1; // 출력 횟수
            while(!q.isEmpty()) {
                int max = Collections.max(q);
                int front = q.poll();
                int fi = index.poll();

                if(front == max) {
                    if(fi == M) {
                        System.out.println(count);
                        break;
                    }
                    count++;
                } else {
                    q.offer(front);
                    index.offer(fi);
                }
            }
        }    
    }
}