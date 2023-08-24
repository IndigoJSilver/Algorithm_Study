import java.io.*;
import java.util.*;

public class q1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];
        String str = br.readLine();
        for(int i=0; i<str.length(); i++) {
            if('a'<=str.charAt(i) && 'z'>=str.charAt(i)) {
                arr[str.charAt(i) - 97]++;
            }
            else {
                arr[str.charAt(i) - 65]++;
            }
        }
        
        int ans = -1;
        char ch = '?';
        for(int i=0; i<26; i++) {
            if(arr[i]>ans) {
                ans = arr[i];
                ch = (char)(i+65);
            }
            else if(arr[i] == ans) {
                ch = '?';
            }
        }

        System.out.println(ch);
    }
}