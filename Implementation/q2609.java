import java.io.*;
import java.util.*;

public class q2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        System.out.println(gcd(n1, n2));
        System.out.println(lcm(n1, n2));
    }
    public static int gcd(int n1, int n2) {
        if(n2==0) {
            return n1;
        }
        return gcd(n2, n1%n2);
    }
    public static int lcm(int n1, int n2) {
        return n1*n2/gcd(n1, n2);
    }
}