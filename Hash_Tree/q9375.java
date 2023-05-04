/*
 * hat, turban, x(알몸)
 * sunglasses, x(알몸)
 * 3 * 2 - 1(알몸) = 5
 * 종류+1 * 종류+1 - 1 이게 알몸이 아닌 상태로 의상 입을 수 있는 경우
 * 그래서 종류만 받아오면 됨. 옷 이름은 받아올 필요 없음.
 */

import java.util.*;
import java.io.*;

public class q9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int result = 1; 
        for(int i=0; i<T; i++){
            HashMap<String, Integer> hm = new HashMap<>();
            int N = Integer.parseInt(br.readLine());

            for(int j=0; j<N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 옷이름은 필요없으니 저장 안함
                String kind = st.nextToken(); // 옷 종류

                if(hm.containsKey(kind)) { // hm에 옷 종류가 있으면
                    hm.put(kind, hm.get(kind)+1); // 옷종류 가져와서+1(옷종류 개수 업데이트) 하고 hm에 (종류, 종류개수) 넣기
                }
                else { // hm에 옷 종류 없으면
                    hm.put(kind, 1); // 그냥 hm에 한개 넣어주기
                }
            }
            result = 1;
            for(Map.Entry<String, Integer> entry : hm.entrySet()) { // (key, value) pair를 entry라고 함
                result *= (entry.getValue()+1);
            }
            
            sb.append(result - 1).append('\n'); // 알몸 하나 빼야함
        }
        System.out.println(sb);
    }
}