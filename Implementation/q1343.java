import java.io.*;

public class q1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n;) {
            if(str.charAt(i)=='.') {
                sb.append(".");
                i++;
            } else if(n-i>=4 && str.substring(i, i+4).equals("XXXX")) {
                sb.append("AAAA");
                i+=4;
            } else if(n-i>=2 && str.substring(i, i+2).equals("XX")) {
                sb.append("BB");
                i+=2;
            } else {
                sb.setLength(0); // stringbuilder 초기화
                sb.append(-1);
                break;
            }
        }
        System.out.println(sb);
    }
}