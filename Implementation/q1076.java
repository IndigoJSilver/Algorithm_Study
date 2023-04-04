/*
 * hashmap을 사용해서 표를 만든다
 * string 형태로 값을 받아와 더하므로 str1 + str2의 값은 정수형이 아닌 문자열 형태
 * tmp를 형변환하여 숫자 형태로 만들어 str3의 곱과 곱한다
 */

import java.io.*;
import java.util.HashMap;

public class q1076{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, int[]> value = new HashMap<String, int[]>(){{
            put("black", new int[]{0, 1});
            put("brown", new int[]{1, 10});
            put("red", new int[]{2, 100});
            put("orange", new int[]{3, 1000});
            put("yellow", new int[]{4, 10000});
            put("green", new int[]{5, 100000});
            put("blue", new int[]{6, 1000000});
            put("violet", new int[]{7, 10000000});
            put("grey", new int[]{8, 100000000});
            put("white", new int[]{9, 1000000000});
        }};

        String str1, str2, str3;
        str1 = br.readLine();
        str2 = br.readLine();
        str3 = br.readLine();

        String tmp = "";
        tmp += value.get(str1)[0]; // 값을 받아온다
        tmp += value.get(str2)[0]; // 값을 받아온다
        long res = Long.parseLong(tmp) * value.get(str3)[1]; // 곱을 받아와 형변환 한 tmp와 더한다

        System.out.println(res);
    }
}