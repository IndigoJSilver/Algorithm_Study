import java.io.*;
import java.util.*;

public class q4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String str = br.readLine();
            if(str.equals(".")) {
                break;
            }
            sb.append(arr(str)).append('\n');
        }
        System.out.println(sb);   
    }
    public static String arr(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c=='(' || c=='[') {
                s.push(c);
            } else if(c==')') {
                if(s.empty() || s.peek()!='(') {
                    return "no";
                } else {
                    s.pop();
                }
            } else if(c==']') {
                if(s.empty() || s.peek()!='[') {
                    return "no";
                } else {
                    s.pop();
                }
            }
        }
        if(s.empty()) {
            return "yes";
        } else {
            return "no";
        }
    }
    
}