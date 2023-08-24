import java.io.*;
import java.util.*;

public class q9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        if(90<=T && T<=100) {
            System.out.println("A");
        } else if(80<=T && T<=89) {
            System.out.println("B");
        } else if(70<=T && T<=79) {
            System.out.println("C");
        } else if(60<=T && T<=69) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}