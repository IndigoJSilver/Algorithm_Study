import java.io.*;
import java.util.*;

public class q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            System.out.println(arr(br.readLine()));
        }
    }
    public static String arr(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c=='(') {
                s.push(c);
            } else if(s.empty()) {
                return "NO";
            } else {
                s.pop();
            }
        }
        if(s.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}