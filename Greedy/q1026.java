/*
 * 최소의 결과값을 출력. 단 B는 재배열 불가능
 * 그러기 위해선 최소의 A와 최대의 B를 곱하여 더하면 된다
 */

import java.util.*;

public class q1026{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성 시 입력 스트림을 지정할 수 있음
        int N = sc.nextInt();
        int sum = 0;
        
        int[] A = new int[N];
        int[] B = new int[N];

        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }

        for(int i=0; i<N; i++){
            B[i] = sc.nextInt();
        }

        Arrays.sort(A); //sort() 함수는 배열원소를 정렬함. 
        Arrays.sort(B);

        for(int i=0; i<N; i++){
            sum += A[i]*B[N-1-i];
        }
        System.out.println(sum);
        sc.close();
    }
}