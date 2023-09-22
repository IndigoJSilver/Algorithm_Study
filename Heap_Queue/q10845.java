import java.io.*;
import java.util.*;

public class q10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String arr = st.nextToken();
            if(arr.equals("push")) {
                last = Integer.parseInt(st.nextToken());
                q.add(last);
            } else if(arr.equals("pop")) {
                if(q.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(q.remove()).append('\n');
                }
            } else if(arr.equals("size")) {
                sb.append(q.size()).append('\n');
            } else if(arr.equals("empty")) {
                if(q.isEmpty()) {
                    sb.append("1").append('\n');
                } else {
                    sb.append("0").append('\n');
                }
            } else if(arr.equals("front")) {
                if(q.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(q.element()).append('\n');
                }
            } else if(arr.equals("back")) {
                if(q.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(last).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}