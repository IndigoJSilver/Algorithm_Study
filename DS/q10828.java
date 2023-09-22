import java.io.*;
import java.util.*;

public class q10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String arr = st.nextToken();
            if(arr.equals("push")) {
                s.push(Integer.parseInt(st.nextToken()));
            } else if(arr.equals("top")) {
                if(!s.empty()) {
                    sb.append(s.peek()).append('\n');
                } else {
                    sb.append("-1").append('\n');
                }
            } else if(arr.equals("empty")) {
                if(s.empty()) {
                    sb.append("1").append('\n');
                } else {
                    sb.append("0").append('\n');
                }
            } else if(arr.equals("size")) {
                sb.append(s.size()).append('\n');

            } else if(arr.equals("pop")) {
                if(!s.empty()) {
                    sb.append(s.pop()).append('\n');
                } else {
                    sb.append("-1").append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}