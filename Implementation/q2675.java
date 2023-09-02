import java.io.*;

public class q2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String[] str = br.readLine().split(" ");
            int R = Integer.parseInt(str[0]);
            
            String str2 = str[1];
            //System.out.println(str2);
            // for(String res : str) {
            //     System.out.println(res);
            // }
            for(int j=0; j<str2.length(); j++) {
                for(int k=0; k<R; k++) {
                    System.out.print(str2.charAt(j));
                }
            }
            System.out.println();
        }
    }
}