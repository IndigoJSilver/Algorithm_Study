/*
 * 사전순으로 출력해야하므로
 * hashmap보단 treemap을 사용하는 것이 낫다.
 * treemap은 입력과 동시에 오름차순으로 정렬해주기 때문.
 */

import java.util.*;
import java.io.*;

public class q4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st;

        TreeMap<String, Integer> tm = new TreeMap<>();
        String tree; // EOF 방지 위해 String 생성
        int count = 0; // 종이 차지하는 비율을 구해야 하니 종 개수를 센다
        /*
         * EOF 방지하는 다른 방식
         * while(true) {
            if(br.readLine() != null) { // EOF 방지. 마지막 문자 뒤에 EOF가 오는데, br.readLine()은 EOF를 null로 인지한다.
                // 그래서 null이 아닐 때, 값을 받아올 수 있도록 만든다.
                st = new StringTokenizer(br.readLine());
            }
            else { // 만약 null이라면 -> EOF
                break; // 나간다
            } 
        }
         */
        
        while((tree = br.readLine()) != null) { // EOF 방지
            tm.put(tree, tm.getOrDefault(tree, 0) + 1); // 굳이 st 안써도 됨. 왜냐면 한 문장에 하나의 값만 들어옴. -> map으로 처리 가능
            /*
             * default V getOrDefault(Object key, V defaultValue)
             * getOrDefault() 함수는 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환
             * tm.getOrDefault(tree, 0) + 1
             * tree(key)에 해당하는 키가 있으면, 찾는 키 값 반환하고 없으면 0을 반환.
             * 그리고 +1을 해준다. 왜냐면 키 값을 넣어주면서 중복키는 값을 1씩 증가시켜줘야 함.
             */
            count++;
        }
        for(Map.Entry<String, Integer> entry : tm.entrySet()) { // entrySet()은 key, value 모두 출력해줌
            System.out.println(entry.getKey() + ' ' + String.format("%.4f", Math.round((entry.getValue()*100.0/count)*10000)/10000.0));
        }
        /*
         * 단순히 값에 round 시키면 소수점 첫째자리에서 반올림 한다. 우리의 목적은 소수점 4째자리까지 반올림 하는 것.
         * 그러므로 계산 값에 10,000을 곱하여 소숫점 다섯번째 자리에서 반올림 하게 만든다. 그리고 원상복귀를 위해 다시 10,000을 나눈다.
         * 이때, 10,000.0으로 나눠야 한다.
         * 10,000으로 나누면 정수형이 되므로 -> 오답
         */
    }
}