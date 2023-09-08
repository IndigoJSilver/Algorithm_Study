import java.io.*;

public class q2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[15][15];
            for(int j=0; j<15; j++) {
                arr[j][1] = 1; // 모든 1호
                arr[0][j] = j; // 모든 0층
            }
            for(int j=1; j<15; j++) { // 1~14층
                for(int l=2; l<15; l++) { // 2~14호
                    arr[j][l] = arr[j-1][l]+arr[j][l-1]; // 1,3 = 0,3 + 1,2
                }
            }
            sb.append(arr[k][n]).append('\n');
        }
        System.out.println(sb);
    }
}