/*
 * 8이 가장 적게 들어 있는 자연수의 8의 개수 출력
 * 이 코드에선 bw 사용해야함
 * 매우 작은 출력이나 표준 출력 스트림에서 출력하는 것이 적은 리소스만 사용하면 bw 객체 사용안 해도 되는데,
 * 출력 데이터가 많아지거나 표준 출력 스트림에서 출력을 많이하면 bw 객체 사용해야 컴파일 에러 방지 가능
 * 그러면 더 빠르고 효율적으로 출력을 수행할 수 있음
 * bw 사용하지 않고 정상적으로 실행된 것은 그 환경에서 출력 데이터를 버퍼링하지 않았기 때문.
 */

import java.util.*;
import java.io.*;

public class q1105{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열을 사용자가 지정한 구분자로 쪼개주는 클래스. 쪼개진 문자열은 토큰

        String L = st.nextToken();
        String R = st.nextToken();

        int count = 0;

        if(L.length() == R.length()){
            for(int i=0; i<L.length(); i++){
                if(L.charAt(i) != R.charAt(i)){
                    break;
                }else{
                    if(L.charAt(i) == '8'){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        bw.close();
    }
}