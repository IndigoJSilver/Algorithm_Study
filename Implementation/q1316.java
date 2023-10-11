import java.io.*;
import java.util.*;

public class q1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int group = 0;
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            if(is_group(str)) {
                group++;
            }
        }
        System.out.println(group);
    }
    static boolean is_group(String str) {//aba
        boolean[] check = new boolean[26];
        Arrays.fill(check, false);
        int n = str.length();
        char c = str.charAt(0);//a
        check[c-'a'] = true;//a
        for(int i=1; i<n; i++) {
            if(c!=str.charAt(i)) {//a!=b, b!=a
                c = str.charAt(i);//b, a
                if(check[c-'a']) {
                    return false;
                }
                check[c-'a'] = true;//b
            }
        }
        return true;
    }
}