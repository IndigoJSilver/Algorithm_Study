import java.io.*;

public class q2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int[] arr = new int[9];
        for(int i=0; i<9; i++) {  
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max = arr[0];
        int maxI = 0;
        for(int i=1; i<9; i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxI = i;
            }
        }
        System.out.println(max);
        System.out.println(maxI+1);
    }
}