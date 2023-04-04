/*
 * comparable, comparator 인터페이스를 사용하여 정렬
 * comparable은 compareTo 메소드를 사용 - 자신과 매개변수 객체를 비교
 * comparator는 compare 메소드를 사용 - 두 매개뼌수 객체를 비교(파라매터 값이 두 개)
 * 
 * Arrays.sort(arr, new Comparator<>)는 이렇게 기본적으로 인자를 2개 받음
 * 보편적으로 인자를 1개를 쓸 경우, comparator는 디폴트값으로 적용되어 실행됨
 * 그러나 문자열을 정렬할 경우 따로 재정의가 필요
 */

import java.util.*;
import java.io.*;

public class q1181{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];

        for(int i=0; i<N; i++){
            str[i] = br.readLine();
        }
        Arrays.sort(str, new Comparator<String>() { // Arrays.sort()의 Comparator 재정의
            public int compare(String str1, String str2){ // Comparator에 있는 compare 오버 라이딩(Comparator에서 인터페이스로 정의되어 있는 함수를 재정의)
                if(str1.length() == str2.length()){ // 문자열 길이가 같은 경우
                    return str1.compareTo(str2); // 사전 순으로 정렬
                }
                else{ // 문자열 길이 순으로 정렬
                    return str1.length() - str2.length(); // 양수면 str1이 크고 음수면 str2가 큼
                }
            }
        });
        System.out.println(str[0]); // 맨 처음 문자열 출력
        for(int i=1; i<N; i++){
            if(!str[i].equals(str[i-1])){ // 다음 문자열부터 앞 문자열과 비교하여 같지 않으면 
                System.out.println(str[i]); // 출력
            }
        }
    }
}