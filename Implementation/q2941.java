import java.io.*;

public class q2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        int count = 0;
        for(int i=0; i<n; i++) {
            count++;
            if(str.charAt(i)=='c' && i+1<n && (str.charAt(i+1)=='=' || str.charAt(i+1)=='-')) {
                i++;
            } else if(str.charAt(i)=='d') {
                if(i+2<n && str.charAt(i+1)=='z' && str.charAt(i+2)=='=') {
                    i+=2;
                } else if(i+1<n && str.charAt(i+1)=='-') {
                    i++;
                }
            } else if(str.charAt(i)=='l' && i+1<n && str.charAt(i+1)=='j') {
                i++;
            } else if(str.charAt(i)=='n' && i+1<n && str.charAt(i+1)=='j') {
                i++;
            } else if(str.charAt(i)=='s' && i+1<n && str.charAt(i+1)=='=') {
                i++;
            } else if(str.charAt(i)=='z' && i+1<n && str.charAt(i+1)=='=') {
                i++;
            }
        }
        System.out.println(count);
    }
}