/*
 * 정수 3개를 입력받아 오름차순으로 정렬 후 두 번째로 큰 수 출력
 */

import java.util.*;
import java.io.*;

public class q10817{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 정수 3개 입력받음
        }
        Arrays.sort(arr); // 오름차순 정렬
        System.out.println(arr[1]); // 두 번째로 큰 수 출력
    }
}