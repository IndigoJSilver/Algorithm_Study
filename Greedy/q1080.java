/*
 * 두 행렬을 3*3 크기로 비교하여 바뀐 횟수 출력
 */

import java.util.*;

public class q1080{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int res = 0;

        char[][] A = new char[N][M];
        char[][] B = new char[N][M];

        for(int i=0; i<N; i++){
            String str = sc.next();
            A[i] = str.toCharArray();
        }

        for(int i=0; i<N; i++){
            String str = sc.next();
            B[i] = str.toCharArray();
        }

        for(int i=0; i<N-2; i++){
            for(int j=0; j<M-2; j++){
                if(A[i][j] == B[i][j]){
                    continue;
                }
                res++;
                for(int x=i; x<i+3; x++){
                    for(int y=j; y<j+3; y++){
                        A[x][y] = A[x][y] == '1' ? '0' : '1';
                    }
                }
            }
        }
        sc.close();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(A[i][j] != B[i][j]){
                    System.out.println((-1));
                    return;
                }
            }
        }
        System.out.println(res);
    }
}