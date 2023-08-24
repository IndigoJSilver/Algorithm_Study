import java.io.*;

public class q10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        int[] arr = new int[26];
        for(int i=0; i<26; i++) {
            arr[i] = -1;
        }

        for(int i=0; i<S.length(); i++) {
            char ch = S.charAt(i);
            if(arr[ch-'a'] == -1) {
                arr[ch-'a'] = i;
            }
        }

        for(int res : arr) {
            System.out.print(res + " ");
        }
    }
}