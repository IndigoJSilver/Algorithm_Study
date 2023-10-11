import java.io.*;
import java.util.*;

public class q11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num;
            if(str.equals("add")) {
                num = Integer.parseInt(st.nextToken());
                if(!q.contains(num)) {
                    q.add(num);
                }
            } else if(str.equals("remove")) {
                num = Integer.parseInt(st.nextToken());
                if(q.contains(num)) {
                    q.remove(num);
                }
            } else if(str.equals("check")) {
                num = Integer.parseInt(st.nextToken());
                if(q.contains(num)) {
                    sb.append("1").append('\n');
                } else {
                    sb.append("0").append('\n');
                }
            } else if(str.equals("toggle")) {
                num = Integer.parseInt(st.nextToken());
                if(q.contains(num)) {
                    q.remove(num);
                } else {
                    q.add(num);
                }
            } else if(str.equals("all")) {
                q.clear();
                for(int j=1; j<=20; j++) {
                    q.add(j);
                }
            } else if(str.equals("empty")) {
                q.clear();
            }
        }
        System.out.println(sb);
    }
}
