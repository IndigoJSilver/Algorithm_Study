import java.io.*;
import java.util.*;

public class q18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> d = new LinkedList<>();
        for(int i=0; i<N; i++) {
            d.addLast(Integer.parseInt(br.readLine()));
        }
        List<Integer> l = new ArrayList<>(d);
        Collections.sort(l);
        Deque<Integer> dq = new LinkedList<>(l);
        int avg = (int)Math.round(N*0.15);
        for(int i=0; i<avg; i++) {
            dq.removeFirst();
        }
        for(int i=0; i<avg; i++) {
            dq.removeLast();
        }
        int sum = 0;
        int size = dq.size();
        for(int i=0; i<size; i++) {
            sum += dq.removeFirst();
        }
        System.out.println(Math.round((double)sum/size));
    }
}