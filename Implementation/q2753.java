import java.io.*;

public class q2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if((N%4==0 && N%100!=0) || N%400==0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}