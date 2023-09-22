import java.io.*;
import java.util.*;

public class q10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String arr = st.nextToken();
            if(arr.equals("push_front")) {
                dq.addFirst(Integer.parseInt(st.nextToken()));
            } else if(arr.equals("push_back")) {
                dq.addLast(Integer.parseInt(st.nextToken()));
            } else if(arr.equals("pop_front")) {
                if(dq.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(dq.removeFirst()).append('\n');
                }
            } else if(arr.equals("pop_back")) {
                if(dq.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(dq.removeLast()).append('\n');
                }
            } else if(arr.equals("size")) {
                sb.append(dq.size()).append('\n');
            } else if(arr.equals("empty")) {
                if(dq.isEmpty()) {
                    sb.append("1").append('\n');
                } else {
                    sb.append("0").append('\n');
                }
            } else if(arr.equals("front")) {
                if(dq.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(dq.getFirst()).append('\n');
                }
            } else if(arr.equals("back")) {
                if(dq.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(dq.getLast()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}