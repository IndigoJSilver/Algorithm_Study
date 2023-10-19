import java.io.*;
import java.util.*;

public class q17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int n = str.length();
        boolean flag = false;
        for(int i=0; i<n; i++) {//<open>tag<close> //<tag>word word
            if(str.charAt(i)=='<') {
                flag = true;
                if(!s.empty()) {
                    while(!s.empty()) {
                        sb.append(s.pop());//gat
                    }
                }
                sb.append('<');//< <
            } else if(str.charAt(i)=='>') {
                sb.append('>');//> >
                flag = false;
            } else if(flag) {
                sb.append(str.charAt(i));//open close
            } else {
                if(str.charAt(i)!=' ') {
                    s.push(str.charAt(i));//tag
                } else {
                    while(!s.empty()) {
                        sb.append(s.pop());//
                    }
                    sb.append(' ');
                }
            }
        }
        while(!s.empty()) {
            sb.append(s.pop());
        }
        System.out.println(sb);
    }
}