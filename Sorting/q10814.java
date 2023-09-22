import java.io.*;
import java.util.*;

public class q10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken(); // age
            arr[i][1] = st.nextToken(); // name
        }
        Arrays.sort(arr, new Comparator<String[]>() {
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]); // 나이 비교
            }
        });
        for(int i=0; i<N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}