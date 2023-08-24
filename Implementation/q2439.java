import java.io.*;
import java.util.*;

public class q2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int j;
        for(int i=N-1; i>=0; i--) {
            for(j=0; j<i; j++) {
                System.out.print(" ");
            }
            for(int k=j; k<N; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}