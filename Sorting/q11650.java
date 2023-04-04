import java.util.*;

public class q11650{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] X = new int[N];
        int[] Y = new int[N];

        for(int i=0; i<N; i++){
            X[i] = sc.nextInt();
            Y[i] = sc.nextInt();
        }
        Arrays.sort(X);
        Arrays.sort(Y);
        for(int i=0; i<N; i++){
            System.out.print(X[i]);
            System.out.print(" ");
            System.out.println(Y[i]);
        }
        sc.close();
    }
}