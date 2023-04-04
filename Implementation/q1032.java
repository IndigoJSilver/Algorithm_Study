/*
 * 숫자를 입력받아 해당 숫자만큼 문자열을 입력하고 해당 문자열들을 비교하며 다르면 ? 같으면 그대로 출력
 * toCharArray()를 사용하여 String 문자열을 char형 배열로 반환하여 문자 하나하나 비교하는 방식을 사용
 * 첫 번째 입력받은 파일을 기준 파일로 삼고 for문으로 비교(N-1)
 * 기준 파일(file)과 입력받은 파일(arr)을 비교하여 다르면 ?
 */

import java.io.*;

public class q1032{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] file = br.readLine().toCharArray();

        for(int i=0; i<N-1; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j=0; j<file.length; j++){
                if(file[j] != arr[j]){
                    file[j] = '?';
                }
            }
        }
        System.out.println(file);
    }
}