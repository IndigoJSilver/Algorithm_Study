import java.io.*;

public class q1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if(str.equals("0")) {
                break;
            }
            boolean isPalin = true;
            for(int i=0; i<str.length()/2; i++) {
                if(str.charAt(i) != str.charAt(str.length()-1-i)) {
                    isPalin = false;
                }
            }
            if(isPalin) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}