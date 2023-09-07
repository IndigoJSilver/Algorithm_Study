import java.io.*;
import java.util.*;

public class q2751_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> l = new ArrayList<>();
        for(int i=0; i<N; i++) {
            l.add(Integer.parseInt(br.readLine()));
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(l);
        for(int res : l) {
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }
}