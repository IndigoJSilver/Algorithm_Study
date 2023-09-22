import java.io.*;

public class q15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String arr = br.readLine();
        long sum = 0;
        long pow = 1;
        for(int i=0; i<L; i++) {
            Character ch = arr.charAt(i);
            sum += (ch - 96) * pow;
            pow = (pow*31)%1234567891;
        }
        System.out.println(sum%1234567891);
    }
}