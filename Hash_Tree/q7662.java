/*
 * TreeMap-> 이진트리 기반으로 한 맵 컬렉션
 * firstKey(), lastKey()-> O(logN)
 * 키와 값이 저장된 Map, Entry를 저장
 * 트리맵에 객체를 저장하면 자동으로 정렬됨, 키는 저장과 동시에 자동 오름차순으로 정렬되고.
 * 숫자 타입일 경우에는 값으로, 문자열 타입일 경우에는 유니코드로 정렬
 * 해시맵보다 일반적으로 맵으로써의 성능 떨어짐.
 * 데이터를 저장할 때 즉시 정렬하기에 추가, 삭제가 해시맵보다 오래 걸림
 * but, 정렬된 상태로 맵을 유지해야하거나 정렬된 데이터를 조회해야하는 범위 검색 필요할 경우 좋음
 * firstKey()-> 최소 키, lastKey()-> 최대 키
 * 
 * Map - getOrDefault(Object key, V DefaultValue)
 * 찾는 키가 존재한다면 찾는 키의 값을 반환, 없다면 기본 값을 반환
 */

import java.io.*;
import java.util.*;

public class q7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> Q = new TreeMap<>();
            for(int j=0; j<k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if(c == 'I') {
                    Q.put(n, Q.getOrDefault(n, 0)+1);
                    /*
                     * TreeMap에 입력받은 n이 있다면 n의 값+1(n이 저장된 개수), 없다면 1 삽입.
                     * key는 중복될 수 없으나, 문제에서 중복 삽입이 가능하다고 함. 그래서 value로 구분.
                     */
                }
                else if(Q.isEmpty()) {
                    continue;
                }
                else { // c == 'D'
                    int key = n == 1 ? Q.lastKey() : Q.firstKey(); // key가 1이면 최대키
                    int cnt = Q.get(key); // 키의 값 가져오기

                    if(cnt == 1) { // 중복 check(중복 x)
                        Q.remove(key); // 키 제거
                    }
                    else { // 중복된 키(중복 정수 삽입된 경우)
                        Q.put(key, cnt-1); // 저장된 개수-1을 하여 다시 put
                    }
                }
            }
            if(Q.isEmpty()) {
                System.out.println("EMPTY");
            }
            else {
                System.out.println(Q.lastKey() + " " + Q.firstKey());
            }
        }
    }
}