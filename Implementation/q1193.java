import java.io.*;

public class q1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int upper = 1, lower = 1, step = 1; // 분모, 분자, 층수
        for(int i=1; i<X; i++) {
            if(step%2==1) {
                if(lower==step) {
                    upper = 1;
                    lower = ++step;
                } else {
                    upper--;
                    lower++;
                }
            } else {
                if(upper==step) {
                    lower = 1;
                    upper = ++step;
                } else {
                    upper++;
                    lower--;
                }
            }
        }
        System.out.printf("%d/%d", upper, lower);
    }
}