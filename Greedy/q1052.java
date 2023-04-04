/*
 * 같은 양의 물이 든 물병 두 개를 옮길 수 있다 -> 2진수
 */
import java.io.*;
import java.util.*;

public class q1052{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int res = 0;

        while(true){
            int tmp = N + res; // 총 물병
            int count = 0;
            while(tmp > 0){
                if(tmp % 2 != 0){ // 즉, 물의 양이 같지 않아 새 물병이 필요한 상황(물병이 남음)
                    count++; // 남은 물병 수++
                }
                tmp /= 2; // 물 담기
            }
            if(count <= K){ // 물이 차있는 물병 수 <= K
                break;
            }
            res++; // 새로 추가한 물병
        }
        System.out.println(res);        
    }
}