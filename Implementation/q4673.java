import java.io.*;

public class q4673 {
    public static void main(String[] args) throws IOException {
        for(int i=1; i<10001; i++) {
            if(is_self(i)) {
                System.out.println(i);
            }
        }
    }
    static boolean is_self(int n) {
        for(int i=1; i<n; i++) {
            int sum = i;
            int t = i;
            while(t!=0) {
                sum += t%10;
                t/=10;
            }
            if(sum==n) {
                return false;
            }
        }
        return true;
    }
}