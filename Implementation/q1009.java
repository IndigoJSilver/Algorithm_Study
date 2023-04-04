/*
 * 컴퓨터는 총 10개, 데이터는 총 a^b개
 * 데이터 처리하는 컴퓨터 번호 -> 데이터 % 10
 * 마지막 데이터가 처리될 컴퓨터의 번호는?
 * Math.pow로 하보았으나 메모리 초과, 그래서 결과값에 for문으로 b번 곱하였음
 */

import java.util.*;
import java.io.*;

public class q1009{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());

        int a, b, res;

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            res = 1;
            for(int j=0; j<b; j++){
                res = (res*a)%10;
                if(res == 0){
                    res = 10;
                }
            }
            System.out.println(res);
        }
    }
}