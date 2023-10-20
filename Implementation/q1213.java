import java.io.*;

public class q1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        int odd = 0;
        int oddIdx = 0;
        String str = br.readLine();
        int len = str.length();
        for(int i=0; i<len; i++) {
            arr[str.charAt(i)-'A']++;
        }
        for(int i=0; i<26; i++) {
            if(arr[i]%2==1) {
                odd++;
                oddIdx = i;
            }
        }
        // 길이가 짝수인데 홀수개 알파벳 있으면 팰린드롬 x
        // 길이가 홀수인데 홀수개 알파벳이 하나라도 없으면 팰린드롬 x
        if(len%2==0 && odd>0 || len%2==1 && odd!=1) {
            sb.append("I'm Sorry Hansoo");
        } else {
            for(int i=0; i<26; i++) {
                for(int j=0; j<arr[i]/2; j++) {
                    sb.append((char)('A'+i));
                }
            }
            if(len%2==1) {
                sb.append((char)('A'+oddIdx));
            }
            for(int i=25; i>=0; i--) {
                for(int j=0; j<arr[i]/2; j++) {
                    sb.append((char)('A'+i));
                }
            }
        }
        System.out.println(sb);
    }
}