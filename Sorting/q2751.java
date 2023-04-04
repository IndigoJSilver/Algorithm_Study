/*
 * 오름차순으로 정렬
 * Collections.sort()를 사용하여 정렬함
 * Collections.sort()는 Timsort()를 사용- 삽입정렬과 머지솔트를 결합하여 만든 방식
 * 평균 O(nlog(n)) 최악 O(nlog(n))
 * 이 문제의 경우 최악의 경우 Arrays.sort()를 사용하면 시간초과가 난다.
 * Arrays.sort() 최악의 경우 O(n^2)
 * Collections.sort()는 시간 효율면에선 Arrays.sort()보다 좋으나 공간복잡도면에선 떨어진다.
 * 
 * 선택정렬- O(n^2) 삽입정렬- O(n^2) 버블정렬- O(n^2) 합병정렬- O(nlog(n))
 * 퀵정렬- 평균;O(nlog(n)) 최악;O(n^2)
 * 
 * 그리고 출력으로 Stringbuilder를 이용해야 한다.
 * 단순히 리스트 출력 형태로 출력을 하면 시간 초과 됨
 * Stringbuilder는 기존의 데이터를 더하는 방식을 사용해서 속도도 빠르고 상대적으로 부하가 적다
 */

import java.io.*;
import java.util.*;

public class q2751{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            arr.add(Integer.parseInt(br.readLine())); // 숫자 5개 입력받음
        }
        Collections.sort(arr); // 오름차순 정렬

        for(int res: arr){
            sb.append(res).append('\n');
            /*
             * System.out.println(res); 형태로 출력을 하면 시간 초과.
             * 위 구문은 정렬된 숫자 리스트의 각 요소마다 호출, 즉 N번 호출된다.
             * 그래서 출력 속도가 늦어진다.
             * Stringbuilder는 출력 문자열을 만든 다음 한 번에 출력 그래서 속도 빠름.
             * 
             * System.out.println(res); 메서드를 호출할 때마다,
             * 해당 메서드는 콘솔에 출력하기 위한 I/O 작업을 수행한다.
             * 이 작업은 각 요소마다 수행되기 때문에 sb에 비해 느리다.
             * sb는 출력 문자열을 만든 다음 System.out.println(sb);을 사용해서 한 번에 출력하기 때문에,
             * I/O 작업이 한 번만 수행된다=> 더 빠르고 효율적.
             */
        }
        System.out.println(sb);
    }
}